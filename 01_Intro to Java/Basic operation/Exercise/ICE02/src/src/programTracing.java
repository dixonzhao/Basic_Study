package src;
import becker.robots.*;
public class programTracing {
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
