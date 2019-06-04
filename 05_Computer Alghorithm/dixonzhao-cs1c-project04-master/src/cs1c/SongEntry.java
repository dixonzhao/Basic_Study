package cs1c;
/**
 * One object of class SongEntry stores a simplified version of the genre data set from 
 * the Million Song Dataset.
 * http://labrosa.ee.columbia.edu/millionsong/blog/11-2-28-deriving-genre-dataset
 * 
 * @author CS1C, Foothill College, Bita Mazloom
 * @version 1.0
 */
public class SongEntry implements Comparable<SongEntry>
{
	// comparable tools
	public static final int SORT_BY_TITLE = 0;
	public static final int SORT_BY_DURATION = 1;
	public static final int SORT_BY_ARTIST = 2;
	public static final int SORT_BY_GENRE = 3;

	private static int sortKey; 

	private String title;
	private int duration;
	private String artist;
	private String genre;

	// default constructor
	protected SongEntry(String title, int duration, String artist_name, String genre)
	{
		this.title = title;
		setDuration(duration);
		this.artist = artist_name;
		this.genre = genre;
	}

	/**
	 * accessor method returns the title of the song
	 */
	public String getTitle() 
	{	return title; }

	/**
	 * accessor method returns the duration of a song in seconds
	 */
	public int getDuration() 
	{	return duration; }

	/**
	 * accessor method returns the artist name (could be space-delimited for first and last name)
	 */
	public String getArtistName() 
	{ 	return artist; }

	/**
	 * accessor method returns the genre of the song
	 */
	public String getGenre() 
	{ 	return genre; }

	/**
	 * mutator method sets the duration of the song or zero if invalid range
	 */
	public void setDuration(int duration)
	{
		if (this.duration < 0 || this.duration > Integer.MAX_VALUE)
			this.duration = 0;
		this.duration = duration;
	}

	/**
	 * mutator method specifies the entry to perform comparison
	 */
	public static boolean setSortType( int whichType )
	{
		switch (whichType)
		{
		case SORT_BY_TITLE:
		case SORT_BY_DURATION:
		case SORT_BY_ARTIST:
		case SORT_BY_GENRE:
			sortKey = whichType;
			return true;
		default:
			return false;
		}
	}

	/**
	 * we allow this to be defined by one field, not full identity - a choice
	 */
	public int compareTo(SongEntry other)
	{
		switch (sortKey)
		{
		case SORT_BY_TITLE:
			return (title.compareToIgnoreCase(other.title));
		case SORT_BY_DURATION:
			return (duration - other.duration);
		case SORT_BY_ARTIST:
			return (artist.compareToIgnoreCase(other.artist));
		case SORT_BY_GENRE:
			return (genre.compareToIgnoreCase(other.genre));
		default:
			return 0;
		}
	}

	/**
	 * string representation of the string in order of:
	 * title, duration, artist, genre
	 */
	public String toString()
	{
		return    title + ", " 
				+ TimeConverter.convertTimeToString(duration) + ", "
				+ artist + ", "
				+ genre;
	}
}