package week02_part01;

public class Bird extends Animal
{
	private boolean hasFeathers = false;
	private boolean canFly = false;
	
	public Bird(boolean feathers, boolean flies)
	{
		hasFeathers = feathers;
		canFly = flies;
	}
	
	public void fly()
	{
		if (!canFly)
		{
			// this bird cannot fly so return
			// without outputting the message
			return;
		}
		System.out.println("Bird is flying!");
	}
	
	public void walk()
	{
		System.out.println("Bird is walking.");
	}
	
	public String toString()
	{
		String info = getSpecies() + " ";
		info += hasFeathers ? "has" : "does not have";
		info += " feathers and ";
		info += canFly ? "can" : "can not";
		info += " fly. ";
		return info;
	}
}
