package src;


import becker.robots.*;
import becker.*;


// By the time the program ends, the robot should have put the
// thing down at (3,0) (street 3, avenue 0), and the robot should be
// at (4,0) facing east
//
// HINT: If you're having trouble finding a particular error,
//		try comparing this file to another, working file.
//		You need to be able to find and fix errors on your own
//		(i.e., WITHOUT working files to compare to), but this
//		hint can be a good way to get un-stuck.
//
public class FindErrors extends Object
{
   public static void main(String[] args)
    {  
      City seattle =new City(5, 10);
      Robot karel = new Robot(seattle, 1, 4, Direction.WEST, 0);
      Thing apple = new Thing(seattle, 1, 2);
      Wall w = new Wall(seattle, 1, 2, Direction.NORTH);

      karel.move() ;
		karel.move(); 
      karel.pickThing();
		karel.move();
      karel.move();
		
		karel.turnLeft();
      karel.move();
      karel.move();
      karel.putThing();
      karel.move();
	karel.turnLeft();
   }
}
	// is there something missing on this line?