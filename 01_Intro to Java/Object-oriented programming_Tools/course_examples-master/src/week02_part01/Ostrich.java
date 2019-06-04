package week02_part01;


public class Ostrich extends Bird
{
	private double speed;
	
	/**
	 * Default constructor sets average running speed to 43.
	 */
	public Ostrich() 
	{	
		// call the Ostrich(int speed) constructor 
		// passing in 43 mph as average speed
		this(43);
	}
	
	/**
	 * Explicit constructor.
	 * @param speed		The running speed of the Ostrich.
	 */
	public Ostrich(int speed) 
	{
		// Since parent class does not have a default constructor (i.e. with no arguments),
		// then compiler requires that we explicitly call the parent's constructor.
		super(true, false);
		
		this.speed = speed;
		
		setSpecies("Ostrich");
	}
	
	public void walk()
	{
		System.out.printf("An ostrich can run at an average speed of %d mph! \n", speed);
	}
}
