package src;

import becker.robots.*;
/*
Starting Template:
This file was created in order to provide you with a pre-made 'starter' program
 */

public class A1_Part_5 extends Object {
	public static void main(String[] args) {
		City toronto = new City();
		Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);


		/* Your code should after here: */
		
//		Built the wall
		
		 new Wall(toronto, 2, 1, Direction.NORTH);
		 new Wall(toronto, 2, 1, Direction.WEST);
		 new Wall(toronto, 2, 2, Direction.NORTH);
		 new Wall(toronto, 2, 2, Direction.EAST);
		 new Wall(toronto, 3, 1, Direction.SOUTH);
		 new Wall(toronto, 3, 1, Direction.WEST);
		 new Wall(toronto, 3, 2, Direction.SOUTH);
		 new Wall(toronto, 3, 2, Direction.EAST);
		 
//		 initialize
		 jo.turnLeft();
		 jo.move();
		 jo.move();
		 turnRight(jo);
		 
//		 for() to let it turn around
		 
			 moves(jo);
			 moves(jo);
			 moves(jo);
			 moves(jo);
			 jo.move();
	} 
	public static void moves(Robot a) {  
        a.move();
        a.move();
        a.move();
        turnRight(a);
    }  
	public static void turnRight(Robot a) {  
        a.turnLeft();
        a.turnLeft();
        a.turnLeft();
        
    }  
}