import becker.robots.*;

class MysteryRobot extends Robot {
	MysteryRobot(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void turnAround() {
		this.turnLeft();
		this.turnLeft();
		System.out.println(this);
	}

	public void pace() {
		this.move();
		this.move();
		this.turnAround();
		this.move();
		this.move();
		this.turnAround();
	}
}

class MysteryRobotSubclass extends MysteryRobot {
	MysteryRobotSubclass(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void turnAround() {
		this.putThing();
		System.out.println("Hey, I'm turning around now.");
		super.turnAround();
	}
}

public class ICE_13_Demo_2 extends Object {
	public static void main(String[] args) {
		City ForgetsVille = new City();
		MysteryRobot joe = new MysteryRobot(ForgetsVille, 4, 0, Direction.EAST, 2);
		MysteryRobotSubclass rob = new MysteryRobotSubclass(ForgetsVille, 3, 0, Direction.EAST, 2);

		System.out.println(joe);
		joe.pace();
		System.out.println(rob);
		rob.pace();
	}
}
