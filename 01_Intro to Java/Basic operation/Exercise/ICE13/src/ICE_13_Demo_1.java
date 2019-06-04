import becker.robots.*;
/**  
 * @author Eric Heldt, Dylan Yanovsky, Jiaping Zeng, Zhili Zhao 
 * @version 1.00
 *@category ICE 13 Part 1: Overriding: Building a SafeRobot
 *
 */

class SafeRobot extends Robot {
	SafeRobot(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}
	
//	
//	
//	Overriding Methods Part 1 
//	
	
	
	@Override
	public synchronized void move() {
		// TODO Auto-generated method stub
		if(this.frontIsClear()) {
			super.move();
		} else {
			System.out.println("The front has wall!  Refuse to action.");
		}
			
	}
	
	
	@Override
	public void pickThing() {
		// TODO Auto-generated method stub
		if(this.canPickThing()) {
			super.pickThing();
		} else {
			System.out.println("There is nothing on the ground ! Refuse to action.");
		}
	}
	
	@Override
	public void putThing() {
		// TODO Auto-generated method stub
		if(this.countThingsInBackpack()!=0) {
			super.putThing();
		} else {
			System.out.println("There is already nothing on the backpack! Refuse to action. ");
		}
		
	}
	
	
	
}

public class ICE_13_Demo_1 extends Object {
	public static void main(String[] args) {
		City theCity = new City(10, 10);
		SafeRobot joe = new SafeRobot(theCity, 3, 3, Direction.EAST, 0);
		
//	Test action 	
//		new Thing(theCity, 2, 3);
// for (int i = 1; i < 11; i++) {
//			// north wall
//			new Wall(theCity, 1, i, Direction.NORTH);
//
//			// Second to north wall
//			if (i <= 9)
//				new Wall(theCity, 1, i, Direction.SOUTH);
//
//			// Third to north wall
//			if (i >= 4)
//				new Wall(theCity, 4, i, Direction.SOUTH);
//
//			// south wall
//			if (i != 9) // (9, 10, SOUTH), is where the 'exit' is
//				new Wall(theCity, 10, i, Direction.SOUTH);
//
//			// west wall
//			if (i != 1) // (1,1, WEST) is where the 'entrance' is
//				new Wall(theCity, i, 1, Direction.WEST);
//
//			// second to west-most wall
//			if (i >= 3 && i < 6)
//				new Wall(theCity, i, 6, Direction.WEST);
//
//			// east wall
//			new Wall(theCity, i, 10, Direction.EAST);
//		}
//		// Call 'turnleft' - notice that this goes to line 4,
//		// instead of the Robot's version of turnLeft
//		joe.turnLeft();
//
//		// Since we didn't override move with our own version,
//		// this still does the normal Robot.move thing
//		joe.move();
//		joe.move();
//		joe.pickThing();
//		joe.turnLeft();
//		joe.move();
//		joe.putThing();
//		joe.move();
//		joe.pickThing();
//		joe.putThing();

		
	}
}
