package src;
//
// YOUR JOB IS TO FILL IN THE chooseDirectoin COMMAND, SO THAT THE ROBOT
// MOVES FROM ONE END OF THE PIPE TO THE OTHER.
//
//
import becker.robots.*;
import java.util.Random; // to use the "Random" class


class RobotThatFollowsThePipe extends Robot
{
	public RobotThatFollowsThePipe(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }
	
	public void move4() {
		int i=0;
		while(i++<4) {
			this.move();
		}
	}
	public void chooseDirection()
	{
		if(this.frontIsClear()!=true) {
		this.turnLeft();}
		else {
			move4();
		}
		if( this.frontIsClear() )
		{
		}
		else 
		{
			this.turnRight();
			this.turnRight();
			// need anything else?
		}
	}
   
	
	// In case you want to use a 'turnRight' command, here it is:
	public void turnRight()
	{
		int j=0;
		while(j++<3) {
			this.turnLeft();
		}
	}
}
 
public class ICE_06_Part_3 extends Object
{
	// These are a couple of new commands that belong to the program
	// rather than any particular robot.
	// For right now, don't worry about how these work :)
    public static void hallwayN(City c, int st, int ave, int streetsNorth)
    {
        for(int i = 0; i < streetsNorth; i++)
        {
            new Wall(c, st - i, ave, Direction.WEST);
            new Wall(c, st - i, ave, Direction.EAST);
        }
    }

	public static void hallwayE(City c, int st, int ave, int streetsEast)
    {
        for(int i = 0; i < streetsEast; i++)
        {
            new Wall(c, st, ave+i, Direction.NORTH);
            new Wall(c, st, ave+i, Direction.SOUTH);
        }
    }

    public static void setupCity(City c)
    {
		hallwayE(c, 4, 2, 3);
		new Wall(c, 4, 1, Direction.NORTH);
		new Wall(c, 4, 1, Direction.WEST);
		new Wall(c, 4, 1, Direction.SOUTH);

		hallwayN(c, 3, 5, 3);
		new Wall(c, 4, 5, Direction.EAST);
		new Wall(c, 4, 5, Direction.SOUTH);
		new Thing(c, 4, 5);
		
		hallwayE(c, 0, 6, 3);
		new Wall(c, 0, 5, Direction.NORTH);
		new Wall(c, 0, 5, Direction.WEST);

		hallwayN(c, 3, 9, 3);
		new Wall(c, 0, 9, Direction.EAST);
		new Wall(c, 0, 9, Direction.NORTH);
		
		hallwayE(c, 4, 10, 8);		
		new Wall(c, 4, 9, Direction.WEST);
		new Wall(c, 4, 9, Direction.SOUTH);
		new Thing(c, 4, 9);

		new Wall(c, 4, 17, Direction.NORTH);
		new Wall(c, 4, 17, Direction.EAST);
		new Wall(c, 4, 17, Direction.SOUTH);
    }

   public static void main(String[] args)
   { 
      City toronto = new City(6, 20);
      RobotThatFollowsThePipe Jo = new RobotThatFollowsThePipe(toronto, 4, 1, Direction.EAST, 0);
      setupCity(toronto); // ignore this line for now

 		// heading east, along the bottom-left corridor
		Jo.move4();
		Jo.chooseDirection();			
		// at this point, the robot should be facing north
			
		// heading north
		Jo.move4();
		Jo.chooseDirection();			
		// at this point, the robot should be facing east


		// heading east across the top
		Jo.move4();
		Jo.chooseDirection();			
		// at this point, the robot should be facing south

		// heading south down the east side
		Jo.move4();
		Jo.chooseDirection();			
		// at this point, the robot should be facing east

		// heading east, but only 4 steps
		Jo.move4();
		Jo.chooseDirection();			
		// this last, final time you'll need to move the robot 4 spaces ahead!

		// Robot is at the end of the hallway - you're done!! :)        
   } 
}


