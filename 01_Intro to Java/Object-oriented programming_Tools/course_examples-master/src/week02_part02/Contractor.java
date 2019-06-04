package week02_part02;

public class Contractor 
{
	private String name;
	private double [] hoursWorked;
	private double totalHours;
	
	public Contractor() 
	{
		setName("null");
		totalHours = 0;
	}
	
	public void setName(String newName) 
	{  name = newName; }
	
	
	public void setHours(double[] array)
	{
		// instantiate the array hoursWorked to the correct size
		hoursWorked = new double[array.length];

		// copy values from parameter array to hoursWorked
		for(int index = 0; index < array.length; index++) 
		{
			hoursWorked[index] = array[index];
			totalHours += array[index];  // or hoursWorked[index]
		}
	}
	
	public double getHourOnDay(int dayNum)
	{
		if (dayNum > hoursWorked.length)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return hoursWorked[dayNum];
	}
	
	public String toString() 
	{	return name + " " + totalHours; }
}





