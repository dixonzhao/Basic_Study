package src;

import becker.robots.*;

class RobotSmarter1 extends Robot {
	RobotSmarter1(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void turnRight() {
		this.turnLeft();
		this.turnLeft();
		this.turnLeft();
	}
	
	public void goAroundCorner() {
		this.move();
		this.move();
		this.move();
		this.move();
		this.move();
		this.turnRight();
		this.move();
		this.turnLeft();
	}
	public void moveFour() {
		// "i" is a terrible name for a variable
		// Unfortunately, it's also a traditional name for a
		// counter, so it's good to get used to it.
		int i = 0;
		// The above statement combines:
		//  int i;
		//  i = 0;
		// into one easy statement - it's handy
		// because you can both create a new block of memory,
		// and IMMEDIATELY put a starting value into it.
		while (i < 4) {
			this.move();
			i = i + 1; // i is assigned the current value of i, plus 1
		}
	}
}

public class ICE_06_CL_Trace extends Object {
	public static void main(String[] args) {
		City wallville = new City(10, 10);
		RobotSmarter1 rob = new RobotSmarter1(wallville, 7, 0, Direction.EAST, 0);

		int counter = 0;
		new Thing(wallville, 7, 0);
		new Thing(wallville, 7, 4);
		new Thing(wallville, 3, 4);

		// Instead of giving rob 4 separate "move" commands,
		// simply tell it that you want it to move 4 times
		while (counter < 4) {
			rob.move();
			counter = counter + 1;	// counter is assigned the current value of
									// i, plus 1
		}

		rob.turnLeft();

		rob.moveFour();
	}
}
