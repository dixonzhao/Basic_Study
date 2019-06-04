package example;

import java.util.Calendar;

/**
 * One object of class MP3 stores a simplified version of a song's properties.
 * @author Foothill College, Bita M
 */
public class MP3 
{
	private String title;
	private String artist;
	private String genre;
	private int year = 0;
	
	/**
	 * Constructs a MP3 object with the specified name.
	 * @param name			The title of the MP3.
	 */	
	public MP3(String name)
	{
		this.title = name;
	}
	
	/**
	 * Accessor method returns the title of the song.
	 * @return the title
	 */
	public String getTitle()
	{	return title;  }
	
	/**
	 * Accessor method returns the artist of the song.
	 * @return the artist's name
	 */
	public String getArtist()
	{	return artist;  }
	
	/**
	 * Accessor method returns the genre of the song.
	 * @return the genre
	 */
	public String getGenre()
	{	return genre; }
	
	/**
	 * Accessor method returns the year of the song.
	 * @return the release year
	 */
	public int getYear()
	{	return year; }
	
	/**
	 * Mutator method sets the name of the artist
	 * @param artist			The name of the artist.
	 */
	public void setArtist(String artist)
	{	this.artist = artist;  }
	
	/**
	 * Mutator method sets the genre
	 * @param genre			The genre of the song.
	 */
	public void setGenre(String genre)
	{	this.genre = genre; }
	
	/**
	 * Mutator method sets the year of the song or this year if invalid range
	 * @param year			The release year of the song
	 */
	public void setYear(int year)
	{	
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if (year < 0 || year > currentYear)
			this.year = currentYear;
		else
			this.year = year; 
	}
	
	/**
	 * String representation of the string in order of:
	 * title, artist, genre, year
	 */
	public String toString()
	{
		String info = "";
		info += this.title;
		info += ", " + this.artist;
		info += ", " + this.genre;
		info += ", " + this.year;
		return info;
	}
}
