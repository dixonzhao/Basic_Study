package src;

import becker.robots.*;

// STudents: Don't worry about these next import statements
import java.util.Random; // to generate random numbers

public class ICE_05_Race extends Object
{
   public static void main(String[] args)
   {
        City RaceCity = new City(4, 11);
        Random numberGenerator = new Random(); // don't worry about this line
        ICE_05_Race ic=new ICE_05_Race();
        Thing baton = new Thing(RaceCity, 3, 0);

        // karel is the first racer (at the left)
		  // and always starts directly above the baton
        Robot karel = new Robot(RaceCity, 3, 0, Direction.EAST, 0);

        // bob is the second racer (in the middle)
        Robot bob = new Robot(RaceCity, 2, 2 + numberGenerator.nextInt(3), Direction.EAST, 0);
		  bob.setColor(java.awt.Color.blue);
        // mary is the third racer (at the right)
        Robot mary = new Robot(RaceCity, 3, 5 + numberGenerator.nextInt(3), Direction.EAST, 0);
		  mary.setColor(java.awt.Color.green);
		  
		  /**Part 1
		   * 
		  karel.pickThing();
		  ic.catchUpFront(karel,bob);
		  ic.catchUpFront(bob, mary);
		  mary.move();
		  mary.putThing();*/
		  
//		  Part 2
		  karel.pickThing();
		  ic.catchUpFront(karel,bob);
		  ic.catchUpFront(bob, mary);
		  mary.move();
		  mary.putThing();
		  ic.marryGo(mary);
		  
		  
        /* karel should pick up the baton, then move to the intersection that bob is in.
           karel should drop the baton, bob should pick it up, and bob should then move
           to the intersection that mary is in. bob should drop the baton, mary should
           pick it up, and mary should then move 2 intersections east, and drop the baton.  */

   }
   	/**Part 1
   	 * 
   	 * public void catchUpFront(Robot behind, Robot front) {
   		
	   while(behind.getAvenue()<front.getAvenue()) 
		   behind.move();
	   if(behind.getStreet()==3) {
		   behind.turnLeft();
	   }else {
		   behind.turnLeft();
		   behind.turnLeft();
		   behind.turnLeft();
	   }
	   behind.move();
	   behind.putThing();
	   front.pickThing();
   	}
   	*/
   
   
//   Part 2
   public void catchUpFront(Robot behind, Robot front) {
  		
	   while(behind.getAvenue()<front.getAvenue()) 
		   behind.move();
	   
	   if(behind.getStreet()==3) {
		   behind.turnLeft();
	   }else {
		   behind.turnLeft();
		   behind.turnLeft();
		   behind.turnLeft();
	   }
	   
	   behind.move();
	   behind.putThing();
	   front.pickThing();
   	}
   
   public void marryGo(Robot mary) {
	   int i=0;
	   while(mary.getAvenue()!=18) 
		   mary.move();
	   
	   while(i++<3) 
		   mary.turnLeft();

	   while(mary.getStreet()!=5)
		   mary.move();
	   
	   mary.turnLeft();
	   
   }
}


