package cellularData;
/**
 *  store the country data 
 *  Creates one object of type CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to create objects of type Country class.
 *
 * @author Foothill College, Zhili Zhao
 *  show Main class for country. 
 * <p>show  complete the function while using the CellularData.java, CSVReader.java and without change ithem<br>
 * show Except the required function, all method and variables are been set to private
 * @param name true
    * store the countries name
    * @param sizeC true
    * store number of subscriptions
    * @param SubscriptionYear[] false
    * store array of Subscription year 
    * @param countInput false
    * store use for check if reach the limit of array.
    * @param controlN false
    * store use for input the start year.
 */
public class Country {
	private String name;
	
	private SubscriptionYear[] subscriptions;
	private int countInput=0;
	private int sizeC;
	private int startY;
	private Boolean controlN=true;
	/**
     * show default constructor
     * <p>show in case user miss input data<br>
     * show  warning and exit program when no data input<br>
     * 
     */
	Country(){
		System.out.println("Warning: No Parameter input, automatically stop");
		System.exit(0);
	}
	
	/**
     * show main constructor
     * <p>show input the name of country and the number of subscriptions<br>
     * show  check if the input subscription is negative<br>
     * 
     */
	Country(String name,int sizeC){
		if(sizeC>0) {
			subscriptions= new SubscriptionYear[sizeC];
			this.sizeC=sizeC;
			this.name=name;
		} else {
			System.out.println("wrong number of subscription year, please check it.");
		}
	}
	
	
	/**
     * show add funnciton 
     * <p>show use the input year and subscription to create new subscription object <br>
     * show  First check if the array has full<br>
     * show  Second, use the control to input the first year number as start year,
     * 
     */
	public void addSubscriptionYear(int year, double subscription){
		if(countInput<sizeC) {
			if(controlN) {
				startY=year;
				controlN=false;
			}
			subscriptions[countInput]=new SubscriptionYear(year,subscription);
			countInput++;
		}else {
			System.out.println("Warning, exceed input number of subscription. Fail to input."); 
		}
		
	}
	
	/**
     * show get the sum of the subscription of given year range 
     * <p>show use the Cellular Data class functions <br>
     * show  First check the input year range if they are 1. both out of range 2. in reverse order<br>
     * show  Second, take the number inside the subscriptions[] to form the int[] ,<br>
     * show Last, use the getNumSubscriptionsInCountryForPeriod() inside the cellular data class
     */
	public double getNumSubscriptionsForPeriod(int startYear, int endYear) {
		int temp=0;
		
		try {
			if(startYear>endYear) {
				temp=startYear;
				startYear=endYear;
				endYear=temp;
				throw new IllegalArgumentException("");
			}
		}catch(Exception e) {
			System.out.println("Wrong order of years range, has been automatically changed");
		}
		
		try {
			if(startYear<startY&&endYear>startY+sizeC) {
				throw new IllegalArgumentException("");
			}
		}catch(Exception e) {
			System.out.println("Warning: both input start year and end yaer out of range. Has been automatically changed");
		}
		
		CellularData cel= new CellularData(1, sizeC, startY);
		double[] in=new double[sizeC];
		for(int i =0; i<sizeC;i++) {
			in[i]=Double.parseDouble(subscriptions[i].toString());
		}
		cel.addCountry(name, in);
		return cel.getNumSubscriptionsInCountryForPeriod(name, startYear, endYear);
	}
	
	/**
     * show return the string of array 
     * <p>show output the name of country + array of subscriptions <br>
     * 
     */
	public String toString() {
		
		String str =name;
		for(int i =0; i<sizeC;i++) {
			str+=" "+Double.parseDouble(subscriptions[i].toString());
		}
		return str;
	}
	
	/**
     * show get name funciton  
     * <p>show return the name of country <br>
     * 
     */
	public String getName() {
		return name;
	}
	
	/**
     * show get SubscriptionYear object  
     * <p>show use for test the subscription class <br>
     * 
     */
	public SubscriptionYear getSubscriptions(int num) {
		return subscriptions[num];
	}

}
