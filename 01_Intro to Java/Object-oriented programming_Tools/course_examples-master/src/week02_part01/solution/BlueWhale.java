package week02_part01.solution;

public class BlueWhale extends Whale
{
	int [] rgb;
	String name;
	
	public BlueWhale()
	{
		this(162, "Moby Dick");
		
		System.out.println ("BlueWhale() constructor called");
	}
	
    
	public BlueWhale(int old, String name)
	{
		super(old, 8.0 * 12.0);  // 8 feet * 12 inches
								
		rgb = new int[3];
		rgb[0] = 66;	// http://www.colorem.net/en/?color=blue-whale
		rgb[1] = 100;
		rgb[2] = 127; 
		
		this.name = name;
		
		System.out.println("BlueWhale(int, String) constructor called");
	}
	
    
	public int [] getColor()
	{	return rgb; }
	
	// QUESTION : Do we need a setter for rgb? If so, who will call it?
	
    
	public String getName()
	{ 	return this.name; }
	
	
    public void setName(String newName)
	{	this.name = newName; }
	
    
	public boolean equals(Object other)
	{
		if(other instanceof BlueWhale)
		{
			// Here, we only check if the name field of the two objects match
			// i.e. this.name and other.name
			boolean isSameName = this.name.equals(((BlueWhale) other).getName());
			return isSameName;
		}
		else
			return false;
	}
	
	
	public String toString()
	{ 
		return name + super.toString();
	}
}
