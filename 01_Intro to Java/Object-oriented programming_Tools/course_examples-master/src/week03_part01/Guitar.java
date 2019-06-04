package week03_part01;

public class Guitar extends Instrument implements Playable 
{
	private boolean isTuned;
	
	public Guitar()
	{
		super.setVolume(this.MUTEVOLUME);
		isTuned = false;
	}
	
	@Override
	public void play() 
	{
		super.setVolume(1);
		System.out.println("Playing Guitar at volume " + super.getVolume());	
	}

	@Override
	public void stop() 
	{
		super.setVolume(this.MUTEVOLUME);
	}

	@Override
	public void tune() 
	{
		isTuned = true;
	}

}
