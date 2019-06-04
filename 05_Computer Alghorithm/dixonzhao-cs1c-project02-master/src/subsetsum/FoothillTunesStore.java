package subsetsum;

import cs1c.MillionSongDataSubset;
import cs1c.SongEntry;
import cs1c.TimeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * An object of type FoothillTunesStore creates an object of type MillionSongDataSubset,
 * which in turn parses a JSON data set with a given file path. The parsed data set
 * is stored in an array of SongEntry objects.
 * Next, it reads prompts the user for a play list duration.
 * Uses an object of type SubsetSum to make a play list of SongEntry objects
 * that best match the given duration.
 * 
 * REMINDER:  Test your implementation against various budgets, including boundary cases.
 *
 * @author Foothill College, Bita M
 */
public class FoothillTunesStore 
{	
	/**
	 * Reads an input file that contains the prices of the different items.
	 * Then stores and outputs a list of items we can buy
	 * given the condition of how much money you have in your wallet.
	 * We're at a cash only store. So, no checks or credit purchases!
	 * @param args	Not used.
	 */
	public static void main(String[] args) 
	{
		// NOTE: Make sure to use *relative* path instead of specifying the entire path. 
		//       Otherwise, your program will result in run time errors when the instructor
		//       tests your implementation.
		final String FILEPATH = "resources/music_genre_subset.json";

		// parses the JSON input file
		MillionSongDataSubset msd = new MillionSongDataSubset(FILEPATH);
		
		// retrieves the parsed objects
		SongEntry [] allSongs = msd.getArrayOfSongs();

		ArrayList<SongEntry> songList = new ArrayList<SongEntry>(Arrays.asList(allSongs));
		// displays the number of songs read from the input file
		System.out.printf("Welcome! We have over %d in FoothillTunes store! \n", songList.size());
		
		
		// prompt for the duration 
		Scanner keyboard = new Scanner(System.in);
		do 
		{
			// REMINDER: Test your implementation against various durations, including boundary cases.
			System.out.println("\nEnter the duration of your play list:");
			
		} while(!keyboard.hasNextDouble());

		double duration = Double.parseDouble(keyboard.nextLine());

		// for measuring run time
		long startTime, estimatedTime;
		
		// capture the start time
		startTime = System.nanoTime();    

		// TODO: implement finding subset of groceries that is closest to meeting budget
		// NOTE: In this part, you only need to keep track of the price of each item,
		// 		 and not the name of the item you are buying.
		ArrayList<SongEntry> playlist = null;
		//SubsetSum.findSubsetOfSongs(songList, duration);

		// report algorithm time
		estimatedTime = System.nanoTime() - startTime;
		
		// report algorithm time
		System.out.println("\nAlgorithm Elapsed Time: "
				+ TimeConverter.convertTimeToString(estimatedTime));

		System.out.println("Songs in play list:");
		System.out.println(playlist);
		
		System.err.flush();
		System.out.println("Done with FoothillTunesStore.");
	}
}
