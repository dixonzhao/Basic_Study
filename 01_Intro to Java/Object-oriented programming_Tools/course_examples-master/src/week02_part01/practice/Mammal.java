package week02_part01.practice;

public class Mammal 
{
	private int age;

	public int getAge()
	{ 
		return age; 
	}

	protected void setAge( int newAge ) 
	{ 
		age = newAge; 
	}

	public Mammal()
	{ 
		this.setAge(162);
		System.out.println("Mammal() constructor called");
	}

	public Mammal(int age)
	{ 
		this.setAge(age);
		System.out.println("Mammal(int) constructor called");
	}

	public String toString()
	{ 
		return "Mammal's age is "+ this.getAge();
	}
}
