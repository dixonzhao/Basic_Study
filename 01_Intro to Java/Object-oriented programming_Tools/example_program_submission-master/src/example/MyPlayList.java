package example;


import java.util.Scanner;

/** 
 * Allows the user to create a playlist of songs by searching or directly adding.
 * Includes main() for running the application.
 * @author Foothill College, Bita M
 *
 */
public class MyPlayList 
{
	private static MyTunes myMusic = null;
	private MP3 [] tracks = null;

	/**
	 * Resizes the array of MP3 objects based on parameter. 
	 * The new array includes previous entries.
	 * @param numSongs			New maximum number of MP3s the playlist can keep track of.
	 * @return 					The next available position in playlist.
	 */
	private int resizeTrackArray(int numSongs)
	{	
		int addPos = 0;
		if (tracks == null)
		{
			tracks = new MP3[numSongs];
		}
		else
		{
			MP3 [] oldTracks = tracks;
			MP3 [] newTracks = new MP3[oldTracks.length + numSongs];
			for (int i = 0; i < oldTracks.length; i++)
				newTracks[addPos++] = oldTracks[i];
			tracks = newTracks;
		}
		
		return addPos;
	}
	
	/**
	 * Adds an array of song names to next available position in playlist.
	 * @param requests			An array of MP3 titles
	 */
	public void addSongsByID(String [] requests)
	{	
		if (requests == null || requests.length == 0)
			return;
				
		// Note: A hack since we're using arrays which are inefficient
		int numSongsToAdd = 0;
		for (int i = 0; i < requests.length; i++)
		{
			if (requests[i] == null)
				break;
			numSongsToAdd++;
		}
		
		int addPos = resizeTrackArray(numSongsToAdd);
		
		for (int i = 0; i < numSongsToAdd; i++)
		{
			int requested = new Integer(requests[i]);
			MP3 current = myMusic.getMP3(requested);
			
			// Using previous addPos
			tracks[addPos++] = current;
		}
	}

	/**
	 * Adds an array of MP3s to next available position in playlist.
	 * @param requests			An array of MP3s.
	 */
	public void addMP3s(MP3 [] requests)
	{		
		if (requests == null || requests.length == 0)
			return;
		
		// Note: A hack since we're using arrays which are inefficient
		int numSongsToAdd = 0;
		for (int i = 0; i < requests.length; i++)
		{
			if (requests[i] == null)
				break;
			numSongsToAdd++;
		}
	
		int addPos = resizeTrackArray(numSongsToAdd);

		for (int i = 0; i < numSongsToAdd; i++)
		{
			MP3 current = requests[i];
			
			// Using previous addPos
			tracks[addPos++] = current;
		}
	}
	
	/**
	 * Outputs the string representation the playlist.
	 */
	public void printPlayList()
	{
		if (tracks == null)
		{
			System.out.println("empty\n");
			return;
		}
		
		for (int i = 0; i < tracks.length; i++)
		{
			System.out.println(tracks[i]);
		}
		System.out.println("\n");
	}
	
	/**
	 * Provides a text based user interface for simulating creating and modifying a PlayList.
	 */
	public static void main(String[] args) 
	{
		MyPlayList favsList = new MyPlayList();

		System.out.println("Current tunes in library:");
		myMusic = new MyTunes();
		myMusic.printLibrary();
		
		int selection;
		
		do
		{
			// menu
			System.out.println("\nWhat would you like to do?");
			System.out.println("  1. add songs");
			System.out.println("  2. print library");
			System.out.println("  3. print playlist");
			System.out.println("  4. search for a song by artist in library");
			System.out.println("  5. search for a song by title and artist in library");
			System.out.println("  6. search for a song by genre and year in library");
			System.out.println("  7. Quit");
			System.out.println("Enter your selection:");

			Scanner keyboard = new Scanner(System.in);
			selection = Integer.parseInt(keyboard.nextLine());

			switch( selection )
			{
			case 1:
				System.out.println("Enter song numbers [for example: 1,2,3] to add to playlist:");
				String songNumbers = keyboard.nextLine();
				String [] requests = songNumbers.split(",");
				favsList.addSongsByID(requests);
				break;
				
			case 2:
				System.out.println("Print Library:");
				myMusic.printLibrary();
				break;
				
			case 3:
				System.out.println("Print playlist:");
				favsList.printPlayList();
				break;

			case 4:
				System.out.println("Enter artist [for example: Moby] to add to playlist:");
				String requestedArtist = keyboard.next();
				MP3 [] searchResult = myMusic.search(requestedArtist);
				MyTunes.printSearchResult(searchResult);
				favsList.addMP3s(searchResult);
				break;

			case 5:
				System.out.println("Enter title and artist [for example: Hymn,Moby] to add to playlist:");
				String [] input = (keyboard.nextLine()).split(",");
				String requestedTitle = input[0];
				requestedArtist = input[1];
				searchResult = myMusic.search(requestedArtist, requestedTitle);
				MyTunes.printSearchResult(searchResult);
				favsList.addMP3s(searchResult);
				break;

			case 6:
				System.out.println("Enter year and genre [for example: Electronica,1995] to add to playlist:");
				input = (keyboard.nextLine()).split(",");
				int requestedYear = new Integer(input[0]);
				String requestedGenre = input[1];
				searchResult = myMusic.search(requestedYear, requestedGenre);
				MyTunes.printSearchResult(searchResult);
				favsList.addMP3s(searchResult);
			default:
			} // switch
		} while (selection != 5);
		
		System.out.println("Goodbye.");
	}
}
