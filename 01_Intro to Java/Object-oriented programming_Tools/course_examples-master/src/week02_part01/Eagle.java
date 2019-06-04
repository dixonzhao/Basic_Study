package week02_part01;

public class Eagle extends Bird
{
	public int soaringHeight;
	
	public Eagle(int soaringHeight) 
	{
		// Since parent class does not have a default constructor (i.e. with no arguments),
		// then compiler requires that we explicitly call the parent's constructor.
		super(true, true);
		
		this.soaringHeight = soaringHeight;
		
		setSpecies("Eagle");
	}
	
	public void fly()
	{
		System.out.printf("Eagle is soaring at a height of %d meters. \n", soaringHeight);
	}
	
	public String toString()
	{
		return "Eagle's average soaring height is " + soaringHeight;
	}
}
