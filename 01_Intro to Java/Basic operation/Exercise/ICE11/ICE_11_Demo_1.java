import becker.robots.*;
/**
 * 
 *@author Zhili
 *@version 1.00
 *@category CS1A.ICE11.Part1&3
 *
 *If any one make changing, please add your author name and ++version. THX
 */
class RobotSmarter extends Robot {
	// CONSTRUCTOR
	RobotSmarter(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

//	Part 3 
	public void turnLeft(int inpTurn) {
		while(inpTurn-->0)
			this.turnLeft();
	}
//	End of Part 3, one place(line 60-62) of turnLeft() been replaced to turnLeft(inpTurn).
	
	public void moveThree() {
		int counter = 0;
		while (counter < 3) {
			this.move();
			counter = counter + 1;
		}
	}
	
	
	
	public void moveMultiple(int numberOfIntersections) // parameter
	{
		int counter = 0; // local variable
		while (counter < numberOfIntersections) {
			this.move();
			counter = counter + 1; // counter is assigned: (the current value of
									// counter plus 1)
		}
		System.out.println("BEFORE numberOfIntersections is : " + numberOfIntersections);

		numberOfIntersections = 100000;
		System.out.println("AFTER numberOfIntersections is : " + numberOfIntersections);
	}
}

public class ICE_11_Demo_1 extends Object {
	public static void main(String[] args) {
		City wallville = new City(-3, 0, 12, 12);
		RobotSmarter rob = new RobotSmarter(wallville, -2, 0, Direction.SOUTH, 0);
		System.out.println(rob.getIntersection());
		
		rob.moveThree();
		System.out.println(rob.getIntersection());
		rob.turnLeft();
		
		// 3 is a "literal" number
		rob.moveMultiple(3); // 3 is an "argument"
		System.out.println(rob.getIntersection());
		rob.turnLeft(3); //Part 3
		

		// Notice how we can use a variable to
		// store the value (3) that we want to use as
		// a parameter:
		int howFar = 3;
		System.out.println("BEFORE how far is : " + howFar);
		rob.moveMultiple(howFar); // howFar is an "argument"
		System.out.println("AFTER how far is : " + howFar);
		System.out.println(rob.getIntersection());
		int howFarSECOND_NAME = 3;

		rob.moveMultiple(howFar);
		System.out.println(rob.getIntersection());

		// And of course, we can use other numbers:
		rob.turnLeft();
		rob.moveMultiple(2);
		System.out.println(rob.getIntersection());
	}
}
