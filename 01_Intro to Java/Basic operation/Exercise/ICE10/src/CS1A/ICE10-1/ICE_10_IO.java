package CS1A.ICE10;

import java.util.Scanner;

import becker.robots.*; 
// WHAT SHOULD YOU PUT HERE????????


public class ICE_10_IO extends Object
{
	public static void main(String[] args)
	{
		int userChoice = 0 ;
		Scanner keyboard = new Scanner();
		// WHAT SHOULD YOU PUT HERE????????

		City wallville = new City(10, 10);
		Robot rob = new Robot(wallville, 7, 0, Direction.EAST, 0);
		new Thing(wallville, 7, 0);
		new Thing(wallville, 7, 6);
		new Thing(wallville, 1, 6);
		
		while(userChoice != 3)
		{
			System.out.println("Please select from the following options:");
			System.out.println("1 - turn right");
			System.out.println("2 - move");
			System.out.println("3 - quit");
			
			if( true ) // WHAT IS A BETTER LINE TO PUT HERE??????
			{
				// WHAT SHOULD YOU PUT ON THE NEXT LINE????????
				userChoice = keyboard.nextInteger();
				
				System.out.println("userInput is: " + userChoice);
				
				if( userChoice == 1)
				{
					rob.turnLeft();
					rob.turnLeft();
					rob.turnLeft();
				}
				if( userChoice == 2)
				{
					rob.move();
				}
			}
			else
			{
				System.out.println("You have not input a valid integer");
			}
		}
	}
}
