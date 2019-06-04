package week02_part01.solution;

public class Mammal {
	private int age;
	private String hairType;


	public Mammal()
	{ 
		this.initialize(0, "none");
		System.out.println("Mammal() constructor called");
	}

	public Mammal(int old, String hair)
	{ 
		this.initialize(old, hair);
		System.out.println("Mammal(int, String) constructor called");
	}
	
	private void initialize(int old, String hair)
	{ 
		this.setAge(old);
		this.setHairType(hair);
	}
	
	public int getAge() 
	{ return age; }

	public void setAge(int newAge) 
	{ age = newAge; }
	
	public String getHairType() 
	{ return hairType; }

	protected void setHairType(String hair) 
	{ hairType = hair; }


	public String toString()
	{ 
		return "\nMammal�s age is "+ this.getAge() + ", hair is " + this.getHairType();
	}
}













