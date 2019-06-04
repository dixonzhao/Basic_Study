package week01_cs1a_review.solution;

public class TestString 
{
	public static void main(String[] args) 
	{
	    double width = 9.123456;

	    // The line below results in a compiler error.
	    // Instead use %f formatter
	    // System.out.printf("width = %.2d\n", width);	

	    // with 2 decimal positions
	    System.out.printf("width = %.2f\n", width);	

	    // then 1 decimal position,
	    System.out.printf("width = %.1f\n", width);	

	    // and finally 0 decimal positions.
	    System.out.printf("width = %.0f\n", width);	
	}
}
