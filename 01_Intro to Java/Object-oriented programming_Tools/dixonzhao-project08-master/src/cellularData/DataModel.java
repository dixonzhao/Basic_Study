package cellularData;

import cellularData.CSVReader;
import cellularData.Country;

/**
 * Provides access to CSV data.
 * @author Foothill College, Bita M. Zhili Zhao
 */
public class DataModel 
{
	private Country[] cellularModel;

	public DataModel()
	{
		cellularModel = parseCSVFile("resources/cellular.csv");		
	}
	
	private Country[] parseCSVFile(final String filename)
	{
		// Parses the CSV data file
		// NOTE: Handle all exceptions in the constructor.
		//       For full credit, do *not* throw exceptions to main. 
		CSVReader parser = new CSVReader(filename);

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

			current = new Country(countryNames[countryIndex]);

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
		
		return countries;
	}
	
	public Country[] getCellularData()
	{
		return this.cellularModel;
	}
}
