package cellularData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *  Input a CSV version file and trans it into data that can be accepted by CellularData
 *
 *  @author Foothill College, Bita M, Zhili Zhao
 */


/**
 * show Main class. 
 * <p>show  complete the function while using the CellularData.java and without change it <br>
 * show In constructor method split the data and put it into a temporary CellularData object and use that to process data <br>
 * show Except the required function, all method and variables are been set to private
 * @param countryNames true
    * store the table of countries name
    * @param yearLabels true
    * store the table of years
    * @param cellularDataTable true
    * store the table of data in specific years.
    * @param numC false
    * number of countries in table
    * @param numI false
    * numbers of data in one line 
    * @param startYear true
    * start year of the data 
    *  @param tempCountryName true
    * used for input country name into table {@link}CSVReader(String)
    *  @param tempInstution
    * store the 1D table for data of one line
 */
public class CSVReader {
	private String[] countryNames;
	private int[] yearLabels;
	private double[][] cellularDataTable;
	private int numC;
	private int numI;
	private int startYear;
	private String tempCountryName;
	private double[] tempInstution;
	/**
     * show default constructor
     * <p>show in case user miss input data<br>
     * show  warning and exit program when no data input<br>
     * 
     */
	CSVReader(){
		System.out.println("Warning: No data input, automatically stop");
		System.exit(0);
	}
	 
	/**
     * show primary constructor. 
     * <p>show input file name, <br>
     *  show first extract the number of country and instructions number<br>
     * show initialize a temporary CellularData to process data <br>
     * show extract data from temporary CellularData<br>
     * throw warning when match exception 
     * @param file false
    * file to import
    * @param sca false
    * scanner util
    * @param cel false
    * Temporary CellularData object used to process  data
     */
	CSVReader(String coun){
		File file = new File(coun);
		Scanner sca;
		String temp;
		
		try {
			sca = new Scanner(file);
			numC=this.setNumC(sca);
			numI=this.setNumI(sca);
			CellularData cel =new CellularData(numC, numI, startYear);
			
			for(int i=0; i<numC;i++) {
				temp=sca.nextLine();
				temp=this.setCountry(temp);
				this.setNumber(temp);
				cel.addCountry(tempCountryName, tempInstution);
			}
			
			this.getDataInCelllularData(cel);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Warning: Data input Fail, please check your data first. Program automatically Stopped"
					+ "\n possible wrong data: "
					+ "\n 1). Number of Countries "
					+ "\n 2). Country year didn't match the data number"
					+ "\n 3). The format of data doesn't fit the standard format.");
			System.exit(0);
		}
	}
		
	/**
     * show import Country number . 
     * <p>show input Country name from input String object, <br>
     *  show 1. jump one line to reach to the line that has the number<br>
     * show  2. search for the ","<br>
     * show 2-1. True: use substring to extract the number <br>
     * 2-2. False: display warning to user and exit the program
     * @param reu
    * file default return number
    * @param temp
    * file String been import from Scanner object 
    * @return reu
    */
	private int setNumC(Scanner sca) {
		int reu=-1;
		String temp;
		
		
		sca.nextLine();
		temp=sca.nextLine();
		
		
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i)==44){
				reu=Integer.parseInt(temp.substring(i+1));
			break;
			}
			}
		
		if(reu==-1) {
			System.out.println("Warning: No number of Country, Program automatically stopped.");
			System.exit(0);
		}
		
		return reu;
	}
		
	/**
     * show import Data number. 
     * <p>show input Data from input String object, <br>
     *  show 1. search for the "," the number of data is i+1<br>
     * show  2. extract the first number of table, ready to input the CellularData object to generate year table<br>
     * @return reu
    */
	private int setNumI(Scanner sca) {
		int reu=-1;
		int count=0;
		String temp;

		temp=sca.nextLine();
		
		
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i)==44){
				if(count ==0) {
					if(Integer.parseInt(temp.substring(i+1, i+5))<=0) {
						System.out.println("Warning: No start year input, please check the line of "
								+ "year. Program automatically stopped.");
						System.exit(0);
					}
					this.startYear=Integer.parseInt(temp.substring(i+1, i+5));
					break;
				}
				count++;
			}
			}
		
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i)==44){
				count++;
			}
			}
		
		reu=count;
		return reu;
	}
		
	/**
     * show extract data from temporary CellularData object . 
     * <p>show output directly,
     * @param cel
    */
	private void getDataInCelllularData(CellularData cel) {
		cellularDataTable = cel.table;
		yearLabels=cel.year;
		countryNames=cel.name;
	}
	

	/**
     * show extract country name . 
     * <p>show extract country name by searching for ",", <br>
     *  show 1.search for ","<br>
     * show  2. check if the char next to the "," is number<br>
     * show 2-1. True: cut the data before the "," and return the remaining string to main <br>
     * 2-2. False: keep searching, then do the same in step 2.
     * @param str
     * 	import line with country
     * @return str
     * return line with out country name
    */
	private String setCountry(String str) {
		
		String temp=str;
		
		
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i)==44){
				if(temp.charAt(i+1)>=48 && temp.charAt(i+1)<=57) {
					tempCountryName=temp.substring(0, i);
					str=temp.substring(i+1);
					break;
				}else {
					i++;
					continue;
				}
			}
			}
		
		
		return str;
	}
	
	/**
     * show extract data number  . 
     * <p>extract country name by searching for ",", <br>
      *  show 1.search for ","<br>
     * show 1-1. True: cut the data before the "," and store it back to table <br>
     * 1-1. False: cut the data remaining into table and exit 
     * @param str
    */
	private void setNumber(String str) {
		tempInstution= new double[numI];
		String temp=str;
		
		for(int j=0;j<numI;j++) {
			
			for(int i=0;i<temp.length();i++){
				if(temp.charAt(i)==44){
						tempInstution[j]=Double.parseDouble(temp.substring(0, i));
						temp=temp.substring(i+1);
						break;
				}
			}
			
			
			if(j==numI-1) {
				tempInstution[j]=Double.parseDouble(temp.substring(0));
			}

		}
		
	}
	
	/**
     * show return Country Names  . 
     * <p> return String[] countryNames, 
     * @return countryNames
    */
	public String[] getCountryNames() {
		return countryNames;
	}

	/**
     * show return Year Labels   . 
     * <p> return int[] yearLabels, 
     * @return yearLabels
    */
	public int[] getYearLabels() {
		return yearLabels;
	}

	/**
     * show return Parsed Table  . 
     * <p> return double[][] cellularDataTable , 
     * @return cellularDataTable
    */
	public double[][] getParsedTable() {
		return cellularDataTable;
	}
	

	/**
     * show return Number Of Years  . 
     * <p> return int numI, 
     * @return numI
    */
	public int getNumberOfYears() {
		// TODO Auto-generated method stub
		return numI;
	}

}
