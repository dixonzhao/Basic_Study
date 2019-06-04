package week01_part02;

public class Mammal 
{
    // ---------------------------------
	// attribute(s) of class
    // ---------------------------------
	private int age;

    // ---------------------------------
    // constructors
    // ---------------------------------
   
    // explicit declaration of default constructor
	public Mammal()
	{ 
		this.setAge(162);
		System.out.println("Mammal() constructor called");
	}

    // declaration of a constructor with one parameter
	public Mammal(int age)
	{ 
		this.setAge(age);
		System.out.println("Mammal(int) constructor called");
	}

    // ---------------------------------
    // accessor and mutator methods
    // ---------------------------------
   
	private int getAge() 
	{ 
		return age; 
	}

	// modifies the age
	protected void setAge( int newAge ) 
	{ 
		age = newAge; 
	}

    // ---------------------------------
    // public methods
    // ---------------------------------
   
	// create string representation of parent class
	public String toString()
	{ 
		return "Mammal's age is "+ this.getAge();
	}
}
















