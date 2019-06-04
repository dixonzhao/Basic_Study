package week01_part01;

public class SimplePoint 
{
	int x;	  // 	QUESTION: Do we need our attributes to be publically accessible by other classes?
	int y;
	int [] rgb;

	// default constructor
	public SimplePoint()
	{
		x = 0;
		y = 0;
		
		rgb = new int[3];
		rgb[0] = 0;	// red
		rgb[1] = 0; // green
		rgb[2] = 0; // blue
	}
	
	// constructor with three parameters
	public SimplePoint(int x, int y, int [] color)
	{
		this.x = x;
		this.y = y;
		
		rgb = new int[3];
		rgb[0] = color[0];	// red
		rgb[1] = color[1]; // green
		rgb[2] = color[2]; // blue
	}
	
	public void setCoordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // ...

    public int[] getColor()
    {
        return this.rgb;
    }

    public String toString()
    {
        String strRep = "";
        strRep += "(" + x + "," + y + ")";
        strRep += " color: ";
        
        // Most likely color is in RGB which requires 3 indices,
        // but we don't want to make that assumption.
        for(int i = 0; i < rgb.length; i++)
        {
            strRep += rgb[i] + ",";
        }
        return strRep;
    }
}
