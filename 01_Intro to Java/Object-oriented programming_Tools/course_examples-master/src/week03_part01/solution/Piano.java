package week03_part01.solution;

public class Piano extends Instrument
{
	public static final String [] STYLES = { "Grand", "Vertical", "Electric"};
	
	private String style;
	private String type;
	private boolean isTuned;

	public Piano(String style, String type)
	{
		super.volume = 500;
		
		this.style = style;
		this.type = type;
		
		if (this.style.equals("Electric"))
			isTuned = true;
		else
			isTuned = false;
	}

	public boolean isTuned()
	{	return isTuned; }
	
	@Override
	public void tune() 
	{
		isTuned = true;
	}
}
