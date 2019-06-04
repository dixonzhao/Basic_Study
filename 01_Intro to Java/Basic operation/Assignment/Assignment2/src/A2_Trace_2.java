   import becker.robots.*;

  /* BIT 115: Assignment 2 Trace 2 */

   class RobotThatGoes extends Robot
   {
      RobotThatGoes(City c, int st, int ave, Direction dir, int num)
      {
         super(c, st, ave, dir, num);
      }
    
    
      public void keepGoing()
      {
         while( this.frontIsClear() )
         {
            this.move();
         }
      }  
      public void turnRight()
      {
         this.turnLeft();
         this.turnLeft();
         this.turnLeft();
      }  
   }

   public class A2_Trace_2 extends Object
   {
      public static void main(String[] args)
      {   
         City amaze = new City();
         RobotThatGoes ian = new RobotThatGoes(amaze, 2, 6, Direction.WEST, 0);
        /* build maze*/
         new Wall(amaze, 2, 2, Direction.EAST);
         new Wall(amaze, 8, 3, Direction.WEST);
         new Wall(amaze, 8, 3, Direction.SOUTH);
         new Wall(amaze, 8, 5, Direction.EAST);
      
      /* Move forward while there are no walls*/    
         ian.keepGoing();
         ian.turnLeft();
         ian.keepGoing();
         ian.turnRight();
         ian.keepGoing();
         ian.turnLeft();
         ian.keepGoing();
         ian.turnLeft();
         ian.keepGoing();
         ian.turnLeft();
        
      }
   }
