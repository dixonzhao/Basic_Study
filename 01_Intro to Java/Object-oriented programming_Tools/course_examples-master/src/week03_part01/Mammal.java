package week03_part01;

public class Mammal 
{
	private int age;
	
	public Mammal()
	{
		
	}
	public Mammal(int newAge)
	{
		this.setAge(newAge);
	}
	
	private int getAge() 
	{ return age; }
	
	private void setAge( int newAge) 
	{ age = newAge; }
	
	public void printMammal()
	{ 
		System.out.println ("doing the Mammal thang at age = " + getAge());
	}
	
	public void print()
	{ System.out.println("Inside Mamal's version of print()"); }
}
