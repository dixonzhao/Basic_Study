package cellularData;

/**
 *  Tests the CellularData class by reading in one dimensional arrays of countries.
 *  Given a country name and a range of years, computes the total number of subscriptions
 *  during that period.
 *
 *  @author Foothill College, Bita M, [YOUR NAME HERE]
 */
public class TestCellularData 
{
	public static void main(String[] args) 
	{
		// Part 1: Testing with partial data for a country --------------------
		System.out.println("Testing with Partial Data:");
		final double[] canadaPartial = {0,0,0.046433382,0.229211886,0.370663166,0.752880479,1.264765577};
		final double[] mexicoPartial = {0,0,0,0,0,0.001815204,0.010079818};
		final double[] usaPartial = {0,0.038253436,0.140659444,0.279060364,0.498659917,0.829863407,1.39281703};

		int startingYear = 1983;

		CellularData datatable;
		int numRows = 3;
		int numColumns = canadaPartial.length;

		// TODO: Create a CellularData object with the given number of rows, 
		// 		 columns, and starting year.
		datatable = new CellularData(numRows, numColumns, startingYear);

		// TODO: Add a country and its associated data to the table.
		datatable.addCountry("Canada", canadaPartial);
		datatable.addCountry("Mexico", mexicoPartial);
		datatable.addCountry("United States", usaPartial);

		// TODO: Define the toString() method of the CellularData class to return a 
		//       string representation of the data table. This string will contain
		//       newlines and be terminated with one.
		System.out.println(datatable);
		// the output is:
		/*
		Testing with Partial Data:
		Country	Year	1983	1984	1985	1986	1987	1988	1989	
		Canada			0	0	0.04	0.22	0.37	0.75	1.26	
		Mexico			0	0	0	0	0	0.00	0.01
		United States		0	0.03	0.14	0.27	0.49	0.82	1.39	
		 */
		// Note: As long as your output is easily readable,
		//       then the alignment (i.e. tabs and white-space) of your output need not match mine.


		// TODO: Get the total number of cellular subscriptions for a given country and time period.
		double totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("United States",1983,1989);
		System.out.printf("United States (1983 to 1989): %.2f \n", totalSubscriptions);
		// country is "usa", subscriptions from 1983 to 1989
		// the output is: 
		// United States (1983 to 1989): 3.18 

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Mexico",1983,1989);
		System.out.printf("Mexico (1983 to 1989): %.2f \n", totalSubscriptions);
		// country is "mexico", subscriptions from 1983 to 1989
		// the output is:
		// Mexico (1983 to 1989): 0.01 

		// testing out-of-bounds data
		// NOTE: Your implementation should check for invalid requested year ranges. 
		//		 For example, the user's request for starting year 1890 is invalid.
		// 		 Here, you have two options for your returning a result:
		//		 option 1: Display a message and return -1 if either start or 
		//				   end year of requested period is invalid.
		//		 option 2 (recommended): Display a message and return the 
		//				   total number of subscriptions for the valid sub-period.
		//				
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Canada",1890, 2000);
		System.out.printf("Canada (1890 to 2000): %.2f \n", totalSubscriptions);
		// the output is:
		// Illegal Argument Request of start year 1890. Valid period for Canada is 1890 to 2000.
		// Canada (1890 to 2000): -1.00 


		// Part 2: Testing with all data for a country --------------------------------------------
		System.out.println("\n\nTesting with All Data:");
		final double[] canada = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.046433382,
				0.229211886,0.370663166,0.752880479,1.264765577,2.110674786,2.769888481,3.621301434,
				4.648371087,6.435664704,8.840378661,11.82226558,14.04583637,17.73689555,22.72196984,
				28.42909462,34.36625958,37.94941948,42.07126881,47.06386648,52.75959279,57.49320536,
				61.47310755,66.20487722,70.54830532,75.676078,77.82549309,79.56833775,80.61008074,
				81.0393165};
		final double[] mexico = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.001815204,
				0.010079818,0.074266061,0.183067275,0.348322481,0.421293924,0.608553991,0.721767371,
				1.051320868,1.758956617,3.326889843,7.556565917,13.55289414,20.65462731,24.29476815,
				27.85371761,35.15321825,42.56115672,49.40875353,58.62729509,65.49948112,71.45817512,
				77.51826326,79.24118294,83.35070827,87.26062913,82.22000923};
		final double[] usa = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.038253436,0.140659444,
				0.279060364,0.498659917,0.829863407,1.39281703,2.075802366,2.939643902,4.249049037,
				6.103716586,9.104921407,12.6047249,16.23815248,20.14238484,24.89063952,30.57610298,
				38.46809105,44.69057874,48.85103822,54.84681409,62.54719598,68.31769507,76.29353842,
				82.06414479,85.20916517,88.62364611,91.31165202,94.44042596,96.01037609,97.07773939,
				110.2041935};


		// NOTE: Your program should be able to handle a variety of ranges of years (i.e. start year to end year). 
		//        So, do *not* assume that the data will always start from 1960 or end in on a particular year.
		startingYear = 1960;

		numRows = 3;
		numColumns = canada.length;

		datatable = new CellularData(numRows, numColumns, startingYear);

		datatable.addCountry("Canada", canada);
		datatable.addCountry("Mexico", mexico);
		datatable.addCountry("United States", usa);

		System.out.println(datatable);
		// the output is:
		/*
		Testing with All Data:
        Country,Year      1960      1961      1962      1963      1964      1965      1966      1967      1968      1969      1970      1971      1972      1973      1974      1975      1976      1977      1978      1979      1980      1981      1982      1983      1984      1985      1986      1987      1988      1989      1990      1991      1992      1993      1994      1995      1996      1997      1998      1999      2000      2001      2002      2003      2004      2005      2006      2007      2008      2009      2010      2011      2012      2013      2014    
              Canada         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0      0.05      0.23      0.37      0.75      1.26      2.11      2.77      3.62      4.65      6.44      8.84     11.82     14.05     17.74     22.72     28.43     34.37     37.95     42.07     47.06     52.76     57.49     61.47     66.20     70.55     75.68     77.83     79.57     80.61     81.04    
              Mexico         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0      0.00      0.01      0.07      0.18      0.35      0.42      0.61      0.72      1.05      1.76      3.33      7.56     13.55     20.65     24.29     27.85     35.15     42.56     49.41     58.63     65.50     71.46     77.52     79.24     83.35     87.26     82.22    
       United States         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0      0.04      0.14      0.28      0.50      0.83      1.39      2.08      2.94      4.25      6.10      9.10     12.60     16.24     20.14     24.89     30.58     38.47     44.69     48.85     54.85     62.55     68.32     76.29     82.06     85.21     88.62     91.31     94.44     96.01     97.08    110.20    
		 */
		// Note: As long as your output is easily readable,
		//       then the alignment (i.e. tabs and white-space) of your output need not match mine.

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("United States",1983,1989);
		System.out.printf("United States (1983 to 1989): %.2f \n", totalSubscriptions);
		// the output is:
		// United States (1983 to 1989): 3.18

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Mexico",1960,2000);
		System.out.printf("Mexico (1960 to 2000): %.2f \n", totalSubscriptions);
		// the output is:
		// Mexico (1960 to 2000): 29.62

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Canada",1890, 2000);
		System.out.printf("Canada (1890 to 2000): %.2f \n", totalSubscriptions);
		// the output is:
		// Illegal Argument Request of start year 1890. Valid period for Canada is 1890 to 2000.
		// Canada (1890 to 2000): -1.00 


		// TODO: For full credit, include test cases in addition to those provided.
		//
		// TODO: Also, make sure to test for other invalid requests.
		//
		
		
		System.out.println();
		
		// Part 4: Testing with partial data for a country(case of different exceed year) --------------------
				System.out.println("Testing with Partial Data:");
				final double[] BangladeshPartial = {6.28776238,13.20573922,23.46762823,30.16828408,34.35334451,44.94535882,55.19256723,62.82023906,74.42964608,80.03535051};
				final double[] BrazilPartial = {0,53.11025849,63.67475185,78.5549801,87.54187651,100.8810115,119.0023853,125.0018521,135.3050481,138.9514906};
				final double[] GermanyPartial = {94.55486999,102.2828888,115.1403608,126.5575074,126.2280577,106.4836959,109.6595675,111.5940398,120.9211651,120.4201855};
				startingYear = 1983;

				numRows = 3;
				numColumns = BangladeshPartial.length;

				CellularData
				datatable1= new CellularData(numRows, numColumns, startingYear);
				

				datatable1.addCountry("Bangladesh", BangladeshPartial);
				datatable1.addCountry("Brazil", BrazilPartial);
				datatable1.addCountry("Germany", GermanyPartial);


				System.out.println(datatable1);
				
				double TotalSubscriptions = datatable1.getNumSubscriptionsInCountryForPeriod("Germany ",1985,2010);
				System.out.printf("Germany (1983 to 1989): %.2f \n", TotalSubscriptions);


				TotalSubscriptions = datatable1.getNumSubscriptionsInCountryForPeriod("Brazil",1900,1989);
				System.out.printf("Brazil (1983 to 1989): %.2f \n", TotalSubscriptions);
			

				
				TotalSubscriptions = datatable1.getNumSubscriptionsInCountryForPeriod("Bangladesh",1890, 2000);
				System.out.printf("Bangladesh (1890 to 2000): %.2f \n", TotalSubscriptions);
				
				System.out.println();
		// Part 5: Testing with data for a country --------------------
				System.out.println("Testing with   Data:");
				final double[] Afghanistan  = {37.89493697,45.77817474,60.32631999,65.45219346,70.66135885,74.88284241};
				final double[] Albania  = {78.1845877,85.468247,98.29153459,110.6865316,116.1572081,105.4699657};
				final double[] Algeria  = {0,0,0,97.52089467,100.7877205,92.94793073};
				final double[] Ala  = {0,0,0,97.52089467,100.7877205,92.94793073};
				startingYear = 1983;

				
				numRows = 4;
				numColumns = Afghanistan .length;

			
				datatable1= new CellularData(numRows, numColumns, startingYear);


				datatable1.addCountry("Afghanistan", Afghanistan );
				datatable1.addCountry("Albania", Albania );
				datatable1.addCountry("Algeria", Algeria );
				datatable1.addCountry("Ala", Ala );

				System.out.println(datatable1);
				
				TotalSubscriptions = datatable1.getNumSubscriptionsInCountryForPeriod("Algeria",1983,1989);
				System.out.printf("Algeria (1983 to 1989): %.2f \n", TotalSubscriptions);


				TotalSubscriptions = datatable1.getNumSubscriptionsInCountryForPeriod("Albania",1983,1989);
				System.out.printf("Albania (1983 to 1989): %.2f \n", TotalSubscriptions);
			

				
				TotalSubscriptions = datatable1.getNumSubscriptionsInCountryForPeriod("Afghanistan",1890, 2000);
				System.out.printf("Afghanistan (1890 to 2000): %.2f \n", TotalSubscriptions);
				
				TotalSubscriptions = datatable1.getNumSubscriptionsInCountryForPeriod("Ala",1890, 2000);
				System.out.printf("Ala (1890 to 2000): %.2f \n", TotalSubscriptions);
		
		
	
	}
}
