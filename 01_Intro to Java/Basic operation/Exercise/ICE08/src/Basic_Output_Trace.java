import becker.robots.*;
import java.util.*;

public class Basic_Output_Trace extends Object
{
    public static void main(String[] args)
    {
	 		System.out.print("First Message >");
        	System.out.println("THE PROGRAM STARTS HERE!!");

         City wallville = new City(10, 10);
         Robot rob = new Robot(wallville, 7, 0, Direction.EAST, 0);

         new Thing(wallville, 7, 0);
         new Thing(wallville, 7, 3);

			int counter = 0;
			int targetNumber = 10;

			while( counter < targetNumber )
			{
            rob.move();
            counter = counter + 1; 
				targetNumber = targetNumber - 1; // targetNumber is assigned 
					// the current value of i, MINUS 1
					
				System.out.println ("After move, Counter is: " + counter  + " targetNumber: " + targetNumber);
			}

			System.out.println ("After the loop, Counter is: " + counter  + " targetNumber: " + targetNumber);
				
        	System.out.println ("THE PROGRAM ENDS HERE!!");
    }
}
