
// EXAMPLE: Logical Operator Robot demonstrating &&, ||, and !
//////////////////////////////////////////////////////////////////////////
import becker.robots.*;

class LogicalOperatorRobot extends RobotSE {
	LogicalOperatorRobot(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void eastWest() {
		while ((this.isFacingEast() || this.isFacingWest()) && this.frontIsClear()) {
			this.move();
		}

		if (!(this.isFacingEast() || this.isFacingWest())) {
			System.out.println("I am no longer facing East or West, so I stopped moving. So there.");
		}
	}

	public static void main(String[] args) {
		City MLT = new City(5, 10);
		LogicalOperatorRobot elton = new LogicalOperatorRobot(MLT, 3, 1, Direction.EAST, 0);
		new Wall(MLT, 3, 8, Direction.EAST);
		new Wall(MLT, 3, 1, Direction.WEST);

		elton.eastWest();
		elton.turnLeft();
		elton.turnLeft();
		elton.eastWest();
		elton.turnRight();
		elton.eastWest();
	}
}