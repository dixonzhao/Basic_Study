import java.util.Scanner;

// Notice that we don't have "import becker.robots.*;" anymore.
// If we wanted to get input from the keyboard we would "import java.util.Scanner;" here.

public class Nonrobot_Template extends Object {
	public static void main(String[] args) {
		// Notice how we don't need to setup the city anymore

		/* Your code should go here: */
		System.out.println("Hello, User! Please type an integer");
		Scanner sc = new Scanner(System.in);
		int in = 0;
		if(sc.hasNextInt()) {
			in =sc.nextInt();
		} else {
			System.out.println("Please enter integer only, thank you!");
		}
		
		System.out.println("You just typed: "+ in);
		System.out.println("Twice what you just typed is: " +in*2);
		
		
		
		
		
	}
}
