package CS1A.ICE10;

import becker.robots.*;
import java.util.Scanner;
// Imported Scanner class


public class ICE_10_IO extends Object
{
    public static void main(String[] args)
    {
        int userChoice = 0 ;
        Scanner keyboard = new Scanner(System.in);
        // Added "System.in" as Scanner parameter

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

            if(keyboard.hasNextInt()) // Replaced true with keyboard.hasNextInt()
            {
                // Replaced nextInteger() with nextInt()
                userChoice = keyboard.nextInt();
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
                if(userChoice==3)// The quit operation for the "3"
                	System.exit(0); 
            }
            else
            {
                System.out.println("You have not input a valid integer");
                keyboard.nextLine(); // added nextLine() to avoid infinite loop
            }
        }
    }
}