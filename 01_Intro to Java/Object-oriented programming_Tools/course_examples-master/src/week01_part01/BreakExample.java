package week01_part01;

import java.util.Scanner;

public class BreakExample {

	public static void main(String[] args) {
		int counter = 0;
		int max = 10;
		
		Scanner keyboard = new Scanner(System.in);
		while ( counter < max )
		{
			System.out.println("Enter the your age:");
			String user_input = keyboard.next();
			int age = Integer.parseInt( user_input );
			System.out.println("First counter = " + counter);		

			if( age < 18)
			{
				for (int i = 0; i < 4; i++)
				{
					System.out.println("i = " + i);
					if (i == 2)
						break;	/* exists the loop */
				}
			}

			System.out.println("second counter = " + counter);		

			if( age < 21)
			{
				System.out.println("You are less than 21"); /* prints this */
				continue;	/* stops executing the loop
						   and causes everything else to be skipped */
			}
			System.out.println("you can drink");	
			counter++;
		}

	}

}
