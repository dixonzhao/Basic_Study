package cellularData;

/**
 *  Tests the LinkedList class by creating multiple objects of type Node<T>.
 *  Creates one object of type CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to create objects of type Country class.
 *  Then adds countries to a singly linked list.
 *
 * @author Foothill College, Bita M. [YOUR NAME HERE]
 */

import java.util.Random;
import java.util.Scanner;

public class TestGenericList 
{
	// Sets the Scanner object to the beginning of the input stream
	// Since we will be reading user input in more than one place.
	// To avoid incorrectly closing/reopening closing the stream,
	// the reference to the stream is set as a class attribute.
	public static Scanner keyboard = new Scanner(System.in);

	/**
	 * Creates a generic linked list. Then based on the user's input,
	 * adds a random number of countries to the list.
	 * @param allCountries      An array of Country objects
	 */
	private LinkedList<Country> createRandomListOfCountries(Country [] allCountries)
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

		// TODO: Define the generic LinkedList class one element
		//       and a reference to the next node.
		//       Define the LinkedList class to be a singly list list of generic Node objects.
		LinkedList<Country> selectedCountries = new LinkedList<>();

		for (int i = 0; i < requestedSize; i++)
		{
			// Selects a random index of the Country data array
			int selectedIndex = random.nextInt(allCountries.length);

			// TODO: Modify all attributes and methods of the parameterized class LinkedList 
			//       to hold generic data types.
			Country countryToAdd = allCountries[selectedIndex];
			System.out.printf("Adding country with name %s to the end of the list.\n", countryToAdd.getName());
			selectedCountries.add(countryToAdd);
		}

		return selectedCountries;
	}

	/**
	 * Displays the list of countries. 
	 * Each country index is output along with the country's index in the list.
	 * @param countryList	list of countries to display
	 */
	private void displayGeneratedList(LinkedList<Country> countryList)
	{
		String countryNames = "";
		int counter = 0;

		// TODO: Implement a nested ListIterator class in your generic LinkedList class
		java.util.Iterator<Country> iterator = countryList.iterator();

		// Uses a reference of type ListIterator to traverse your country list and collect country names
		while(iterator.hasNext())
		{
			// NOTE: Each country should be output on a *separate* line.
			//       Otherwise, your output will not be considered readable.
			countryNames += counter + " " + iterator.next().getName();

			// uses a ternary operator to prettify the output
			countryNames += (counter++ % 10  + 1) == 0 ? "\n" : ", ";
		}

		System.out.println("\nNames of countries in list:\n" + countryNames);
		// Assuming the user selects to add 3 songs to the list, the output would be
		// Names of countries in list: 
		// 0 Brazil, 1 Germany, 2 Bangladesh, 
	}

	/**
	 * Tests the contains() method of the generic LinkedList class. 
	 * @param selectedCountryList  list of countries to search
	 */
	private void testSearchInList(LinkedList<Country> selectedCountryList) 
	{		
		// Tests that the iterator of the LinkedList class by calling its toString() method.
		// Note: To debug your list, comment this line in
		System.out.println("\nSize of list: " + selectedCountryList.size());
		System.out.println("\nList of countries: " + selectedCountryList);
		// Assuming the user selects to add 3 songs to the list, the output would be
		// Size of list: 3
		//
		// List of countries: 
		// Brazil		46.31	53.11	63.67	78.55	87.54	100.88	119.00	125.00	135.30	138.95	
		// Germany		94.55	102.28	115.14	126.55	126.22	106.48	109.65	111.59	120.92	120.42	
		// Bangladesh	6.28	13.20	23.46	30.16	34.35	44.94	55.19	62.82	74.42	80.03

		// Check if the name of a country is in the list.
		// If the country is found, print the details.
		// Otherwise output not found.
		System.out.println("\nWhat country do you want to search for?");
		String countryNameToFind = keyboard.nextLine();

		// NOTE: The generic linked list should be able to check whether
		//       the list has an element that equals the generic type
		//       passed as an argument to the contains() method.
		Country tmpCountry = new Country(countryNameToFind);
		Country foundCountry = selectedCountryList.contains(tmpCountry);
		if (foundCountry != null)
		{
			System.out.println("Country " + countryNameToFind + " found with details:\n" + foundCountry);
		}
		else
		{
			System.out.println("Country " + countryNameToFind + " not found.");	
		}
	}

	/**
	 * Tests the getNumSubscriptionsForPeriod() method of LinkedList class. 
	 * @param selectedCountryList  list of countries to search
	 */
	private void testSubscriptionsTotalInList(LinkedList<Country> selectedCountryList) 
	{
		// Testing getNumSubscriptionsForPeriod() method
		displayGeneratedList(selectedCountryList);

		System.out.printf("\nWhat country would you like subscription information about? (Enter a index between 0 and %d)\n", selectedCountryList.size()-1);
		int selectedIndex = Integer.parseInt(keyboard.nextLine());
		try 
		{
			Country foundCountry = selectedCountryList.getIndex(selectedIndex);

			System.out.println("\nWhat subscription period do you want to total? (Enter [starting year],[end year].)");
			String period = keyboard.nextLine();
			String [] tokens = period.split(",");
			int requestedStartYear = Integer.parseInt(tokens[0]);
			int requestedEndYear = Integer.parseInt(tokens[1]);

			double totalSubscriptions = foundCountry.getNumSubscriptionsForPeriod(requestedStartYear,requestedEndYear);
			System.out.printf("Total subscriptions for %s between %d and %d is %f \n", foundCountry.getName(), requestedStartYear, requestedEndYear, totalSubscriptions);
		}
		catch (IllegalArgumentException exc)
		{
			System.err.printf("ERROR: Requested index %d is out of range.", selectedIndex);
			System.err.printf("Valid element positions are (index >= 0 && index < %d).", selectedCountryList.size());
		}
	}


	/**
	 * Uses a CSV to parse a CSV file.
	 * Adds the data for each country to an array of Country objects.
	 * Adds a random selection of countries to a generic LinkedList object.
	 */
	public static void main(String[] args) 
	{		
		final String FILENAME = "resources/cellular_short_oneDecade.csv";	// test file with shorter number of countries and subscription years
		//final String FILENAME = "resources/cellular.csv";	// test file with latest set of countries and subscription years

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
			int numberOfYears = yearLabels.length;   

			// TODO: Initially convert your CountryList to a generic LinkedList and make sure that list builds 
			// 		 correctly using the original Country constructor which takes the numberOfYears to setup
			// 		 the array of subscriptions.
			// NOTE: Once you've verified that your generic LinkedList builds correctly,
			//       make sure to comment the line below before submitting.
			//current = new Country(countryNames[countryIndex], numberOfYears);		// version 1

			// TODO: Once you are successful in creating a generic LinkedList of countries, create a
			// 		 LinkedList of SubscriptionYear in the Country class.
			// 	     So, your Country class should no longer have an array of SubscriptionYear objects.
			current = new Country(countryNames[countryIndex]);	// version 2 and final version of Country constructor

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
		TestGenericList application = new TestGenericList();

		// TODO: Initially, to test your output you may hard-code the number of 
		//       countries added, and the array positions selected.
		//		 However, make sure to comment this out before submitting your work.
		//application.debugListOfCountries(countries);

		// Tests the generic LinkedList class by adding a random number of entries
		// from the array of Country objects.
		LinkedList<Country> selectedCountryList = application.createRandomListOfCountries(countries);

		// Output the countries added to the generic LinkedList
		application.displayGeneratedList(selectedCountryList);

		// Searches the generic LinkedList of countries
		application.testSearchInList(selectedCountryList);

		// Tests retrieving subscription information 
		application.testSubscriptionsTotalInList(selectedCountryList);

		// flush the error stream
		System.err.flush();
		
		/**Start with the personal test 
		 */
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Start with personal test ");
		LinkedList<Country> coou =new LinkedList();
		coou.add(new Country("aaa"));
		System.out.println("add country 'aaa' to linked list(country)");
		System.out.println(coou);
		coou.add(new Country("bbb"));
		System.out.println("add country 'bbb' to linked list(country)");
		System.out.println(coou);
		coou.add(new Country("ccc"));
		System.out.println("add country 'ccc' to linked list(country)");
		System.out.println(coou);
		coou.add(new Country("ddd"));
		System.out.println("add country 'ddd' to linked list(country)");
		System.out.println(coou);
		coou.add(new Country("eee"));
		System.out.println("add country 'eee' to linked list(country)");
		System.out.println(coou);
		
		
		
		System.out.println("\nDone with TestGenericList.");
	}
}