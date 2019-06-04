package week03_part01;

public class StandardCar extends MotorVehicle implements Drivable
{
	protected double currentSpeed;
	private String make;

	public StandardCar(String make)
	{
		maxSpeed = 170;
		this.currentSpeed = 0;
		this.make  = make;
	}

	public void start()
	{	/*...*/    }

	public void turn()
	{	/*...*/    }

	public void backup()
	{	/*...*/    }

	public void stop()
	{	this.currentSpeed = Drivable.STOPSPEED; }

	public void setSpeed(int speed)
	{
		if (speed > maxSpeed)
		{
			this.currentSpeed = maxSpeed;
			return;
		}
		this.currentSpeed = speed;
	}
	
	public void run()
	{	System.out.println("Cruising down the freeway at " + this.currentSpeed + " mph."); }
	
	public String toString()
	{	return "StandardCar: " + make; }
}
