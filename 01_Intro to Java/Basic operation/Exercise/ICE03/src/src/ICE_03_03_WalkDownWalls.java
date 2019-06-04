package src;
import becker.robots.*;

//Create a new type of robot, named RobotThatCanWalkDownWalls on the next line(s)
class RobotThatCanWalkDownWalls extends Robot
{
 RobotThatCanWalkDownWalls(City c, int st, int ave, Direction dir, int num)
 {
     super(c, st, ave, dir, num);
     {
    	 
     }
 }

 // You should create a new command  named turnRight here:
 // The book likes to call commands 'services'.  In programming lingo, a command/
 // service is called a 'method'
 public void turnRight() {
     this.turnLeft();
     this.turnLeft();
     this.turnLeft();
 }

 public static void CodeBlock() {
	 {
		 int a= 3;
	 }
	 
 }
     // You should create a new service named walkDownWall here:
 public void walkDownWall() {
     this.move();
     this.turnRight();
     this.move();
     this.move();
     this.move();
     this.turnLeft();
 }
}

public class ICE_03_03_WalkDownWalls extends Object
{
 public static void main(String[] args)
 {
     City wallingford = new City();
     RobotThatCanWalkDownWalls Jo = new RobotThatCanWalkDownWalls(wallingford, 0, 1, Direction.EAST, 0);
     // build  the tower
     new Wall(wallingford, 0, 1, Direction.SOUTH);
     new Wall(wallingford, 1, 1, Direction.EAST);
     new Wall(wallingford, 2, 1, Direction.EAST);
     new Wall(wallingford, 3, 1, Direction.EAST);
     new Wall(wallingford, 3, 2, Direction.SOUTH);
     new Wall(wallingford, 4, 2, Direction.EAST);
     new Wall(wallingford, 5, 2, Direction.EAST);
     new Wall(wallingford, 6, 2, Direction.EAST);
     new Wall(wallingford, 6, 3, Direction.SOUTH);
     // Add a thing
     new Thing(wallingford, 3, 2);

     // At this point, you should write code that uses new services (like walkDownWall)
     // along with the built-in services (like pickThing) that makes the robot
     // do the same thing as the flowchart in the in class exercises.
     Jo.walkDownWall();
     Jo.pickThing();
     Jo.walkDownWall();
     Jo.move();
     Jo.putThing();
 }
}
