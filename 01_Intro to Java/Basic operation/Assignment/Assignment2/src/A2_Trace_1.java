import becker.robots.*;

/* BIT 115: Assignment 2 Trace 1 */

public class A2_Trace_1 extends Object
{
    public static void main(String[] args)
    {   
        City jetsburg = new City();
        Robot amelia = new Robot(jetsburg, 2, 2, Direction.EAST, 0);
        amelia.setColor(java.awt.Color.blue); // ignore this line - 
        // we change amelia's color to be blue
		
        Robot ian = new Robot(jetsburg, 3, 1, Direction.EAST, 0);
    
        /* If amelia went past ian, turn around */
		
        // The getAvenue service (command)(method)(etc :)  ) will return
        // the number of the avenue that the robot is on.  So, 
        // on the next line, ameila.getAvenue will tell you "2", since
        // amelia starts on avenue 2
        if (amelia.getAvenue() > ian.getAvenue())
        {
           amelia.turnLeft();
            amelia.turnLeft();
            amelia.move();
            amelia.move();                
            amelia.move();
        }
        if (amelia.getStreet() > ian.getStreet())
        {
            amelia.turnLeft();
            amelia.turnLeft();
            amelia.move();
            amelia.move();                
            amelia.move();
        }
        if (ian.getAvenue() == amelia.getAvenue())
        {
            amelia.turnLeft();
            amelia.turnLeft();
            amelia.move();
            amelia.move();                
            amelia.move();
        }
        // Likewise, getStreet tells you which street number
        // that the robot is currently sitting on.
        if (ian.getStreet() >= amelia.getStreet())
        {
            amelia.turnLeft();
            amelia.turnLeft();
            amelia.move();
            amelia.move();                
            amelia.move();
        }
        if (ian.getAvenue() != amelia.getAvenue())
        {
            amelia.turnLeft();
            amelia.turnLeft();
            amelia.move();
            amelia.move();                
            amelia.move();
        }       
    }
}
