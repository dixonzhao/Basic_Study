package src;

import becker.robots.*;
/*
Starting Template:
This file was created in order to provide you with a pre-made 'starter' program

Important Notes:
1)  Make absolutely sure that your becker.jar file is in the list of jGRASP's custom classpaths:
You can check by clicking on the "Settings" menu, 
then clicking on the "PATH/CLASSPATH" menu option, then "Workspace", then the "CLASSPATHs" tab
and then making sure that the becker.jar file is in the list.
If not, click "New" to add becker.jar to jGRASP

2)  Make sure that the name of the file is the same as the name of the class.
The name of the class is found between the words "class", and "extends".
For example, the name of this class is "Starting_Template", and it's found in a file
named "Starting_Template.java".  You can see the name of the file (in jGRASP) in
the titlebar (at the very top of the window)
You'll notice that the name of the file has ".java" on the end, yet the name of the
class (here in the file) leaves the ".java" off.
 */

public class Starting_Template extends Object {
	public static void main(String[] args) {
		City toronto = new City();
		Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
		new Thing(toronto, 3, 2);

		/* Your code should go here: */
		jo.move();
		jo.move();
		jo.pickThing();
		jo.move();
		jo.putThing();
		jo.turnLeft();
		jo.move();
	} // this line was originally line # 31
}