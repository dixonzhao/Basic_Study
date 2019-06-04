package week07_part02;

import java.util.ArrayList;
import java.util.Iterator;


public class TestIteration 
{
	public static void main(String [] args)
	{
		ArrayList<String> groceryList = new ArrayList<String>();
		// somehow we ended up inserting valid and invalid names...
		groceryList.add("apples");
		groceryList.add("oranges");
		groceryList.add("cherries");
		groceryList.add("kiwi");

		System.out.print("original arraylist :\t");
		for(String grocery : groceryList)
		{
			System.out.printf(grocery + ", ");
		}
		System.out.println("\n");
		

		// Uses a for-each loop to traverse a grocery list.
		// QUESTION: What happens if we try to modify an item in
		//           the grocery list?
		for(String item : groceryList)
		{
			item = "2 lb of " + item;
		}
		System.out.println("arraylist update via for-each:\t" + groceryList);		
		
		
		Iterator<String> itr = groceryList.iterator();
		int i = 0;
		while(itr.hasNext())
		{
			String item = itr.next();
			item = "2 lb of " + item;
			groceryList.set(i++, item);
		}
		System.out.println("arraylist update via iterator:\t" + groceryList);		

	}
}
