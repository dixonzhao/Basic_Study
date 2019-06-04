package week02_part01;

public class Mammal extends Animal
{
	private int age;

	private int getAge() 
	{	return age; }

	protected void setAge( int newAge ) 
	{ 	age = newAge; }

	public Mammal()
	{	this.setAge(162); }

	public Mammal(int age)
	{ 	this.setAge(age); }

	public String toString()
	{	return super.toString() + " age is "+ this.getAge(); }
}
