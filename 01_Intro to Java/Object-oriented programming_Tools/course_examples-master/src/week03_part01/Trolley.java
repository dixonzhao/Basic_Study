package week03_part01;

/*
 * Class Trolley must define the implementation of all methods of interface Drivable
 */
public class Trolley implements Drivable 
{
	private double speed;
	private int maxPassengerCount;
	private int currentPassengerCount;
	
	public Trolley(int maxPassengers)
	{
		this.maxPassengerCount = maxPassengers;
		this.currentPassengerCount = 0;
	}
	
	public void addPassenger()
	{		
		if ( (currentPassengerCount + 1) > maxPassengerCount)
		{
			System.out.println("Cannot take anymore passengers.");
			System.out.println("Sorry for the inconvenience.");
			return;
		}
	
		this.speed = Drivable.STOPSPEED;
		System.out.println("Welcome abroad.");
		this.start();
	}
	
	@Override
	public void start() {
		speed = 40;	// miles per hour
		
	}

	@Override
	public void turn() {
		speed = 10;
		
	}

	@Override
	public void backup() 
	{ speed = 5; }

	@Override
	public void stop() 
	{ this.speed = Drivable.STOPSPEED; }

}
