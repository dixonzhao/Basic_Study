package week03_part01.solution;

//class MP3Player
public class MP3Player implements Playable
{
	private final int MAXNUMSONGS = 10;
	private boolean isCharged;
	private String brand;
	private String [] songs;


	public MP3Player(String brand)
	{
		isCharged = false;
		songs = new String[MAXNUMSONGS];

		this.brand = brand;
	}


	public void charge()
	{
		isCharged = true;
	}


	public void play()
	{
		System.out.println("Playing your song");
	}


	public void stop()
	{
		System.out.println("Stopping...");
	}

	public String toString()
	{
		String str = brand + ".";
		if (!this.isCharged)
			return str + " Need to charge. Goodbye.";
		str += " battery full.";
		str += " Capacity " + this.songs.length + " songs.";
		return str;
	}
}

// Example output:
/*
zune. Need to charge. Goodbye.
zune. battery full. Capacity 10 songs.
Playing your song.
*/



