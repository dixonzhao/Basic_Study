package week03_part01;

public class Person 
{
	private String name;
	private int age;
	
	public Person ()
	{ 
		this("default", 0 );
	}
	public Person ( String n, int a )
	{ 
		setName(n);
		setAge(a);
	}
	
	private String getName() { return name; }
	
	private void setName ( String n ) { name = n; }
	
	private int getAge() { return age; }
	
	private void setAge( int newAge ) { age = newAge ; }
	
	/**
	 * Sets the name of the spouse object to current name
	 * @param spouse
	 */
	public void spouse(Person spouse)
	{ 
		spouse.setName(spouse.getName()+ " " +this.getName());
	}
	
	/**
	 * Adds 1 to the age of the Person that calls it, and returns this Person that calls it
	 * @return current object
	 */
	public Person older ()
	{ 
		setAge(getAge()+1);
		return this;
	}
	
	public void print()
	{ System.out.println(getName() + "'s age is " + getAge()); }
}
