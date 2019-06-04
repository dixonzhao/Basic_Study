// notice that we don't have "import becker.robots.*;" anymore
import java.util.Scanner;


public class TipCalc extends Object
{
   public static void main(String[] args)
   { 
	  // Notice how we don't need to setup the city anymore

		// create a new Scanner
	   Scanner keyboard= new Scanner(System.in);
		System.out.println("Please type in the cost of the meal");

		//double precision floating point number
		double costOfMeal=0;
		
		if( keyboard.hasNextDouble()) // if user typed in a whole number
		{
			// go and get the number
			costOfMeal = keyboard.nextDouble();
			if(costOfMeal>0) {
				double tip15 = costOfMeal * 0.15;
				double tip20 = costOfMeal * 0.20;
				double tip30 = costOfMeal * 0.30;
				
				System.out.println(
						"tip of 15% is :"+ tip15
						+ "\ntip of 20% is : "+ tip20
						+ "\ntip of 30% is : "+ tip30);
				// print out tip15, tip20, tip30
				
			} else {
				System.out.println("You need a postive price!");
				System.exit(0);
			}
			
		} else {
			System.out.println("You need a postive integer price!");
			System.exit(0);
		}
		
		
		System.out.println("Cost is: " + costOfMeal );

		// boolean - true/false
		boolean mealIsPricey ;
		
//		Examples of assigning a true/false value to a boolean variable:
//		mealIsPricey = false;
//		mealIsPricey = 1 < 4;

		// You'll need to fill in what you really want to assign 
		// to mealIsPricey here:
		
		mealIsPricey = costOfMeal>20;
		// We now use the boolean variable:
		if( mealIsPricey ) 
			System.out.println("the meal is expensive" );
		
		
		
   }
}


