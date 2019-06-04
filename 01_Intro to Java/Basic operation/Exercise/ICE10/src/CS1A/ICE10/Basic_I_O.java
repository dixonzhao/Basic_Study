package CS1A.ICE10;

import becker.robots.*;
import java.util.Scanner;

public class Basic_I_O extends Object {
    public static void main(String[] args) {
        City toronto = new City();
        Robot joe = new Robot(toronto, 3, 0, Direction.EAST, 0);
        new Thing(toronto, 3, 2);

        Scanner keyboard = new Scanner(System.in);
        int userChoice = 0;
        while (userChoice != 5) {
            System.out.println("Type 1 to turn left");
            System.out.println("Type 2 to move forward");
            System.out.println("Type 3 to pick a Thing up");
            System.out.println("Type 4 to put a Thing down");
            System.out.println("Type 5 to quit");
            if (keyboard.hasNextInt()) {
            	
                userChoice = keyboard.nextInt();
                
                while(userChoice<1||userChoice>4) {
            		System.out.println("Input out of range! Please input again!");
            		continue;
            	}
                
                keyboard.nextLine();
                switch (userChoice) {
                    case 1:
                        joe.turnLeft();
                        break;
                    case 2:
                        joe.move();
                        break;
                    case 3:
                        joe.pickThing();
                        break;
                    case 4:
                        joe.putThing();
                        break;
                    case 5:
                        System.out.println("Exiting program");
                        break;
                    default:
                        System.out.println("Please enter an integer between 1 and 5");
                }
            } else {
                System.out.println("Please enter an integer between 1 and 5");
                keyboard.nextLine();
            }
        }
        keyboard.close();
    }
}