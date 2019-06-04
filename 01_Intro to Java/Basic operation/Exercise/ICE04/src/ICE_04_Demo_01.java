package src;
   import becker.robots.*;
   import java.util.Random;

   class SaferRobot extends Robot
   {
      SaferRobot(City c, int st, int ave, Direction dir, int num)
      {
         super(c, st, ave, dir, num);
      }
   
      public void putThingSafer()
      {
         if(this.countThingsInBackpack() > 0)
         {
            this.putThing();
         }
      }
   }
   
  public class ICE_04_Demo_01 extends Object
  {
      public static void main(String[] args)
      {
         City bothell = new City();
         Random numberGenerator = new Random(); // don't worry about this line
         SaferRobot ian = new SaferRobot(bothell, 2, 0, Direction.EAST, 0);
      
      // IGNORE THE CODE THAT STARTS ON THE NEXT LINE
      // %50 chance we'll put something at (2,1)
         if( numberGenerator.nextInt(100) < 50   )
         {
            new Thing(bothell, 2,1);
         }
      // KEEP IGNORING THE CODE
      // %20 chance we'll put something at (2,2)
         if (numberGenerator.nextInt(100) < 20)
         {
            new Thing(bothell, 2,2);
         }
      // KEEP IGNORING THE CODE!
      // %70 chance we'll put something at (2, 3)
         if (numberGenerator.nextInt(100) < 70)
         {
            new Thing(bothell, 2,3);
         }
      // OK, YOU SHOULD BE ABLE TO UNDERSTAND THE CODE FROM HERE ON OUT
      // YOU CAN STOP IGNORING THE CODE :)
        
         new Wall(bothell,2,5, Direction.EAST);
         new Wall(bothell,2,5, Direction.NORTH);
         new Wall(bothell,2,5, Direction.SOUTH);
      
      
      // The robot should pick up all the Things that are in the city;
      // the robot should then put everything down in the 'house' at the
      // end.
      
      //Send robot to the store, and get thing
         ian.move();
         if(   ian.canPickThing()  )
			{
				ian.pickThing();
			}
         ian.move();
         if(ian.canPickThing()) 
         {
            ian.pickThing();
         }
         else
         {
            ian.turnLeft();
            ian.turnLeft();
            ian.turnLeft();
            ian.turnLeft();
         }
      	
         ian.move();
         if(ian.canPickThing())
         {
            ian.pickThing();
         }
        
      // Move ian to housing
      // We should leave this out, since we know it'll be true
      // It's included here just to demonstrate how to ask if there's NO wall in front of the robot
         if(ian.frontIsClear()    )
         {
            ian.move();
         }
         if(ian.frontIsClear())
         {
            ian.move();
         }
      	
      // Drop all the things
         if(ian.countThingsInBackpack() > 0 )
         {
            ian.putThing();			
         }
         if( ian.countThingsInBackpack() > 0  )
         {
            ian.putThing();
         }
         else
         {
            ian.turnLeft();
            ian.turnLeft();
            ian.turnLeft();
            ian.turnLeft();
         }
         ian.putThingSafer();
        
      //Turn robot around
      // We should leave this out, since we know it'll be true
      // It's included here just to demonstrate how to ask if there's
      // a wall in front of the robot
         if( ! ian.frontIsClear() ) 
         {
            ian.turnLeft();
            ian.turnLeft();
            ian.move();
         }
      }
   }
