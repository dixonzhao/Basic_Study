package cellularData;
/**
 *  Tests the Country class by creating multiple objects.
 *  Creates one object of type CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to create objects of type Country class.
 *
 * @author Foothill College, Zhili Zhao
 */
public class TestCountry 
{
	/**
	 * Displays the names of countries. 
	 * Each country index is output along with the country's index in the array.
	 * @param countries	array of Country objects
	 */
	private void displayCountryNames(Country [] countries)
	{
		String countryNames = "";
		int counter = 0;

		for (int i = 0; i < countries.length; i++)
		{
			// Concatenates the name of countries.
			countryNames += " " + countries[i].getName();

			// uses a ternary operator to prettify the output
			countryNames += (counter+1) % 5 == 0 ? "\n" : ",";

			counter++;
		}

		System.out.println("\nCountry Names:" + countryNames + "\n");
	}


	/**
	 * Includes test examples for class Country.
	 */
	public static void main(String[] args) 
	{
		// NOTE: Make sure to use relative path instead of specifying the entire
		// path
		// (such as /Users/alicew/myworkspace/so_on_and_so_forth).
		//--final String FILENAME = "resources/cellular_short_oneDecade.csv";	// Directory path for Mac OS X

		// TODO: Make sure to test with the full input file as well
		final String FILENAME = "resources/cellular.csv"; // Directory path for Mac OS X
		// final String FILENAME = "resources\\cellular.csv"; // Directory path for Windows OS (i.e. Operating System)
		
		// For debugging purposes
		final int NUM_COUNTRIES_TO_TEST = 4;			// Note: Include test cases in addition to 4

		// Parses the CSV data file
		// NOTE: Handle all exceptions in the constructor.
		//       For full credit, do *not* throw exceptions to main. 
		CSVReader parser = new CSVReader(FILENAME);

		// In class CSVReader the accessor methods only return values of instance variables.
		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		


		// TODO: Create the class Country to hold the data for one country 
		Country [] countries;
		//countries = new Country[NUM_COUNTRIES_TO_TEST];	// Note: Use this for initial testing of your implementation.

		// An array of Country objects.
		// NOTE: Here, we are no longer using a 2D array of CellularData class.
		//       Instead, each country will hold it's own cellular data.
		//       So, we no longer need the CellularData class.
		countries = new Country[countryNames.length];				 

		// Reference to a Country object
		Country current;

		// Go through each country name parsed from the CSV file.
		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   // OR numberOfYears = dataTable[countryIndex].length;

			// Create a Country object
			// TODO: Create a class constructor which takes two arguments:
			//       1) a String for the name of the country
			//       2) an integer for the number of cellular data for each country
			// NOTE: Similar to the previous project we'll assume the data is well formed
			//       with the same number of years of cellular data for all countries.
			current = new Country(countryNames[countryIndex], numberOfYears);

			// Go through each year of cellular data read from the CSV file.
			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];

				// TODO: Create the class SubscriptionYear to hold two the data 
				//       for one cellular year:
				//       1) an integer for the year
				//       2) a double for the subscriptions for that year
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}

			// add the newly created country to the 1D array
			countries[countryIndex] = current;
		}

		// Provides methods for testing the data table of Country objects.
		TestCountry application = new TestCountry();

		// Displays the name of each Country object
		application.displayCountryNames(countries);
		// Given the cellular_short_oneDecade.csv file, the output is:
		// Country Names: Bangladesh, Bahamas, The, Brazil, Germany,


		// Tests finding a country and retrieving subscriptions between a requested period 
		// 
		double totalSubscriptions;
		int countryNum;
		int requestedStart = 0, requestedEndYear = 0;
		
		try 
		{
			countryNum = 0;
			requestedStart = 1960;
			requestedEndYear = 2014;
			System.out.printf("Requesting subscriptions for \"%s\" between %d - %d. \n", countryNames[countryNum], requestedStart, requestedEndYear);
			totalSubscriptions = countries[countryNum].getNumSubscriptionsForPeriod(requestedStart,requestedEndYear);
			System.out.printf("Total subscriptions = %.2f \n\n", totalSubscriptions);
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println(ex.getMessage());
		}
		// Given the full cellular.csv file, the output is:
		// Requesting subscriptions for "Afghanistan" between 1960 - 2014. 
		// Total subscriptions = 420.07 

		// TODO: Comment this line if your test input has fewer than countryNum countries.
		try 
		{
			countryNum = 100;
			requestedStart = 1950;
			requestedEndYear = 2014;
			System.out.printf("Requesting subscriptions for \"%s\" between %d - %d. \n", countryNames[countryNum], requestedStart, requestedEndYear);
			totalSubscriptions = countries[countryNum].getNumSubscriptionsForPeriod(requestedStart,requestedEndYear);
			System.out.printf("Total subscriptions = %.2f \n\n", totalSubscriptions);
		} 
		catch (IllegalArgumentException ex) 
		{
			System.out.println(ex.getMessage());
		}
		// Given the full cellular.csv file, the output is:
		// Requesting subscriptions for "Hong Kong SAR, China" between 1950 - 2014. 
		// Illegal Argument Request of year range 1950-2014. Valid period for Hong Kong SAR, China is 1960 to 2014.
		// Total subscriptions between 1960 - 2014 = 2561.16 
		//
		// NOTE: For a more user friendly output adjust the invalid requested range to a valid range.
		//       Then, inform the user of the adjusted date and the total subscriptions.

		// TODO: Comment this line if your test input has fewer than countryNum countries.
		try 
		{
			countryNum = 200;
			requestedStart = 1000;
			requestedEndYear = 5000;
			System.out.printf("Requesting subscriptions for \"%s\" between %d - %d. \n", countryNames[countryNum], requestedStart, requestedEndYear);
			totalSubscriptions = countries[countryNum].getNumSubscriptionsForPeriod(requestedStart,requestedEndYear);
			System.out.printf("Total subscriptions = %.2f \n\n", totalSubscriptions);
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println(ex.getMessage());
		}
		
		
		try 
		{
			countryNum = 200;
			requestedStart = 5000;
			requestedEndYear = 1000;
			System.out.printf("Requesting subscriptions for \"%s\" between %d - %d. \n", countryNames[countryNum], requestedStart, requestedEndYear);
			totalSubscriptions = countries[countryNum].getNumSubscriptionsForPeriod(requestedStart,requestedEndYear);
			System.out.printf("Total subscriptions = %.2f \n\n", totalSubscriptions);
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println(ex.getMessage());
		}
		// Given the full cellular.csv file, the output is:
		// Requesting subscriptions for "Rwanda" between 2010 - 2014. 
		// Total subscriptions = 243.14 

		// TODO: For full credit, include test cases in addition to those provided.
		//
		// TODO: Also, make sure to test for other invalid requests for range of years.
		//
		
		try 
		{
			countryNum = 200;
			requestedStart = 2014;
			requestedEndYear = 2010;
			System.out.printf("Requesting subscriptions for \"%s\" between %d - %d. \n", countryNames[countryNum], requestedStart, requestedEndYear);
			totalSubscriptions = countries[countryNum].getNumSubscriptionsForPeriod(requestedStart,requestedEndYear);
			System.out.printf("Total subscriptions = %.2f \n\n", totalSubscriptions);
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println(ex.getMessage());
		}
		// Given the full cellular.csv file, the output is:
		// Requesting subscriptions for "Rwanda" between 2010 - 2014. 
		// Total subscriptions = 243.14 

		// TODO: For full credit, include test cases in addition to those provided.
		//
		// TODO: Also, make sure to test for other invalid requests for range of years.
		//
		try 
		{
			System.out.println(countries[200].getSubscriptions(30).toString());
			System.out.println();
			System.out.println();
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println(ex.getMessage());
		}
		
		Country cc=new Country("cou",-1);
		System.out.println();
		System.out.println();
		
		try 
		{
			System.out.printf(countries[200].toString());
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println(ex.getMessage());
		}
		
		
	}
}
