package week03_part01;

public class Bus extends MotorVehicle
{
	private String make;
	protected int passengers;
	
	public Bus(String make, int numPassengers) 
	{
		maxSpeed = 65;
		this.make = make;
		this.passengers = numPassengers;
	}

	public void run() 
	{
		System.out.println("Delivering " + this.passengers + " passengers to their desitinations.");		
	}	
	
	public String toString()
	{	return "Bus: " + make; }
}
