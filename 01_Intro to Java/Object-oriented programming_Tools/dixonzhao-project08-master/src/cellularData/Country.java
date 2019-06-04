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
	
	
	private LinkedList<SubscriptionYear> subscriptions =new LinkedList();
	private int minYear;
	private int maxYear;
	private int countInput=0;
	private int sizeC=0;
	private int startY;
	private Boolean controlN=true;
	/**
     * show default constructor
     * <p>show in case user miss input data<br>
     * show  warning and exit program when no data input<br>
     * 
     */
	public Country(){
		System.out.println("Warning: No Parameter input, automatically stop");
		
		System.exit(0);
	}
	
	
	public Country(String name){
		this.name=name;
	}
	
//	/**
//     * show main constructor
//     * <p>show input the name of country and the number of subscriptions<br>
//     * show  check if the input subscription is negative<br>
//     * 
//     */
//	public Country(String name,int sizeC){
//		if(sizeC>0) {
//			subscriptions= new SubscriptionYear[sizeC];
//			this.sizeC=sizeC;
//			this.name=name;
//		} else {
//			System.out.println("wrong number of subscription year, please check it.");
//		}
//	}
	
//	/**
//     * show Copy constructor
//     * <p>show input the name of country and the subscriptions array <br>
//     * show  Create a new Country based on the input data <br>
//     * 
//     */
//	public Country(String name,SubscriptionYear[] subscriptions){
//		this.name=name;
//		this.subscriptions=subscriptions;
//		this.sizeC=subscriptions.length;
//	}
	
	
	/**
     * show add funnciton 
     * <p>show use the input year and subscription to create new subscription object <br>
     * show  First check if the array has full<br>
     * show  Second, use the control to input the first year number as start year,
     * 
     */
	public void addSubscriptionYear(int year, double subscription){
		
			if(controlN) {
				startY=year;
				minYear=startY;
				controlN=false;
			}
			subscriptions.add(new SubscriptionYear(year,subscription));
			countInput++;
			maxYear=year;
			sizeC++;
		
	}
	
	/**
     * show get the sum of the subscription of given year range 
     * <p>show use the Cellular Data class functions <br>
     * show  First check the input year range if they are 1. both out of range 2. in reverse order<br>
     * show  Second, take the number inside the subscriptions[] to form the int[] ,<br>
     * show Last, use the getNumSubscriptionsInCountryForPeriod() inside the cellular data class
     */
	public double getNumSubscriptionsForPeriod(int startYear, int endYear) throws IllegalArgumentException {
		int temp=0;
		
		try {
			if(startYear>endYear) {
				temp=startYear;
				startYear=endYear;
				endYear=temp;
				System.out.println("Wrong order of years range");
				throw new IllegalArgumentException("");
			}
		}catch(Exception e) {
			throw new IllegalArgumentException("Wrong order of years range");
		}
		
		try {
			if(startYear<startY&&endYear>startY+sizeC) {
				System.out.println("Warning: both input start year and end yaer out of range. ");
				throw new IllegalArgumentException("");
			}
		}catch(Exception e) {
			throw new IllegalArgumentException("Warning: both input start year and end yaer out of range. ");
		}
		
		CellularData cel= new CellularData(1, sizeC, startY);
		double[] in=new double[sizeC];
		
		//iterator() modify
		while(subscriptions.iterator().hasNext()) {
			for(int i =0; i<sizeC;i++)
			in[i]=Double.parseDouble(subscriptions.iterator().next().toString());
		}
		
//		for(int i =0; i<sizeC;i++) {
//			in[i]=Double.parseDouble(subscriptions.getIndex(i).toString());
//		}
		cel.addCountry(name, in);
		return cel.getNumSubscriptionsInCountryForPeriod(name, startYear, endYear);
	}
	
	/**
     * show return the string of array 
     * <p>show output the name of country + array of subscriptions <br>
     * 
     */
	public String toString() {

		if(subscriptions.getIndex(0)==null) {
			System.out.println("no Subscritpions, only name");
			return name;
		}
		String str =name;
		for(Object i:subscriptions) {
			SubscriptionYear iw=(SubscriptionYear)i;
			str+=" "+iw.getSubscription();
		}
//		for(int i =0; i<sizeC;i++) {
//			str+=" "+Double.parseDouble(subscriptions.getIndex(i).toString());
//		}
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
     * show override the euqals to compare the String only  
     * <p>show if name equals they are the same <br>
     * to incase the " has been change to detact and delete
     * 
     */
	@Override
	public boolean equals(Object obj) {
		Country cc=(Country)obj;
		String ori=new String(this.getName());
		if(ori.charAt(0)==34) {
			ori=ori.substring(1, ori.length()-1);
		}
		String inp=new String(cc.getName());
		boolean che=ori.equals(inp);
	    return che;
	}

	/**
     * returns an array of  SubscriptionYear objects  
     * <p>show return a deep copy of  SubscriptionYear array<br>
     * to create a new SubscriptionYear based on the old ones data
     * 
     */
	public LinkedList<SubscriptionYear> getSubscriptions() {
		return subscriptions;
	}
	
	

}
