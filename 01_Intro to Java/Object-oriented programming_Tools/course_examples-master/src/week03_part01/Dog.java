package week03_part01;

public class Dog extends Mammal
{ 
	private String name;
	
	public Dog()
	{
		// QUESTION: What is the effect of excluding this default constructor?
	}
	public Dog(int newAge, String newName)
	{
		super(newAge);
		setName(newName);
	}
	
	private String getName() 
	{ return name; }
	
	private void setName ( String newName ) 
	{ name = newName; }
	
	public void printDog()
	{ 
		System.out.println ( getName() + " is a dog");
	}
	public void print()
	{ System.out.println("Inside Dog's version of print()"); }
}
