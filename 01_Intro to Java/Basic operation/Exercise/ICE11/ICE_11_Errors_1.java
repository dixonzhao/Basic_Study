import becker.robots.*;

/**
 * 
 *@author Zhili
 *@version 1.00
 *@category CS1A.ICE11.Part2&4
 *If any one make changing, please add your author name and ++version. THX
 */
class SmarterRobot extends Robot
{
    SmarterRobot(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }
    
/* Part 2
    public void moveMultiple(int numberOfIntersections) // Syntax error: need type of variable
    {
        int counter = 0; // Syntax error, variable need to be initialized. 
        while( counter++ < numberOfIntersections) // Logical error, control action false&& control variable need to be changed.
        {
            this.move();
        }
		  
    }

 */
    
//    Part 4
    public void move(int numInsert) 
    {
        int counter = 0; 
        while( counter++ < numInsert) 
        {
            this.move();
        }
		  
    }
    
    public void circleDots(int inP)
    {
    	while(inP-->0) 
    	{
    		this.turnLeft();
    		this.turnLeft();
    		this.turnLeft();
    		this.move();
    		this.turnLeft();
    		this.move(2);
    		this.turnLeft();
    		this.move(2);
    		this.turnLeft();
    		this.move(2);
    		this.turnLeft();
    		this.move();
    		this.turnLeft();
    	
    		this.turnLeft();
    		this.turnLeft();
    		this.turnLeft();
    		this.move();
    		this.turnLeft();
    		this.move(2);
    		this.turnLeft();
    		this.move();
    		this.turnLeft();
    		this.turnLeft();
			this.turnLeft();
			
			while(this.canPickThing()!=true&&inP!=0) 
			{
				this.move();
			}
    	
			if(inP!=0) 
			{
				this.turnLeft();
				this.turnLeft();
				this.move();
				this.turnLeft();
				this.turnLeft();
			}
			
    	}
    }
}
public class ICE_11_Errors_1 extends Object
{
    public static void main(String[] args)
    {
        City wallville = new City();
        SmarterRobot  rob = new SmarterRobot (wallville, 4, 0, Direction.EAST, 0);

        new Thing(wallville, 4, 1);
        new Thing(wallville, 4, 3);
        new Thing(wallville, 4, 5);
        rob.circleDots(3);
        rob.move(3); // on this side, called an argument
        rob.turnLeft(); // Syntax error, need ";"
        rob.move(2); // move two spaces forwards // Logical error, need the Parameter
    }
}
