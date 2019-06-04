package week10;

import java.util.Scanner;

public class TestPrintMessage 
{
	public void printMessage(String message, int times) 
	{
		// The base case is times == 0
		if (times == 0)
			return;

		System.out.println(message);
		
		printMessage(message, times - 1);
	} 
	
	public static void main(String [] args)
	{
		TestPrintMessage application = new TestPrintMessage();

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the message:");
		
		String message = keyboard.nextLine();
		
		System.out.println("Enter the number of itmes you'd like to display the message:");

		int requestedTimes = keyboard.nextInt();
		
		application.printMessage(message, requestedTimes);
		
		System.out.println("\nDone with TestPrintMessage");
	}
}
