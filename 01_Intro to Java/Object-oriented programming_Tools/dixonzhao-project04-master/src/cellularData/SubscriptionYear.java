package cellularData;
/**
 *  store the Subscription & year  data 
 *
 * @author Foothill College, Zhili Zhao
 *  show sub class of country, use for sotre the subscription & year data  
 * <p>show  complete the function while using the CellularData.java, CSVReader.java and without change ithem<br>
 * show In constructor method split the data and put it into <br>
 * show Except the required function, all method and variables are been set to private
 * @param year true
    * store the year number 
    * @param subscription true
    * store subscriptions data 
 */
public class SubscriptionYear {
	private int year;
	private double subscription;
	
	/**
     * show default constructor
     * <p>show in case user miss input data<br>
     * show  warning and exit program when no data input<br>
     * 
     */
	SubscriptionYear(){
		System.out.println("Warning: No Parameter input, automatically stop");
		System.exit(0);
	}
	/**
     * show main constructor
     * <p>show input the year and th subscriptions<br>
     *  * @param year true
    * store the year number 
    * @param subscription true
    * store subscriptions data 
     */
	SubscriptionYear(int year, double subscription){
		this.setYear(year);
		this.setSubscription(subscription);
	}
	/**
     * show override of toString()
     * <p>show return subscriptions
     */
	public String toString() {
		return ""+subscription;
	}
	
	/**
     * show getter of year
     * <p>show return year 
     */
	public int getYear() {
		return year;
	}
	/**
     * setter of year
     * <p>show set year  <br>
     * private 
     */
	private void setYear(int year) {
		this.year = year;
	}
	/**
     * getter of  subscription
     * <p>show set subscription  <br>
     */
	public double getSubscription() {
		return subscription;
	}
	/**
     * setter of  subscription
     * <p>show set subscription<br>
     * private 
     */
	private void setSubscription(double subscription) {
		this.subscription = subscription;
	}
}
