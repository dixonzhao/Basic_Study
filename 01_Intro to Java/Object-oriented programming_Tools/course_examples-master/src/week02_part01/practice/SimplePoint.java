package week02_part01.practice;

public class SimplePoint 
{
	int x;	  // 	QUESTION: Do we need our attributes to be publically accessible by other classes?
	int y;
	int [] rgb;

	public SimplePoint()
	{
		x = 0;
		y = 0;

		rgb = new int[3];
		rgb[0] = 0;	// red
		rgb[1] = 0; // green
		rgb[2] = 0; // blue
	}

	public SimplePoint(int x, int y, int [] color)
	{
		this.x = x;
		this.y = y;

		rgb = new int[3];
		rgb[0] = 0;	// red
		rgb[1] = 0; // green
		rgb[2] = 0; // blue
	}

	// TODO: COMPLETE
	public boolean equals(Object other) 
	{
		if (other instanceof SimplePoint) 
		{
			SimplePoint o = (SimplePoint) other;
			return x == o.x && y == o.y;
		} 
		else 
		{
			return false;    
		}
	}

	public String toString()
	{
		String result;
		result = "" + x;
		result += ",";
		result += y;
		return result;
	}
}






