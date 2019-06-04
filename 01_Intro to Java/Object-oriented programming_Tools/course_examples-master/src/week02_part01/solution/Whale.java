package week02_part01.solution;

public class Whale extends Mammal
{ 
	private double flipperSize;
	
	//Implicitly calls the default Mammal constructor
	public Whale() 
	{ 
		// 1. Implicitly calls the default Mammal constructor

		// 2. Calls constructor Whale(int, double)
		this(0, 0);

		System.out.println ("Whale() constructor called");
	}
	
	public Whale(int old, double flipper)
	{ 
		// Explicitly calls the Mammal constructor with an int, String
		super(old, "short"); 	
		
		if (old > 1)
			super.setHairType("lost");
			
		this.setFlipperSize(flipper);
		
		System.out.println("Whale(int, double) constructor called");
	}
	
	public double getFlipperSize() 
	{ 	return flipperSize; }

	protected void setFlipperSize (double flipper) 
	{ 	flipperSize = flipper; }

	public void swim()
	{	System.out.println("swimming..."); };
	
	public String toString()
	{ 
		return super.toString() + ", and flipper size is " + this.getFlipperSize();
	}
}












