package src;
import becker.robots.*;
public class ICE_02_02_Trace extends Object
{
   public static void main(String[] args)
   { 
        City theCity = new City();
        Robot Bob = new Robot(theCity, 3, 0, Direction.EAST, 0);
        new Thing(theCity, 1, 1);
        new Wall(theCity, 3, 0, Direction.EAST);
        new Wall(theCity, 3, 0, Direction.SOUTH);
        new Wall(theCity, 1, 0, Direction.NORTH);
        new Wall(theCity, 1, 1, Direction.NORTH);
        Bob.turnLeft();
        Bob.move();
        Bob.move();
        Bob.turnLeft();
        Bob.turnLeft();
        Bob.turnLeft();
        Bob.move();
        Bob.pickThing();
        Bob.turnLeft();
        Bob.turnLeft();
        Bob.move();
        Bob.turnLeft();
        Bob.move();
        Bob.move();
        Bob.putThing();
        Bob.turnLeft();
        Bob.turnLeft();
        Bob.move();
   }
}


