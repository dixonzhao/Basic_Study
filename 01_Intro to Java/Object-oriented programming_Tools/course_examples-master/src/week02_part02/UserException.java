package week02_part02;

import java.util.Scanner;

public class UserException 
{
	public static void main (String [] args)
	{
		System.out.println("Starting here");
		try 
		{
			Scanner keyboard;
			keyboard = new Scanner(System.in);

			System.out.println("Enter your age:");
			String message = keyboard.next();
			Integer age;

			age = Integer.parseInt(message);

			if (age > 18)
				System.out.println("You can vote");

			System.out.println("Your age is " + age);

		}
		catch (NullPointerException ex) 
		{
			// if an error occurs catch  it here
			System.err.println("Caught a NullPointer Exception");
		}
		catch (ArithmeticException ex) 
		{
			// if an error occurs catch  it here
			System.err.println("Caught a ArithmeticException Exception");
		}
		finally 
		{
			System.out.println("Clean up time");
		}

		System.out.println("Done");
	}
}

/* Example Run  Below */
/*
output for exception case
———
Starting here
Enter your age
// user enter 5abc
Clean up time
// program exits and does not print out "Done"
Exception in thread "main" java.lang.NumberFormatException: For input string: "5abc"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at week01_part03.UserException.main(UserException.java:19)



output for things-go-well case
—————
Starting here
Enter your age
// user enters “123”
You can vote
Your age is 123
Clean up time
Done
// program exists
*/
