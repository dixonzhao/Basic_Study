package week03_part01;

/*
 * Class Motorcycle must define the implementation of all methods of interface Drivable
 */
public class Motorcycle extends MotorVehicle implements Drivable 
{
	private String make;
	private double speed;

	public Motorcycle(String make)
	{
		this.make = make;
	}
	
	@Override
	public void start() {
		speed = 80;	
	}

	@Override
	public void turn() {
		speed = 45;
	}

	@Override
	public void backup() {
		speed = 1;
	}

	@Override
	public void stop() {
		speed = Drivable.STOPSPEED;
	}
	
	public void run()
	{
		System.out.println("Motorcycle: running...");
	}
	
	public String toString()
	{
		return "Motorcycle: " + make + " speed is " + speed;
	}
}




