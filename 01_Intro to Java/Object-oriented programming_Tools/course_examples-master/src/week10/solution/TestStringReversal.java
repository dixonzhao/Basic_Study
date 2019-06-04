package week10.solution;

import java.util.Scanner;

public class TestStringReversal 
{

	public void reverseDisplay(String value)
	{
		int len = value.length();

	    if (len == 1)
	    {
	    	System.out.println(value);
	    	return;
	    }	
	   
		System.out.print(value.charAt(len-1));

	    String sub = value.substring(0,len-1);
	    
	    reverseDisplay(sub);
	}
	
	public static void main(String[] args) 
	{
		TestStringReversal application = new TestStringReversal();

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter a string to reverse:");
		
		String requestedStr = keyboard.nextLine();
		
		application.reverseDisplay(requestedStr);
		
		System.out.println("\nDone with TestStringReversal");
	}
}
