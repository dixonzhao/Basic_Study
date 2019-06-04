package week03_part01;

public abstract class MotorVehicle 
{
	private static int count;
	protected int maxSpeed;

	public MotorVehicle()
	{
		count++;
	}
	

	public int getCount()
	{	return count; }
	
	public int getSpeed()
	{
		return maxSpeed;
	}
	
	public abstract void run();
	
	public abstract String toString();
}
