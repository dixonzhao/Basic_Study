package week01_part02;

class Sheep extends Mammal 
{
    // ---------------------------------
	// attribute(s) of class
    // ---------------------------------
        
    private String name = "sheep";
    
    private int speed = 20;

    // ---------------------------------
    // constructors
    // ---------------------------------
   
    // declaration of a constructor with two parameters
    public Sheep(int age, String name)
    {
    	this.name = name;
    }
    
    // ---------------------------------
    // accessor and mutator methods
    // ---------------------------------
   
    public int getSpeed()
    {    return this.speed; }

    // ---------------------------------
    // public methods
    // ---------------------------------
   
    public String toString() 
    { 
        return this.name + " can run at " + this.getSpeed();
    }
    
    
    public static void main(String [] args)
    {
        Mammal george = new Mammal(5);
        Sheep shaun = new Sheep(7, "Shaun");
        
      // invokes setAge() of class Mammal
      shaun.setAge(5);
        
        System.out.println("Overriding:");
		// a)
		System.out.println(george.toString());

		// b
		System.out.println(shaun.toString());

		// c
		System.out.println(shaun);

		// d
		System.out.println(george);
    }
}
