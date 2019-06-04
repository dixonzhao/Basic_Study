package src;

import becker.robots.*;
import java.util.Random;

public class A2_Part_3 extends Object {
	public static void main(String[] args) {
		City wallville = new City(6, 12);
		Robot rob = new Robot(wallville, 1, 2, Direction.EAST, 0);
		A2_Part_3.BuildCity(wallville); // this jumps down to the "BuildCity" routine, below

		// * * * --> Your code to race around the race track goes here <-- * * *
		takeThing(rob);
		putThing(rob);
		returnToStart(rob);
		// HINT: Several while loops would work well for this particular exercise.
		// One possible solution would be to start with a while loop (for checking the
		// count)
		// that contains two nested while loops used to check whether the front is clear
		// before performing some actions. Jumping through this initial while loop might
		// use additional while loops to continue checking whether the front is clear
		// before performing other actions in order to complete the tasks of the maze.

	}
	public static void takeThing(Robot rob) {
		int count =0;		
		while(count<4) {
			while(rob.frontIsClear()) {
				rob.move();
			}
			rob.pickThing();
			rob.turnLeft();
			rob.turnLeft();
			while(rob.frontIsClear()) {
				rob.move();
			}
			rob.turnLeft();
			rob.move();
			rob.turnLeft();
			count++;
		}
		
		
	}
	
	public static void putThing(Robot rob) {
		rob.move();
		int count=0;
		while(count<4) {
			rob.putThing();
			if(count!=3)
				rob.move();
			count++;
		}
	}
	
	public static void returnToStart(Robot rob) {
		rob.turnLeft();
		rob.turnLeft();
		rob.move();
		rob.move();
		rob.move();
		rob.move();
		rob.turnLeft();
		rob.turnLeft();
		rob.turnLeft();
		rob.move();
		rob.move();
		rob.move();
		rob.move();
		rob.turnLeft();
		rob.turnLeft();
		rob.turnLeft();
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	// No need to touch any of the code below. All it does is construct the maze in
	///////////////////////////////////////////////////////////////////////////////////////// the
	///////////////////////////////////////////////////////////////////////////////////////// city
	/////////////////////////////////////////////////////////////////////////////////////////
	public static void BuildCity(City wallville) {
		// Width and height must be at least 2 (each)
		// Feel free to change these numbers, and see how your racetrack changes

		Random r = new Random();
		int top = 1;
		int left = 2;
		int height = 4;
		int width = 7 + r.nextInt(4);

		int streetNumber = top;
		while (streetNumber <= height) {
			if (streetNumber == 1) {
				// the topmost line:
				new Wall(wallville, streetNumber, left, Direction.NORTH);
			} else if (streetNumber == height) {
				// generate the 'holding spot' thing at the bottom:

				// the corner:
				new Wall(wallville, streetNumber + 1, left, Direction.WEST);
				new Wall(wallville, streetNumber + 1, left, Direction.SOUTH);
				int spotNum = left + 1;
				int counter = 0;
				while (counter < height) {
					new Wall(wallville, streetNumber + 1, spotNum, Direction.NORTH);
					new Wall(wallville, streetNumber + 1, spotNum, Direction.SOUTH);
					// Uncomment the next line for a 'final state' picture (i.e., the second picture
					// in the assignment)
					// new Thing(wallville, streetNumber+1, spotNum);
					spotNum = spotNum + 1;
					counter = counter + 1;
				}
				new Wall(wallville, streetNumber + 1, spotNum, Direction.WEST);
			}

			// the west-most, vertical line:
			new Wall(wallville, streetNumber, left, Direction.WEST);
			// the east-most, vertical line:
			new Wall(wallville, streetNumber, width, Direction.EAST);
			// the Thing at the end of the tunnel
			new Thing(wallville, streetNumber, width);

			int aveNum = left + 1;
			while (aveNum <= width) {
				new Wall(wallville, streetNumber, aveNum, Direction.NORTH);
				new Wall(wallville, streetNumber, aveNum, Direction.SOUTH);
				aveNum = aveNum + 1;
			}

			streetNumber = streetNumber + 1;
		}
	}
}
