package cs1c;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * One object of class MillionSongDataSubset parses a JSON data set and stores each entry in an array.
 * @author CS1C, Foothill College, Bita Mazloom
 * @version 1.0
 */
public class MillionSongDataSubset 
{
	private static final boolean ENABLE_DATA_OUTPUT = false;

	private SongEntry[] arrayOfSongs;

	/**
	 * One object of class FoothillTunesStore parses a JSON data set with a given json file
 * and stores each entry in an array 'tunes' and acts as a iTune song store. It provides 
 * methods showing all the songs in our personal tunes library, adding new songs in our 
 * tunes collection by title selection, making a play list of a certain duration.
 * 
 * 
	 * One object of class MillionSongDatSubset parses a JSON data set with a given file path.
	 * Stores each entry into a SongEntry object.
	 * @param jsonFilePath	The JSON file to parse.
	 */
	public MillionSongDataSubset(String jsonFilePath)
	{
		try 
		{
			// --------------------
			// parse the JSON file
			FileReader fileReader = new FileReader(jsonFilePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

			JSONArray allSongs = (JSONArray) jsonObject.get("songs");

			// --------------------
			// create an array of all the JSON objects
			arrayOfSongs = new SongEntry[allSongs.size()];

			Iterator<?> iterator = allSongs.iterator();
			int counter = 0;
			while (iterator.hasNext() && counter < arrayOfSongs.length) 
			{
				JSONObject currentJson = (JSONObject)iterator.next();
				String title = currentJson.get("title").toString();
				int duration = (int)Math.ceil(Double.parseDouble(currentJson.get("duration").toString()));
				String artist = currentJson.get("artist_name").toString();
				String genre = currentJson.get("genre").toString();

				SongEntry currentSong = new SongEntry(title, duration, artist, genre);
				arrayOfSongs[counter++] = currentSong;
			}	
		} // attempt to parse the input file
		catch (FileNotFoundException e) 
		{	e.printStackTrace(); } 
		catch (IOException e) 
		{	e.printStackTrace(); } 
		catch (ParseException e) 
		{	e.printStackTrace(); }

	}

	/**
	 * returns the array of song entries
	 */
	public SongEntry[] getArrayOfSongs()
	{	return arrayOfSongs; }

	/**
	 * displays the array of song entries
	 */
	public void printAllSongs()
	{
		for (SongEntry song : arrayOfSongs)
			System.out.println(song);
	}
}
