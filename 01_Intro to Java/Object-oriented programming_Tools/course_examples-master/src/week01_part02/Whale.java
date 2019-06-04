package week01_part02;

public class Whale extends Mammal
{ 
    // ---------------------------------
	// attribute(s) of class
    // ---------------------------------
	private double speed;
	
    // ---------------------------------
    // constructors
    // ---------------------------------
	
    // explicit declaration of default constructor
	public Whale() 
	{ 
		// implicitly calls the default Mammal constructor

		this.initialize(30.00);
		
		System.out.println ("Whale() constructor called");
	}
	
    // declaration of a constructor with two parameters
	public Whale(int a, double speed)
	{ 
		// explicitly calls the Mammal constructor with an int
		super(a); 	
		
		this.initialize (speed);
		
		System.out.println("Whale(int, double) constructor called");
	}
	
    // ---------------------------------
    // accessor and mutator methods
    // ---------------------------------
	private double getSpeed() 
	{ 
		return speed; 
	}

	private void setSpeed (double newSpeed) 
	{ 
		speed = newSpeed; 
	}
	
    // ---------------------------------
    // private methods
    // ---------------------------------
   
	private void initialize(double speed)
	{ 
		this.setSpeed(speed);
	}

    // ---------------------------------
    // public methods
    // ---------------------------------
  
	public String toString()
	{ 
		return super.toString() + ", and speed is " + this.getSpeed();
	}
}