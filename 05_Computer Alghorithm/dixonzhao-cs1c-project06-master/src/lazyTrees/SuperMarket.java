package lazyTrees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Simulates the market scenario of buying and adding items to a store's inventory.
 * Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted) 
 * and current inventory (non deleted only).
 *
 * @author Foothill College, [YOUR NAME HERE]
 */
public class SuperMarket 
{
	public static final boolean SHOW_DETAILS = true;

	// TODO: Define the functor class PrintObject to traverse and print out data 
	//       from LazySearchTree.
	PrintObject<Item> printObject = new PrintObject<Item>();

	// The data structure, which we use to add and remove items.
	private LazySearchTree<Item> inventory;	

	// The maximum number of items soft removed before calling collectGarbage()
	// TODO: Test your implementation with varying number of items to be deleted
	//       before calling garbage collection.
	private static final int GARBAGE_COLLECTION_THRESHOLD = 4;

	// Keeps track of the count of soft deleted item
	private int countDeleted;

	/**
	 * Instantiates inventory to be a LazySearchTree of Item objects.
	 */
	public SuperMarket()
	{
		inventory = new LazySearchTree<Item>();
	}

	/**
	 * Add a new item with the name as in parameter into inventory. If there is 
	 * already same name product, increase amount by one, if not create a new object.
	 * @param item		The item to be added to the inventory tree.
	 */
	public void addToInventory(String item)
	{
		// Create a temporary object to hold the item.
		Item tmp = new Item(item);

		// Check if the item is in the inventory tree.
		boolean isFound = inventory.contains(tmp);

		// If the item is not found, add the temporary object as another node (category) to the tree.
		if (!isFound)
		{
			// TODO: Modify insert method to work with lazy deletion such that it updates
			//       both hard and soft sizes. 
			inventory.insert(tmp);

			// NOTE: Need to check if the item was lazily deleted, then we need to increment the count
			Item found = inventory.find(tmp);
			if (found.getCount() == 0)
			{
				found.incrementCount();
			}
			return;
		}

		// If the item is found, increase the number of items in that item category.
		Item found = inventory.find(tmp);

		// item was previously in tree, so increment the count
		found.incrementCount();
	}

	/**
	 * If the item is in the inventory, decrease the count by one. 
	 * If only one item is left, remove it from the inventory. 
	 * @param item		The item to be removed to the inventory tree.
	 */
	public void removeFromInventory(String item)
	{
		Item tmp = new Item(item);
		boolean isFound = inventory.contains(tmp);

		// check if the item exists in the inventory disregarding lazy deletion
		if (!isFound)
		{
			throw new NoSuchElementException();
		}

		Item found = inventory.find(tmp);

		// if the items has zero left in stock, 
		// then treat it as if it does not exist in the tree.
		if (found.getCount() == 0)
		{
			throw new NoSuchElementException();
		}
		// if the item has one left in stock, 
		// then decrement its count and lazy delete it in the tree. 
		else if (found.getCount() == 1)
		{
			found.decrementCount();

			// Lazy deletes a node in the tree by marking it as "deleted".
			inventory.remove(tmp);	

			// keep track of how many items have been deleted so far.
			// NOTE: Once this count reaches a threshold, we call cleanInventory()
			//       to garbage collect the soft deleted nodes from the tree.
			countDeleted++;
		}
		// otherwise, simply decrement its count.
		else
		{
			found.decrementCount();
		}
	}

	/**
	 * When the soft deleted items reaches the threshold, hard remove them from the tree structure. 
	 * @return	Whether garage collection was successful.
	 */
	public boolean cleanInventory(String message){

		if (countDeleted < GARBAGE_COLLECTION_THRESHOLD) 
			return false;

		// TODO: Hard remove nodes marked as "deleted" from the tree.
		boolean result = inventory.collectGarbage();

		System.out.println("\n" + message);
		System.out.println("calling garbage collection...");

		displayInventoryState("inventory after garbage collection:", true);

		countDeleted = 0;

		return result;
	}


	/** 
	 * Display the first item and last item of the soft tree in lexical order.
	 */
	public void showFirstAndLastItem(String message)
	{
		System.out.println("\n" + message);

		// TODO: Modify the protected methods findMin() and findMax() to implement lazy deletion. 
		//       Searches from the root of the tree and returns the minimum and maximum node that 
		//       has NOT been "deleted". 
		try
		{
			Item min = inventory.findMin();
			System.out.println ( "First item: " + min.toString());
		} 
		catch (Exception NoSuchElementException)
		{
			System.out.println("Warning: minimum element not found!");
		}

		try
		{
			Item max = inventory.findMax();
			System.out.println ( "Last item: " + max.toString());
		} 
		catch (Exception NoSuchElementException)
		{
			System.out.println("Warning: maximum element not found!");
		}

	}

	/**
	 * Shows the state of the tree by displaying:
	 * - the *hard* inventory, which includes deleted nodes.
	 * - the *soft* inventory, which excludes deleted nodes.
	 * @param message	Additional details about the state.
	 * @param showTree	Set to true if we want to display the contents of the tree
	 */
	protected void displayInventoryState(String message, boolean showTree)
	{
		System.out.println("\n" + message);
		System.out.println("\"hard\" number of unique items (i.e. mSizeHard) = " + inventory.sizeHard());
		System.out.println("\"soft\" number of unique items (i.e. mSize) = " + inventory.size());

		if (!showTree)
			return;

		System.out.println( "\nTesting traversing \"hard\" inventory:");

		// TODO: First, rename the public/private pair traverse() method of FHsearch_tree to traverseHard() method.
		//       Then, reuse this public/private pair of methods to traverses the tree
		//       and displays all the nodes.
		// NOTE: Here, we call the public version.
		inventory.traverseHard(printObject);


		System.out.println( "\n\nTesting traversing \"soft\" inventory:");

		// TODO: Define a public/private pair of methods that traverses the tree
		//       and displays only nodes that have not been lazily deleted. 
		// NOTE: Here, we call the public version.
		inventory.traverseSoft(printObject);
		System.out.println("\n");
	}

	public static void main(String[] args) 
	{
		// TODO: Tests the LazySearchTree by adding and removing items from the inventory
//		final String TESTFILE = "resources/inventory_log.txt";	// Directory path for plain-text file

		// NOTE: Short inventory file to test for removal of root node from LazySearchTree
//		final String TESTFILE = "resources/inventory_short.txt";

		// NOTE: An example of testing the boundary condition when removing an item that may not exist
//		final String TESTFILE = "resources/inventory_invalid_removal.txt";

		final String TESTFILE = "resources/inventory_sample.txt";

//		final String TESTFILE = "resources/inventory_except.txt";

//		final String TESTFILE = "resources/inventory_empty.txt";

		System.out.printf("Test file: %s \n", TESTFILE);

		System.out.println("Garbage collection threshold = " + GARBAGE_COLLECTION_THRESHOLD);

		SuperMarket market = new SuperMarket();

		File infile = new File(TESTFILE);

		try 
		{
			Scanner input = new Scanner(infile);

			String line = "";
			int lineNum = 0;
			while (input.hasNextLine()) 
			{
				lineNum++;
				line = input.nextLine(); 
				String [] tokens = line.split(" ");

				String selection = tokens[0];
				String itemName = tokens[1];

				String message = "at line #" + lineNum + ": " + line;

				// When an item is added:
				// If the item is not in our inventory, 
				// create a new entry in our inventory.
				// Otherwise, increment the count of the item.
				if (selection.equals("add"))
				{
					market.addToInventory(itemName);

					// NOTE: Currently displaying the contents is disabled to reduce cluttering the output.
					// Suggestion: To start, enable displaying the contents of the tree to help you debug.
					if (SHOW_DETAILS)
						market.displayInventoryState("\nUpdate " + message, true);
				}

				// When an item is bought: 
				// Decrement the count of the item.
				// If the item is out of stock, 
				// remove the item from inventory.
				//
				// Note: buying an out of stock item, is invalid. Handle it appropriately.
				else if (selection.equals("buy"))
				{
					try
					{
						market.removeFromInventory(itemName);

						// NOTE: Currently displaying the contents is disabled to reduce cluttering the output.
						// Suggestion: To start, enable displaying the contents of the tree to help you debug.
						if (SHOW_DETAILS)
							market.displayInventoryState("\nUpdate " + message, true);						
					}
					catch (java.util.NoSuchElementException ex)
					{
						// Note: Ideally we'd print to the error stream,
						// but to allow correct interleaving of the output
						// we'll use the regular output stream.
						System.out.printf("\nWarning: Unable to fulfill request: %s \n", message);
						System.out.printf("Warning: Item %s is out of stock.\n", itemName);
					}
				}
				else
				{
					System.out.println("Warning: Inventory selection not recognized!");
				}		

				// Display the first item and the last item before checking
				// if it's time to clean up our inventory.
				if (SHOW_DETAILS)
					market.showFirstAndLastItem(message);

				// Checks if we need to collect garbage.
				// TODO: Add collectGarbage() to your LazySearchTree class such that it removes
				//       all nodes that have been marked for lazy deletion. 
				market.cleanInventory(message);
			}
			input.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 

		// Display the inventory
		market.displayInventoryState("\nState of inventory before cleanup:", true);
		market.inventory.collectGarbage();
		market.displayInventoryState("\nFinal state of inventory after cleanup:", true);

		// flush the error stream
		System.err.flush();

		System.out.println("\nDone with SuperMarket.");
	}
}
