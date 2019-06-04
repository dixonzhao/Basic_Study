
import becker.robots.*;

/*
    CS1A
	 Assignment 1
    Part 3
*/

public class A1_Part_3 extends Object
{
   public static void main(String[] args)
   { 
        City theCity= new City();
        Robot jo = new Robot(theCity, 1, 3, Direction.EAST, 0);
        Thing theThing = new Thing(theCity, 2, 2);
        new Wall(theCity, 2, 1, Direction.EAST);
        new Wall(theCity, 1, 2, Direction.SOUTH);
        new Wall(theCity, 2, 3, Direction.WEST);
        new Wall(theCity, 3, 2, Direction.SOUTH);
        jo.turnLeft();
        jo.turnLeft();
        jo.turnLeft();
        jo.move();
        jo.move();
        jo.turnLeft();
        jo.turnLeft();
        jo.turnLeft();
        jo.move();
        jo.turnLeft();
        jo.turnLeft();
        jo.turnLeft();
        jo.move();
        jo.pickThing();
        jo.turnLeft();
        jo.turnLeft();      
        jo.move();
        jo.turnLeft(); 
        jo.putThing();      
        jo.move();
        jo.turnLeft(); 
        jo.move();
        jo.move();
        jo.turnLeft(); 
        jo.move();
        jo.move();
    }
}

