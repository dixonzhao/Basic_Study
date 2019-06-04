package CS1A.ICE10;

import becker.robots.*;
import java.util.Scanner;

public class Basic_Keyboard_IO extends Object {
    public static void main(String[] args) {
        System.out.println("THE PROGRAM STARTS HERE!!");

        int numMoves = 0; // Since the loop below stops when numMoves == -1,
        // it is important that this be anything EXCEPT -1
        // Setting numMoves to zero works just fine
        int counter = 0;

        Scanner keyboard = new Scanner(System.in);

        City seattle = new City();
        Robot mary = new Robot(seattle, 1, 1, Direction.EAST, 0);
        System.out.println("mary.getAvenue():"+mary.getAvenue());

        System.out.println("How many intersections forward would you like the robot to go?");
        System.out.println("keyboard.hasNextInt() = " + keyboard.hasNextInt());
        if (keyboard.hasNextInt()) {
            numMoves = keyboard.nextInt(); // nextInt actually gets the input
            System.out.println("\"numMoves\" initialized with value " + numMoves);
            System.out.println("You asked to move " + numMoves + " spaces");
            counter = 0;
            System.out.println("\"counter\" initialized with value " + counter);
            while (counter < numMoves) {
                System.out.println("Moving");
                mary.move();
                System.out.println("mary.getAvenue() = " + mary.getAvenue());
                counter = counter + 1;
                System.out.println("counter = " + counter);
            }
        } else {
            System.out.println("You did NOT type in a whole number!");
        }

        keyboard.nextLine(); // DON'T FORGET TO CLEAR ANY REMAINING INPUT!!
        keyboard.close(); // You don't have to close the Scanner resource, but
        // it is good practice to do so
        System.out.println("THE PROGRAM ENDS HERE!!");
    }
}