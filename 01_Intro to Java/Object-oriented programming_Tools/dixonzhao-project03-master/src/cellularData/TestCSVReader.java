package cellularData;
/**
 *  Tests the CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to fill the CellularData class.
 *
 * @author Foothill College, Zhili  Zhao
 */
public class TestCSVReader
{
	/**
	 * Uses a CSVReader to parse a CSV file.
	 * Adds each parsed line to an instance of the CellularData class.
	 */
	public static void main(String[] args) 
	{
		// NOTE: Make sure to use relative path instead of specifying the entire
		// path
		// (such as /Users/alicew/myworkspace/so_on_and_so_forth).
//		final String FILENAME = "resources/cellular_short_oneDecade.csv";	// Directory path for Mac OS X

		// TODO: Make sure to test with the full input file as well
		// final String FILENAME = "resources/cellular.csv"; // Directory path for Mac OS X
		 final String FILENAME = "resources\\cellular.csv"; // Directory path for Windows OS (i.e. Operating System)
		
//		 final String FILENAME = "resources\\cellular_short_oneDecade - Copy.csv";
		 
		 
		// TODO: Create the class CSVReader to parse the CSV data file
		//       The class constructor should only take a string as argument
		//       for the name of the input file.
		//       The constructor should fill the array of country names, year labels, etc.
		// NOTE: Handle all exceptions in the constructor.
		//       For full credit, do *not* throw exceptions to main. 
		CSVReader parser = new CSVReader(FILENAME);

		// TODO: In class CSVReader the accessor methods should only return values
		//       at instance variables.
		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		

		// Stores the 2D array of cellular data for all countries.
		CellularData datatable;
		int numRows = parsedTable.length;
		int numColumns = parser.getNumberOfYears();
		int startingYear = yearLabels[0];

		datatable = new CellularData(numRows, numColumns, startingYear);

		// From the array that stores parsed information,
		// add one country at a time to an object of type CellularData.
		for (int countryIndex = 0; countryIndex < countryNames.length; countryIndex++)
		{
			double [] countryData = parsedTable[countryIndex];
			datatable.addCountry(countryNames[countryIndex], countryData);					
		}

		// Display the string representation of the data table.
		System.out.println(datatable);
		// Given the cellular_short_oneDecade.csv file, the output is:
		// Country Name 	2005	2006	2007	2008	2009	2010	2011	2012	2013	2014	
		//   Bangladesh	    6.29	13.21	23.47	30.17	34.35	44.95	55.19	62.82	74.43	80.04	
		// "Bahamas, The"	69.21	75.38	109.34	102.79	101.22	118.83	81.56	80.65	76.05	82.30	
		//       Brazil	    46.31	53.11	63.67	78.55	87.54	100.88	119.00	125.00	135.31	138.95	
		//      Germany	    94.55	102.28	115.14	126.56	126.23	106.48	109.66	111.59	120.92	120.42	
		
		// Tests finding a country and retrieving subscriptions between a requested period 
		// 
		double totalSubscriptions;
		int countryNum;
		int requestedStart = 0, requestedEndYear = 0;

		try 
		{
			countryNum = 1;
			requestedStart = 2005;
			requestedEndYear = 2014;
			System.out.printf("Requesting subscriptions for \"%s\" between %d - %d. \n", countryNames[countryNum], requestedStart, requestedEndYear);
			totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryNames[countryNum], requestedStart,requestedEndYear);
			System.out.printf("Total subscriptions = %.2f \n\n", totalSubscriptions);
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println(ex.getMessage());
		}
		// Given the shorter cellular_short_oneDecade.csv file, the output is:
		// Requesting subscriptions for ""Bahamas, The"" between 2005 - 2014. 
		// Total subscriptions = 897.33 
		
		try 
		{
			countryNum = 2;
			requestedStart = 1960;
			requestedEndYear = 2014;
			System.out.printf("Requesting subscriptions for \"%s\" between %d - %d. \n", countryNames[countryNum], requestedStart, requestedEndYear);
			totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryNames[countryNum], requestedStart,requestedEndYear);
			System.out.printf("Total subscriptions = %.2f \n\n", totalSubscriptions);
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println(ex.getMessage());
		}
		// Given the shorter cellular_short_oneDecade.csv file, the output is:
		// Requesting subscriptions for "Brazil" between 1960 - 2014. 
		// Illegal Argument Request of start year: 1960.
		// Valid period for Brazil is 2005 to 2014.
		// Total subscriptions = 948.34 
		
		try 
		{
			countryNum = 0;
			requestedStart = 1960;
			requestedEndYear = 2014;
			System.out.printf("Requesting subscriptions for \"%s\" between %d - %d. \n", countryNames[countryNum], requestedStart, requestedEndYear);
			totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryNames[countryNum], requestedStart,requestedEndYear);
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
			totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod(countryNames[countryNum], requestedStart,requestedEndYear);
			System.out.printf("Total subscriptions = %.2f \n\n", totalSubscriptions);
		} 
		catch (Exception ex) 
		{
			System.out.println("Warning, data fails, please check input number.");
		}
		// Given the full cellular.csv file, the output is:
		// Requesting subscriptions for "Hong Kong SAR, China" between 1950 - 2014. 
		// Illegal Argument Request of start year: 1950.
		// Valid period for "Hong Kong SAR, China" is 1960 to 2014.
		// Total subscriptions between 1960 - 2014 = 2561.16 
		//
		// NOTE: For a more user friendly output adjust the invalid requested range to a valid range.
		//       Then, inform the user of the adjusted date and the total subscriptions.
		
		// TODO: For full credit, include test cases in addition to those provided.
		//       Use the full cellular.csv for the input file of your additional test cases.
		//
		// TODO: Also, test for additional cases where the requested range of years is invalid.


		System.out.println("\nDone with TestCSVReader.\n");
	}
}
