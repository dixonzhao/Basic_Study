package week02_part01.practice;

public class Whale extends Mammal
{ 
	private double speed;
	
	private double getSpeed() 
	{ 
		return speed; 
	}

	private void setSpeed (double newSpeed) 
	{ 
		speed = newSpeed; 
	}
	
	private void initialize(double speed)
	{ 
		this.setSpeed(speed);
	}
	
	//Implicitly calls the default Mammal constructor
	public Whale() 
	{ 
		this.initialize(30.00);
		System.out.println ("Whale() constructor called");
	}
	
	public Whale(int a, double speed)
	{ 
		//Explicitly calls the Mammal constructor with an int
		super(a); 	
		
		this.initialize (speed);
		System.out.println("Whale(int, double) constructor called");
	}

	
	public String toString()
	{ 
		return super.toString() + ", and speed is " + this.getSpeed();
	}
}