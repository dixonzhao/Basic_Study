import becker.robots.*;

/* BIT 115: Assignment 2 Errors */

class RobotThatSpins extends Robot
{
    RobotThatSpins(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }
    
    /**
     * Turn around five complete times (i.e., it spins 360 degrees, five times), then stop
     */
    public void spin()
    {
        int numberOfTurns = 0;
        while( numberOfTurns++<20 )
        {
            this.turnLeft();
        }
    }
    
}

public class A2_Errors extends Object
{
    public static void main(String[] args)
    {   
        City jetsburg = new City();
        RobotThatSpins christopher = new RobotThatSpins(jetsburg, 2, 3, Direction.WEST, 0);
        Robot ian = new Robot(jetsburg, 1, 2, Direction.EAST, 0);
                
        /* Christopher spins around if not standing beside ian*/
		  // You may need to look up the getAvenue/avenue commands 
		  // (either in your textbook, or online)
        if ((christopher.getStreet()+1!= ian.getStreet()) ||
        		((christopher.getAvenue()+1!= ian.getAvenue()&&
        		christopher.getStreet()-1!= ian.getStreet()
        		))
        		||
        		((christopher.getAvenue()-1!= ian.getAvenue()&&
        		christopher.getStreet()-1!= ian.getStreet()
        		))
        		||
        		((christopher.getAvenue()-1!= ian.getAvenue()&&
        		christopher.getStreet()+1!= ian.getStreet()
        		)))
        {
            christopher.spin();
        }
    }
}
