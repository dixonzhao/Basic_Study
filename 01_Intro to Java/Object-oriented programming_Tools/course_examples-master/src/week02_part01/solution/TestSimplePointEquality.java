package week02_part01.solution;

public class TestSimplePointEquality 
{

	public static void main(String[] args) 
	{
		int [] colorBlue = {0, 0, 255};

		SimplePoint pt1;
		SimplePoint pt2;

		pt1 = new SimplePoint (100, 200, colorBlue);
		pt2 = new SimplePoint (100, 200, colorBlue);

		// QUESTION 1: What happens when comparing via == ?
		if ( pt1 == pt2)
			System.out.println("They are equal!");
		else
			System.out.println("They aren't equal!");

		// QUESTION 2: What happens when comparing via .equals ?
		if ( pt1.equals( pt2))
			System.out.println("They are equal!");
		else
			System.out.println("They aren't equal!");

		// QUESTION 3: Now, what happens when comparing via == ?
		pt1 = pt2;
		if ( pt1 == pt2)
			System.out.println("After assignment, they are equal!");
		else
			System.out.println("After assignment, they still aren't equal!");
	}
}
