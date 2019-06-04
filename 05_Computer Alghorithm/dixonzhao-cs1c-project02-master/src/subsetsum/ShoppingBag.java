package subsetsum;

import cs1c.TimeConverter;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * An object of type ShoppingBag class creates an object of type subset sum to find a best 
 * possible grocery shopping list within the given budget.
 * 
 * REMINDER: Include text cases in addition to those provided.
 *           Do this by creating your own input file.
 *           Test your implementation against various budgets, including boundary cases.
 *
 * @author Foothill College, Bita M, Zhili Zhao
 */
public class ShoppingBag 
{
	private ArrayList<Double> priceOfGroceries;

	/**
	 * Parameterized constructor for an object of class ShoppingBag.
	 * Reads in a file and adds the prices into a list of the prices of groceries
	 * @param filePath	The input file to parse.	
	 */
	public ShoppingBag(String filePath)
	{
		// TODO: Define the class GroceriesFileReader
		GroceriesFileReader reader = new GroceriesFileReader();

		// TODO: Define the readFile() method which reads the CSV (Comma Seperated Value) file 
		// of groceries and creates a specified ArrayList of grocery prices.
		// 
		// NOTE: Catch all exceptions in the GroceriesFileReader readFile() method.
		//       That means readFile() method should not throw an exception.
		priceOfGroceries = reader.readFile(filePath);

		// Check the size of the resulting ArrayList object.
		if (priceOfGroceries.size() < 1) 
		{
			System.out.println("WARNING: The list of groceries is empty.");
			return;
		} 

		System.out.printf("The list of groceries has %d items. \n", priceOfGroceries.size());

	}


	/**
	 * Accessor method returns the list of items read from input file.
	 * @return	the price of groceries.
	 */
	public ArrayList<Double> getPriceOfGroceries()
	{
		return priceOfGroceries;
	}

	/**
	 * Reads an input file that contains the prices of the different items.
	 * Then stores and outputs a list of items we can buy
	 * given the condition of how much money you have in your wallet.
	 * We're at a cash only store. So, no checks or credit purchases!
	 * @param args	Not used.
	 */
	public static void main(String[] args) 
	{
		// NOTE: Make sure to use *relative* path instead of specifying the entire path. 
		//       Otherwise, your program will result in run time errors when the instructor
		//       tests your implementation.
		final String FILEPATH = "resources/groceries.txt";

		ShoppingBag bag = new ShoppingBag(FILEPATH);
		ArrayList<Double> shoppingList = bag.getPriceOfGroceries();

		// displays the prices of items in the input file
		System.out.println("Groceries wanted:");
		System.out.println(shoppingList);

		// prompt the user for their budget 
		Scanner keyboard = new Scanner(System.in);
		do 
		{
			// REMINDER: Test your implementation against various budgets, including boundary cases.
			System.out.println("\nEnter your budget:");
		} while(!keyboard.hasNextDouble());

		double budget = Double.parseDouble(keyboard.nextLine());

		// for measuring run time
		long startTime, estimatedTime;
		
		// capture the start time
		startTime = System.nanoTime();    

		// TODO: implement finding subset of groceries that is closest to meeting the user's budget.
		// NOTE: In this part, you only need to keep track of the price of each item,
		// 		 and not the name of the item you are buying.
		ArrayList<Double> purchases = SubsetSum.findSubset(shoppingList, budget);

		// stop the timer
		estimatedTime = System.nanoTime() - startTime;
		
		// report algorithm time
		System.out.println("\nAlgorithm Elapsed Time: "
				+ TimeConverter.convertTimeToString(estimatedTime));

		System.out.println("Purchased grocery prices are:");
		System.out.println(purchases);
		
		System.err.flush();
		System.out.println("Done with ShoppingBag.");
	}
}
