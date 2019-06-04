package week03_part01;

public class BasicCar extends MotorVehicle
{
	private String make;
	private int currentSpeed;
	
	public BasicCar(String make) 
	{
		maxSpeed = 160;
		this.make = make;
	}

	public void setSpeed(int speed) {
		if (speed > maxSpeed) {
			this.currentSpeed = maxSpeed;
			return;
		}
		this.currentSpeed = speed;
	}
	
	public void run() 
	{
		System.out.println("Cruising down the freeway in my " + make + " at " + this.currentSpeed + " mph.");		
	}	
	
	
	public String toString()
	{	return "BasicCar: " + make; }
}
