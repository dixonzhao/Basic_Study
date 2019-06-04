package week02_part01.solution;

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
			
			// check the x and y attributes
			if (x != o.x && y != o.y)
				return false;
			
			// now check the rgb attributes
			for (int i=0; i < rgb.length; i++)
			{
				if (o.rgb[i] != this.rgb[i])
					return false;
			}
			
			return true;
		} 
		
		// if we reach here then we can simply return,
		// no need for a redundant else condition.
		return false;
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






