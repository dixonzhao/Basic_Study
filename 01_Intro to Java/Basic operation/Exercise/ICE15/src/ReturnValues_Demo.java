import becker.robots.*;

class WalkingBot extends Robot {
	WalkingBot(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public int walkToWall() {
		int counter = 0; // how many steps taken?
		while (this.frontIsClear()) {
			this.move();
			counter++;
//			if (counter >= 10) {
//				return counter; // moved 10 spaces - stop!!!
//			}
		}

		return counter; // blocked by wall - stop!!
	}
}

public class ReturnValues_Demo extends Object {
	public static void main(String[] args) {
		City kenmore = new City();
		WalkingBot jo = new WalkingBot(kenmore, 1, 1, Direction.EAST, 0);
		new Wall(kenmore, 1, 4, Direction.EAST);
		new Wall(kenmore, 1, 4, Direction.NORTH);
		new Wall(kenmore, 5, 4, Direction.SOUTH);

		int howFar;
		howFar = jo.walkToWall();
		System.out.println("jo just moved " + howFar + " spaces ");
		jo.turnLeft();
		howFar = jo.walkToWall();
		System.out.println("jo just moved " + howFar + " spaces ");

		jo.turnLeft();
		jo.turnLeft();

		howFar = jo.walkToWall();
		System.out.println("jo just moved " + howFar + " spaces ");

		jo.turnLeft();

		howFar = jo.walkToWall();
		System.out.println("jo just moved " + howFar + " spaces ");
	}
}
