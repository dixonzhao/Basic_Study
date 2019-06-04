package week10.solution;

import java.util.Scanner;

public class TestReverserPair
{
	public void reverser(String value)
	{
		int pos = value.length() - 1;
		reverserHelper(value, pos);
	}

	public void reverserHelper(String value, int pos)
	{
		if (pos >= 0) 
		{
			System.out.print(value.charAt(pos));
			reverserHelper(value, pos - 1);
		}	
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
