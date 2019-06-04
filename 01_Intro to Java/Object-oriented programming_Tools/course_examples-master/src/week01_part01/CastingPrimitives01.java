package week01_part01;

public class CastingPrimitives01 {

	public static void main(String[] args) 
	{
		int i = 15;
		double d = 1.7;
		
		i = (int)d; //"Explicit cast needed to convert double to int"
		d = i; // no problem here because all integers ARE doubles
		System.out.println ("d= " + d); // same goes for parameter passing
		
		// i = 34.7; "Explicit cast needed to convert double to int"
		i = (int) 34.7;
		System.out.println ("i= " + i);
		
		char ch = 'A';
		i = ch;
		System.out.println ("i= " + i);
		System.out.println ("ch= " + ch);
		
		i = 66;
		// ch = i; "Explicit cast needed"
		ch = (char) i;
		System.out.println ("i= " + i);
		System.out.println ("ch= " + ch);
		
		
		int max = 0;
		for (int counter = 0; counter < max; counter++)
		{
			System.out.println("Do something more substantial" + counter);
		}
	}
}
