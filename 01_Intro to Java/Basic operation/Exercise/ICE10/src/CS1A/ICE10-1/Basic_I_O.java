import becker.robots.*;
import java.util.Scanner;
/*
Starting Template:
This file was created in order to provide you with a pre-made 'starter' program
 */
/**
 * 
 *@author Zhili Zhao
 *@version 1.00
 *@patterns userInput, instrInfo
 *@serial A3Group01.ICE10.CS1A.
 *@see ICE10.Part03
 */
public class Basic_I_O_111 extends Object {
	public static void main(String[] args) {
		//Initialize for program 
		City toronto = new City();
		Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
		new Thing(toronto, 3, 2);
		Scanner sc= new Scanner(System.in);
		
		
		/* Your code should after here: */
		
		//initialize patterns
		int userInput=0;
		String instrInfo = 
				 "Type 1 if you want the robot to turn left.\n"
				+ "Type 2 if you want the robot to move.\n"
				+ "Type 3 if you want the robot to pick thing. \n"
				+ "Type 4 if you want the robot to put thing.\n"
				+ "Your Input£º";
	
//		Get Input Number
		while(userInput<1||userInput>4) {
			System.out.println(instrInfo);
			userInput=sc.nextInt();
				
			if(userInput<1&userInput>4){
				System.out.println("Number out of range!, Please input again!");
			}
			else {
				break;
			}
				
		}
				
//		Start the moving 
			if(userInput==1) {
					 	jo.turnLeft();
		}
			
			if(userInput==2) {
						jo.move();
		}
			if(userInput==3) {
						jo.pickThing();
		}
			if(userInput==4) {
						jo.putThing();
		}

//		End of Code
		System.out.println("Code end, thanks for using!");
	} 
}
