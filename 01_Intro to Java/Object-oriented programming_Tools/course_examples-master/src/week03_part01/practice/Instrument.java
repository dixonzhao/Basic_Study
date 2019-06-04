package week03_part01.practice;

public abstract class Instrument 
{
	public int volume;
	
	public abstract void tune();

	public void setVolume(int volume)
	{
		this.volume = volume;
	}
	
	public int getVolume()
	{
		return this.volume;
	}
}
