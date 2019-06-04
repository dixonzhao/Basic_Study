package src;

	import becker.robots.*;

// Fix errors, and add code, so that the robot moves to avenue 8

public class ICE_05_Avenues extends Object
{
    public static void main(String[] args)
    {
        City wallville = new City(5, 10);
        Robot rover = new Robot(wallville, 4, 0, Direction.NORTH, 0);
        new Thing(wallville, 4, 8);
        ICE_05_Avenues ic=new ICE_05_Avenues();
        // Every robot has a built-in command named
        // getAvenue(), which gives you the number of the avenue that
        // the robot is currently on.
        // It allows you to ask questions like is the robot on avenue 8?
        ic.turnRight(rover);
        while(rover.getAvenue() <= 7) 
            // move the robot to avenue #8
		      rover.move();
        	
        	
        }
		  
		  // For the error(s) on the next line, what are some possible, different
		  // ways you could fix this?
		  public static void turnRight(Robot a) {
			  int i=0;
			  while(i++<3)
			  a.turnLeft();
			  
    }
}
