package week01_part01;

public class Contractor {
	private String name;
	private int [] hoursWorked;
	private int totalHours;
	
	public Contractor() {
		name = "null";
		totalHours = 0;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	
	public void setHours(int[] paramArray)
	{
		// instantiate the array hoursWorked to the correct size
		hoursWorked = new int[paramArray.length];

		// copy values from parameter array to hoursWorked
		for(int index = 0; index < paramArray.length; index++) 
		{
			hoursWorked[index] = paramArray[index];
			totalHours += paramArray[index];  // or hoursWorked[index]
		}
	}
	
		
	public String toString() {
		String result = name + " " + totalHours;
		return result;
	}
}
