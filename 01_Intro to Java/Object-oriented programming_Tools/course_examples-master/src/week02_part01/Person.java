package week02_part01;

public class Person 
{
	private String name;
	private int age;

	public Person(String theName, int theAge) 
	{
		name = theName;
		age = theAge;
	}

	// sets the name of the spouse object to current name
	public void spouse(Person spouse)
	{ 
		spouse.setName(spouse.getName()+ " " + this.getName());
	}

	private String getName() 
	{	return this.name;	}
	
	private void setName(String name) 
	{	this.name = name;	}
	
	private int getAge() 
	{	return this.age;	}
	
	private void setAge(int age) 
	{	this.age = age;		}
	
	// adds 1 to the age of the Person that calls it, 
	// and returns this Person that calls it
	public Person older ()
	{ 
		setAge(getAge()+1);
		return this;
	}

	public void print() 
	{
		System.out.printf("%s is %d years old.", name, age);
	}
}
