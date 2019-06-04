package src;
import becker.robots.*;
import java.util.Random;

class saferRobot extends Robot
{
	saferRobot(City c, int st, int ave, Direction dir, int num)
	{
		super(c, st, ave, dir, num);
	}
	
	/**
	 * Picks up something, but only if there's something to pick up.
	 */
	public void pickThingSafer()
	{
		if( this.canPickThing())
		{
		this.pickThing();

		
	}
}
	public void putThingSafer()
	{
		if( this.countThingsInBackpack()!=0)
		{
		this.putThing();
	}
}
}




public class ICE_04_1_Errors extends Object{

	public static void main(String[] args){

	City bothell = new City();
	saferRobot ian = new saferRobot(bothell, 2, 0, Direction.EAST, 0);
	ICE_04_1_Errors ice4 = new ICE_04_1_Errors();
	
	new Thing(bothell,1,4);
	new Thing(bothell,2,4);
	new Thing(bothell,3,4);
	new Wall(bothell,0,4,Direction.NORTH);
	new Wall(bothell,0,4,Direction.WEST);
	new Wall(bothell,0,4,Direction.EAST);
	new Wall(bothell,2,4,Direction.SOUTH);
	new Wall(bothell,3,4,Direction.NORTH);
	new Wall(bothell,4,4,Direction.SOUTH);
	new Wall(bothell,4,4,Direction.WEST);
	new Wall(bothell,4,4,Direction.EAST);
	// For this ICE, we know whether there's going to be a Thing
	// at any given intersection or not.
	// However, it's relatively easy to write code that will put a
	// Thing at an intersection only some of the time, thus
	// adding some uncertainty to the program.
	// 
	// Let's start off with a couple of contrived examples, just to
	// get a feel for how the "if" statement works:
	if ( true )
	{
		new Thing(bothell, 2,1);
	}
	
	if (1 < 50)
	{
		new Thing(bothell, 2,2);
	}
	
	if ( 500 > 70)
	{
		new Thing(bothell, 2,3);
	}
	
	new Wall(bothell,2,5, Direction.EAST);
	new Wall(bothell,2,5, Direction.NORTH);
	new Wall(bothell,2,5, Direction.SOUTH);
	
	// The robot should pick up all the Things that are in the city;
	// the robot should then put everything down in the 'house' at the
	// end.
	
	//Send robot to the store, and get thing
	ian.move();
	ian.pickThingSafer();
	ian.move();
	ian.pickThingSafer();
	ian.move();
	ian.pickThingSafer();
	
	// Move ian to housing
	ian.move();
	ian.move();
	
	// Drop all the things - at no point should the robot break!
	ian.putThingSafer();
	ian.putThingSafer();
	ian.putThingSafer();
	ian.putThingSafer();
	ian.putThingSafer();
	ian.putThingSafer();
	
	//Turn robot around, and move one space west
	ian.turnLeft();
	ian.turnLeft();
	ian.move();
	
	// the robot ends the program next to the 'house', with all the things
	// inside the house.
	}
}
