package src;

import becker.robots.*;

/*
    CS1A: Assignment 1 Part 4
*/

public class A1_Part_4_1 extends Object
{
   public static void main(String[] args)
   { 
        City theCity= new City();
        Robot jo = new Robot(theCity, 1, 1, Direction.NORTH, 0);
        new Thing(theCity, -1, 1);
            
        new Wall(theCity, 2, 1, Direction.EAST);
        new Wall(theCity, 1, 2, Direction.SOUTH);
        new Wall(theCity, 1, -1, Direction.NORTH);
        
        new Wall(theCity, 3, 2, Direction.SOUTH);
        
        jo.move();
        jo.move();
        jo.pickThing();
        jo.turnLeft();
        jo.move();
        jo.move();      
        jo.move();      

        jo.turnLeft();
        jo.move();

        jo.turnLeft();
        jo.move();

        jo.putThing();

        jo.turnLeft();
        jo.turnLeft();
        jo.turnLeft();

        jo.move();
        jo.putThing();
        jo.turnLeft();
        jo.turnLeft();

        jo.move();
        jo.turnLeft();
        jo.move();

        jo.pickThing();
        jo.turnLeft();
        jo.turnLeft();      

        jo.move();

        jo.turnLeft(); 
        jo.putThing();      
        jo.move();
    }
}


