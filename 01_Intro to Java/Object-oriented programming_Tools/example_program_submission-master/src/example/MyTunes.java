package example;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * One object of class MyTunes parses a CSV file.
 * Each row is stored as an entry in an array of MP3 objects.
 * Includes main() for debugging.
 * @author Foothill College, Bita M
 *
 */
public class MyTunes 
{
	public static final String INFILE_SONGS = "resources/songs.csv";

	private MP3[] library = null;

	/**
	 * Constructs a MyTunes object based on the input file and
	 * creates an array of MP3 objects.
	 */
	public MyTunes()
	{
		String [][] properties = readSongs(INFILE_SONGS);
		makeMP3s(properties);
	}


	/**
	 * Reads a CSV file and creates a 2D array of strings with the properties of all songs.
	 * Format of file is:
	 * ROWS value COLS value
     * title,artist,genre,year
     * title,artist,genre,year
     * etc.
	 *
	 * @param filename			Name of the input CSV file.
	 * @return      			2D array of strings with the properties of each song
	 */	
	private String[][] readSongs(String filename)
	{
		File infile = new File (filename);
		Scanner input = null;

		String [][] songs = null;

		try 
		{
			// Creates an object of type scanner
			input = new Scanner (infile);

			String line;
			int numSongs = 0;
			int numProperties = 0;

			// -----------------
			// read the first line which stores how many entries of songs we have
			line = input.nextLine();

			// create a Pattern instance from a regular expression
			String re = "ROWS (.+?),COLS (.+?)";
			Pattern pattern = Pattern.compile(re);

			Matcher matcher = pattern.matcher(line);
			if (matcher.find())
			{
				// group 1 is "8"
				numSongs = new Integer(matcher.group(1));

				// group 2 is "4"
				numProperties = new Integer(matcher.group(2));
			}

			songs = new String[numSongs][numProperties];


			// Now read the rest of the file upto N ROWS
			// Note: we're assuming the file has at most N+1 lines
			int count = 0;

			// Stops reading when one of two conditions is met:
			// there are no more lines in the file
			// the variable count is more than the allowable times to read from file.
			while (input.hasNextLine() && count < numSongs)
			{
				// read a row and add the entry to the songs
				line = input.nextLine();
				String [] properties = line.split(",");
				for (int property = 0; property < numProperties; property++)
				{
					songs[count][property] = properties[property];
				}

				count++;
			}
		} 

		catch (FileNotFoundException someobject) 
		{
			// If not successful in creating an object of type scanner. 
			// Then, the statement
			// count = 0
			// is never reached; and the program jumps to the "catch" block
			System.out.println("ERROR: File " + filename + " not found!");

			// NOTE: The message returned by the exception object is similar to ours above. 
			System.out.println("Stack trace resulting in error: " + someobject.getMessage());

			// Prints out what part of the code an exception is thrown.
			// QUESTION: What happens when the file does not exist and you comment the below?
			someobject.printStackTrace();
		}

		finally
		{		
			if (input != null)
				input.close();
		}

		return songs;
	}

	/**
	 * Constructs an array of MP3 objects.
	 * @param name			The title of the MP3.
	 * @return mp3 array	A 1D array o MP3 objects.
	 */	
	private MP3[] makeMP3s(String [][] songProperties)
	{						
		library = new MP3[songProperties.length];
		for(int i = 0; i < songProperties.length; i++)
		{
			String [] entry = songProperties[i];
			MP3 song = new MP3(entry[0]);
			song.setArtist(entry[1]);
			song.setGenre(entry[2]);
			song.setYear(Integer.parseInt(entry[3]));	
			library[i] = song;
		}
		return library;
	}

	/**
	 * Accessor method returns an array of MP3s.
	 * @return the array of MP3 objects in the library
	 */
	public MP3[] getSongs()
	{	return library; }
	
	
	/**
	 * Accessor method returns a specific MP3 given an requested ID. 
	 * The ID is simply the index of the MP3.
	 * @return an MP3 entry
	 */
	public MP3 getMP3(int requested)
	{	return library[requested];	}

	
	/**
	 * Accessor method returns the number of MP3s in the library, zero otherwise.
	 * @return max MP3 index + 1
	 */
	public int getMaxID()
	{	
		if (library == null)
			return 0;
		
		return library.length; 
	}

	/**
	 * String representation of all MP3s in library.
	 */
	public void printLibrary()
	{		
		int id = 0;
		for (MP3 song : library)
		{
			System.out.println(id++ + ", " + song);			
		}
	}
	
	/**
	 * Array of MP3 object which have specific artist as a property.
	 * @param artist		name of artist
	 * @return 				1D array of MP3 objects
	 */
	public MP3 [] search(String artist)
	{
		// Note: at worst the maximum number of returned songs is the length of the library
		//       Inefficient. Consider using java.util.ArrayList instead.
		MP3 [] foundSongs = new MP3[library.length];
		int numFound = 0;
		for (int i = 0; i < library.length; i++)
		{
			MP3 current = library[i];

			String currentArtist = library[i].getArtist();

			if (currentArtist.equals(artist))
				foundSongs[numFound++] = current;			
		}

		if (numFound == 0)
			return null;
		return foundSongs;
	}

	/**
	 * Array of MP3 object which have specific artist as a property.
	 * @param artist		name of artist
	 * @param title			name of the MP3
	 * @return 				1D array of MP3 objects
	 */
	public MP3[] search(String artist, String title)
	{
		// Note: at worst the maximum number of returned songs is the length of the library
		//       Inefficient. Consider using java.util.ArrayList instead.
		MP3 [] foundSongs = new MP3[library.length];
		int numFound = 0;
		
		for (int i = 0; i < library.length; i++)
		{
			MP3 current = library[i];

			String currentTitle = library[i].getTitle();

			String currentArtist = library[i].getArtist();

			if (currentTitle.equals(title) && currentArtist.equals(artist))
				foundSongs[numFound++] = current;			
		}

		if (numFound == 0)
			return null;
		return foundSongs;
	}

	/**
	 * Array of MP3 object which have specific artist as a property.
	 * @param year			year MP3 was released
	 * @param genre			genre of MP3
	 * @return 				1D array of MP3 objects
	 */
	public MP3 [] search(int year, String genre)
	{
		// Note: at worst the maximum number of returned songs is the length of the library
		//       Inefficient. Consider using java.util.ArrayList instead.
		MP3 [] foundSongs = new MP3[library.length];
		int numFound = 0;
		
		for (int i = 0; i < library.length; i++)
		{
			MP3 current = library[i];

			int currentYear = library[i].getYear();

			String currentGenre = library[i].getGenre();

			if (currentYear == year && currentGenre.equals(genre))
				foundSongs[numFound++] = current;			
		}

		if (numFound == 0)
			return null;
		return foundSongs;
	}
	
	/**
	 * Outputs the string representation of 1D array of MP3s
	 * @param searchResult		1D array of MP3 objects
	 */
	public static void printSearchResult(MP3 [] searchResult)
	{
		if (searchResult == null)
		{
			System.out.println("Search result is empty");
		}
		else
		{
			for (MP3 found : searchResult)
			{
				if (found == null)
					return;
				System.out.println(found);
			}
		}
	}
	
	/**
	 * Includes test examples for class MyTunes.
	 */
	public static void main(String [] args)
	{
		System.out.println("Welcome to MyTunes!");
		MyTunes myMusic = new MyTunes();

		System.out.println("Songs to choose from:");
		myMusic.printLibrary();

		Random randomGenerator = new Random();
		
		int requested = randomGenerator.nextInt(myMusic.getMaxID());
		System.out.println("\nTEST : adding song #" + requested + " to create mp3 [valid entry 0 to " + myMusic.getMaxID() + "] :");
		MP3 firstMP3 = myMusic.getMP3(requested);
		System.out.println(firstMP3);

		requested = randomGenerator.nextInt(myMusic.getMaxID());
		System.out.println("\nTEST : adding song #" + requested + " to create mp3 [valid entry 0 to " + myMusic.getMaxID() + "] :");
		MP3 secondMP3 = myMusic.getMP3(requested);
		System.out.println(secondMP3);
		
		requested = randomGenerator.nextInt(myMusic.getMaxID());
		MP3 thirdMP3 = myMusic.getMP3(requested);
		String artistName = thirdMP3.getArtist();
		System.out.println("\nTEST : Search artist to add to playlist:");
		String requestedArtist = artistName;
		System.out.println("Requested: " + requestedArtist);
		MP3 [] searchResult = myMusic.search(requestedArtist);
		printSearchResult(searchResult);
		
		String title = thirdMP3.getTitle();
		System.out.println("\nTEST : Search title and artist to add to playlist:");
		String requestedTitle = title;
		System.out.println("Requested: " + requestedTitle);
		searchResult = myMusic.search(requestedTitle, requestedArtist);
		printSearchResult(searchResult);
		
		title = "TITLE-DOES-NOT-EXIST";
		System.out.println("\nTEST : Search title and artist to add to playlist:");
		requestedTitle = title;
		System.out.println("Requested: " + requestedTitle + " " + requestedArtist);
		searchResult = myMusic.search(requestedTitle, requestedArtist);
		printSearchResult(searchResult);
		
		
		System.out.println("Done.");
	}
}
