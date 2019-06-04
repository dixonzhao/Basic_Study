package cellularData;

/**
 * Tests creating a deep copy of CountryList via the copy constructor.
 * Starts by creating a list and cloning it.
 * Then changes the data in the copied list to test that the original list
 * is not modified.
 * 
 * @author Foothill College, Zhili Zhao
 */


import java.util.Random;
import java.util.Scanner;

public class TestCopyCountryList
{
    // Sets the Scanner object to the beginning of the input stream
    // Since we will be reading user input in more than one place.
    // To avoid incorrectly closing/reopening closing the stream,
    // the reference to the stream is set as a class attribute.
	Scanner keyboard = new Scanner(System.in);

	/**
	 * Builds a random list of countries.
	 * @param allCountries      An array of Country objects
	 */
	private CountryList createRandomListOfCountries(Country [] allCountries)
	{
		int requestedSize;
		do
		{
			// Prompts the user for the number of elements they want to add to the list.
			System.out.println("How many countries do you want to add to the list?");
			requestedSize = Integer.parseInt( keyboard.nextLine() );
		} while (requestedSize < 1);

		// Build the list out of a random selection of countries.
		Random random = new Random();

		// TODO: Define the CountryNode class to hold the data for one Country object 
		//       and a reference to the next node.
		//       Define the CountryList class to be a singly list list of CountryNode objects.
		CountryList generatedList = new CountryList();

		for (int i = 0; i < requestedSize; i++)
		{
			// Selects a random index of the Country data array
			int selectedIndex = random.nextInt(allCountries.length);

			// TODO: Define the add() method in class such that it adds the randomly
			//       selected Country to the *end* of the list.
			Country countryToAdd = allCountries[selectedIndex];
			System.out.printf("Adding country with name %s to the end of the list.\n", countryToAdd.getName());
			generatedList.add(countryToAdd);
		}
		return generatedList;
	}

	/**
	 * Copies a CountryList object. Then, modifies one or more countries in the 
	 * copied list. Displays the copied list after the update.
	 * @param listOfCountries      The list of countries to be copied and modified.
	 */	
	private void testCopiedList(Country [] allCountries, CountryList theOriginalList, CountryList theCopiedList)
	{	
		System.out.println("Before modifying copied list.");
		System.out.println("original list: ");
		System.out.println(theOriginalList);

		System.out.println("\ncopied list: ");
		System.out.println(theCopiedList);
		/* example output:
		 Before modifying copied list.
		 original list: 
		      Channel Islands		0.000	0.000	...	0.000	0.000	
		              Germany		0.000	0.000	...	120.921	120.420	
		           Arab World		0.000	0.000	...	110.013	108.701	
		         Bahamas, The		0.000	0.000	...	76.052	82.296	

		 copied list: 
		      Channel Islands		0.000	0.000	...	0.000	0.000	
		              Germany		0.000	0.000	...	120.921	120.420	
		           Arab World		0.000	0.000	...	110.013	108.701	
		         Bahamas, The		0.000	0.000	...	76.052	82.296	
		 */

		// Prompts the user for the element they want to modify
		System.out.println("\nWhich index in the list do you want to modify the name?");
		int selectedIndex = Integer.parseInt( keyboard.nextLine() );

		// TODO: Modify an existing country's name.
		// NOTE: This should not affect the element in the original list.
		try
		{
			// get a reference to an existing country in the list to be modified
			Country existingCountryToModify = theCopiedList.getIndex(selectedIndex);
			String previousName = existingCountryToModify.getName();
			
			// TODO: set the name of the country...
			if(selectedIndex!=theCopiedList.size()-1) {
				theCopiedList.replaceAtIndex(selectedIndex, theCopiedList.getIndex(theCopiedList.size()-1));
			} else if(selectedIndex!=0) {
				theCopiedList.replaceAtIndex(selectedIndex, theCopiedList.getIndex(0));
			} else {
				System.out.println("only one Country in the list, unable to change");
			}
			
			// TODO: Display a message describing the changes you made.
			System.out.println("replace the previous country name "+previousName+"with the '  Other Country in the list ' "
					+ "in the index "+ selectedIndex);
			// Check that the list was updated properly.
			// NOTE REGARDING OUTPUT:
			// The difference between the original and the modified node(s) in the copied 
			// list must be *apparent*.
			System.out.println("original list: " + theOriginalList);
			System.out.println("\ncopied list: " + theCopiedList);
			/* example output:
			 Changed the country name "Channel Islands" to "Beautiful Foothill"
             original list: 
		          Channel Islands		0.000	0.000	...	0.000	0.000	
		                  Germany		0.000	0.000	...	120.921	120.420	
		               Arab World		0.000	0.000	...	110.013	108.701	
		             Bahamas, The		0.000	0.000	...	76.052	82.296

             copied list: 
		       Beautiful Foothill	    0.000	0.000	...	0.000	0.000	
		                  Germany		99999.000	0.000	...	120.921	120.420	
		               Arab World		0.000	0.000	...	110.013	108.701	
		             Bahamas, The		0.000	0.000	...	76.052	82.296	
			 */
			
//			Reverse the test case to the original state 
			theCopiedList=theOriginalList.copy();
			
		}
		catch (IndexOutOfBoundsException exc)
		{
			System.err.printf("ERROR: Requested index %d is out of range.", selectedIndex);
			System.err.printf("Valid element positions are (index >= 0 && index < %d).", theCopiedList.size());
		}


		// Prompts the user for the element they want to modify
		System.out.println("\nWhich index in the list do you want to modify the subscriptions?");
		selectedIndex = Integer.parseInt( keyboard.nextLine() );


		// TODO: Modify an existing country's subscription(s).
		//       Test modifying one or more subscriptions.
		// NOTE: This should not affect the element in the original list.
		try
		{
			// get a reference to an existing country in the list to be modified
			Country existingCountryToModify = theCopiedList.getIndex(selectedIndex);

			// TODO: make some changes to the country...
			SubscriptionYear[] subsTest= theCopiedList.getIndex(selectedIndex).getSubtest();
			subsTest[0].setSubscription(123);
			subsTest[1].setSubscription(321);
			subsTest[2].setSubscription(1234567);
			// TODO: Display a message describing the changes you made.
			System.out.println("Reset the "+(selectedIndex+1)+" country's first three subscriptions ");
			// Check that the list was updated properly.
			// NOTE REGARDING OUTPUT:
			// The difference between the original and the modified node(s) in the copied 
			// list must be *apparent*.
			System.out.println("original list: " + theOriginalList);
			System.out.println("copied list: " + theCopiedList);
			/* example output:
			 Changed the Country's Germany subscriptions at index 0.
             original list: 
		          Channel Islands		0.000	0.000	...	0.000	0.000	
		                  Germany		0.000	0.000	...	120.921	120.420	
		               Arab World		0.000	0.000	...	110.013	108.701	
		             Bahamas, The		0.000	0.000	...	76.052	82.296

             copied list: 
		       Beautiful Foothill	    0.000	0.000	...	0.000	0.000	
		                  Germany		99999.000	0.000	...	120.921	120.420	
		               Arab World		0.000	0.000	...	110.013	108.701	
		             Bahamas, The		0.000	0.000	...	76.052	82.296		
			 */
		}
		catch (IndexOutOfBoundsException exc)
		{
			System.err.printf("ERROR: Requested index %d is out of range.", selectedIndex);
			System.err.printf("Valid element positions are (index >= 0 && index < %d).", theCopiedList.size());
		}

		// TODO: Replace an element somewhere in the middle of the list.
		// NOTE: This should not affect the element in the original list.
		try
		{
			// Replaces a specific index in the copiedList.
			// TODO: Define the replaceAtIndex() method in CountryList class such that it replaces a specific index
			//       and accepts two arguments:
			//       - an argument of type int, which is the index at which the specified element is to be inserted;
			//       - an argument of type Country, which is the element to be inserted.
			//       NOTE: If the requested index is invalid throws an IndexOutOfBoundsException.
			Random random = new Random();
			selectedIndex = random.nextInt(theCopiedList.size()-2)+1;
			Country replacement = allCountries[random.nextInt(allCountries.length)];
			theCopiedList.replaceAtIndex(selectedIndex, replacement);

			// Displays a message describing the changes made.
			System.out.println("\nReplaced index " + selectedIndex + " with country named " + replacement.getName()); // bm

			// Check that the list was updated properly.
			// NOTE REGARDING OUTPUT:
			// The difference between the original and the modified node(s) in the copied 
			// list must be *apparent*.
			System.out.println("original list: " + theOriginalList);
			System.out.println("copied list: " + theCopiedList);
			/* example output:
			 Replaced the country at index 3.
           original list: 
		          Channel Islands		0.000	0.000	...	0.000	0.000	
		                  Germany		0.000	0.000	...	120.921	120.420	
		               Arab World		0.000	0.000	...	110.013	108.701	
		             Bahamas, The		0.000	0.000	...	76.052	82.296		

           copied list: 
		       Beautiful Foothill	    0.000	0.000	...	0.000	0.000	
		                  Germany		99999.000	0.000	...	120.921	120.420	
		                    Nepal		0.000	0.000	...	76.850	81.86	
		             Bahamas, The		0.000	0.000	...	76.052	82.296		
			 */
		}
		catch (IndexOutOfBoundsException exc)
		{
			System.err.printf("ERROR: Requested index %d is out of range.", selectedIndex);
			System.err.printf("Valid element positions are (index >= 0 && index < %d).", theCopiedList.size());
		}


		// TODO: Test your replaceAtIndex() method by specifying different indices.
		//       Make sure to test your implementation by replacing first and last
		//       elements in the list.
		do
		{
			// Prompts the user for the element they want to modify
			System.out.println("\nWhich index in the list do you want to replace?");
			selectedIndex = Integer.parseInt( keyboard.nextLine() );
		} while (selectedIndex < 0 && selectedIndex > theCopiedList.size());

		// TODO: Modify an element in the list.
		// NOTE: This should not affect the element in the original list.
		try
		{
			Country replacement = new Country("Just Test",theCopiedList.getIndex(0).getSubscriptions().length);
			// TODO: Construct a new Country object by giving it a name and 
			//       some subscription information.
			for(int i =0; i<theCopiedList.getIndex(0).getSubscriptions().length;i++) {
				replacement.addSubscriptionYear(i+1900, i);
			}

			// TODO: Display a message describing the changes you made.
			System.out.println("Generate a Country name 'Just test ' Object with desgined subscriptions");
			// Replaces the element at a specified index of he CountryList class.
			// NOTE: If the requested index is invalid throws an IndexOutOfBoundsException.
			theCopiedList.replaceAtIndex(selectedIndex, replacement);

			// Check that the list was updated properly.
			// NOTE REGARDING OUTPUT:
			// The difference between the original and the modified node(s) in the copied 
			// list must be *apparent*.
			System.out.println("original list: " + theOriginalList);
			System.out.println("copied list: " + theCopiedList);
		}
		catch (IndexOutOfBoundsException exc)
		{
			System.err.printf("ERROR: Requested index %d is out of range.", selectedIndex);
			System.err.printf("Valid element positions are (index >= 0 && index < %d).", theCopiedList.size());
		}
	}

	/**
	 * Uses a CSV to parse a CSV file.
	 * Adds the data for each country to an array of Country objects.
	 * Adds a random selection of countries to a CountryList object.
	 * Copies the country list and modifies it.
	 */
	public static void main(String[] args) 
	{
		// NOTE: Make sure to use relative path instead of specifying the entire path
		// (avoid entire path such as /Users/alicew/myworkspace/so_on_and_so_forth).
		// final String FILENAME = "resources/cellular_short_oneDecade.csv";	// Directory path for Mac OS X

		// TODO: Make sure to test with the full input file as well
		final String FILENAME = "resources/cellular.csv"; // Directory path for Mac OS X
		// final String FILENAME = "resources\\cellular.csv"; // Directory path for Windows OS (i.e. Operating System)
		
		// Parses the CSV data file
		// NOTE: Handle all exceptions in the constructor.
		//       For full credit, do *not* throw exceptions to main. 
		CSVReader parser = new CSVReader(FILENAME);

		// In class CSVReader the accessor methods only return values of instance variables.
		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		

		// Holds the data for all Country object read from the input data file.
		Country [] countries;

		// Initializes the to the number of entries read by CSVReader.
		countries = new Country[countryNames.length];

		// Reference to a Country object
		Country current;

		// Go through each country name parsed from the CSV file.
		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   // OR numberOfYears = dataTable[countryIndex].length;

			// Create a Country object.
			current = new Country(countryNames[countryIndex], numberOfYears);

			// Go through each year of cellular data read from the CSV file.
			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}

			// Add the newly created country to the 1D array.
			countries[countryIndex] = current;
		}

		// Creates an object of our current application, for testing purposes.
		TestCopyCountryList application = new TestCopyCountryList();

		// Creates a linked list of randomly selected countries.		
		// TODO: Test your implementation with varying number of items to be
		//       added to your linked list.
		CountryList originalList = application.createRandomListOfCountries(countries);

		// Output the countries added to the CountryList object
		System.out.println("\nList of countries: ");
		System.out.println(originalList);

		System.out.println("\nTesting copying listOfCountries object...");
		// TODO: Complete the implementation of the copy constructor such 
		//       that it creates a copy of an object of the same type.
		CountryList copiedList = new CountryList(originalList);

		// Modify the list of nodes
		// TODO: Complete the implementation such that it modify two or more elements 
		//       in the copied linked list.
		application.testCopiedList(countries, originalList, copiedList);

		// flush the error stream
		System.err.flush();

		System.out.println("\nDone with TestCopyCountryList.");
	}
}