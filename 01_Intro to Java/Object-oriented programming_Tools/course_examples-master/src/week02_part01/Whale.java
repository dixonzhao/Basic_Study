package week02_part01;

public class Whale extends Mammal
{ 
	private double speed;
	
	// implicitly calls the default Mammal constructor
	public Whale() 
	{ 
		// implicitly calls the default constructor of the super class

		this.initialize(30.00);
	}
	
	public Whale(int a, double speed)
	{ 
		//Explicitly calls the Mammal constructor with an int
		super(a); 	
		
		this.initialize (speed);
		
		setSpecies("Whale");
	}

	private double getSpeed() 
	{ 	return speed; }

	private void setSpeed (double newSpeed) 
	{ 	speed = newSpeed; }
	
	private void initialize(double speed)
	{ 	this.setSpeed(speed);}
	
	public String toString()
	{ 
		return super.toString() + ", and speed is " + this.getSpeed();
	}
}