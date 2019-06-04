package src;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

public class a {
	public static void main(String[] args) {	
		//do thing directly by default														
		/* put your code after here */
		//job code
		City seattle = new City();
		Robot gretel = new Robot(seattle, 1, 0, Direction.EAST, 0);
		Thing theThing = new Thing(seattle, 1, 2);
		new Wall(seattle, 1, 1, Direction.EAST);
		new Wall(seattle, 1, 1, Direction.NORTH);
		new Wall(seattle, 1, 1, Direction.WEST);
		new Wall(seattle, 1, 1, Direction.SOUTH);
	}
}
