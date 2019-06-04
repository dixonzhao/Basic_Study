package src;

import becker.robots.*;
import java.util.Random; // to use the "Random" class

public class HallwaysWhile extends Object
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
    
    public static void setupCity(City c)
    {
        // North hallway:
        hallwayN(c, 5, 5, 5);
        new Wall(c, 1, 5, Direction.NORTH);
        new Thing(c, 1, 5);
        
        // West hallway:
        hallwayN(c, 5, 4, 5);
        new Wall(c, 1, 4, Direction.NORTH);
        new Wall(c, 6, 4, Direction.WEST);
        new Wall(c, 6, 4, Direction.SOUTH);
        new Thing(c, 1, 4);
        
        // southern hallway
        hallwayN(c, 9, 4, 2);
        new Wall(c, 7, 4, Direction.WEST);
        new Wall(c, 7, 5, Direction.EAST);
        new Wall(c, 7, 5, Direction.SOUTH);
        new Wall(c, 9, 4, Direction.SOUTH);
        new Thing(c, 9, 4);
        
        // eastern hallway
        new Wall(c, 6, 6, Direction.EAST);
        new Wall(c, 6, 6, Direction.NORTH);
        new Wall(c, 6, 6, Direction.SOUTH);
        new Thing(c, 6, 6);
    }
    
   public static Direction pickDirection()
    {
        Random r = new Random(System.currentTimeMillis());
        switch(r.nextInt(4))
        {
            case 0:
                return Direction.NORTH;
            case 1:
                return Direction.WEST;
            case 2:
                return Direction.EAST;
            case 3:
                return Direction.SOUTH;
            default:
                return Direction.SOUTH; // to keep the compiler happy
        }
    }


   public static void main(String[] args)
   { 
      City toronto = new City(11, 8);
      Robot Jo = new Robot(toronto, 6, 5, pickDirection(), 0);
      setupCity(toronto); // ignore this line for now
      int breakOff=1,stepCount=0;
      
      /* Your code should go here: */
      	while(breakOff!=0) {
      		stepCount=0;

//      		go down to the wall and count the step 
      		
      		while(Jo.frontIsClear()) {
      			Jo.move();
      			stepCount++;
      		}
      		
//      		pick thing and turn around
      		if(Jo.canPickThing()) {
      			Jo.pickThing();
      			Jo.turnLeft();
      			Jo.turnLeft();
      			if(Jo.frontIsClear()) {
      				Jo.turnLeft();
      				if(Jo.frontIsClear()){
      					Jo.turnLeft();
      					Jo.turnLeft();
      					if(Jo.frontIsClear()) {
      							if((Jo.canPickThing())
      								
      					}
      												}
      												}
      												}
//      		back to the start point
      		
      		while(stepCount-->0) {
      			Jo.move();
      		}
      		
      		if(breakOff!=0) {
      			Jo.putThing();
      			Jo.turnLeft();
      		}
      	
      
      
   } 
}
}

