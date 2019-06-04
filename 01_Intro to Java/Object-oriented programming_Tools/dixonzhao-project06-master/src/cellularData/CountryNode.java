package cellularData;
/**
 *  store the basic element of linkedlist CountryList 
 * Create new CountryNode and ready 2 constructor for add and initialize
 *
 * @author Foothill College, Zhili Zhao
 *  show basic element of linkedlist CountryList. 
 * <p>show  complete the function while using the Country.java and without change ithem<br>
 * show Except the required function, all method and variables are been set to private
 * @param cou true
    * store the country
    * @param next true
    * store point at the next object
 */
public class CountryNode {
	private Country cou;
	private CountryNode next=null;
	/**
     * show default constructor   
     * <p>show incase one input without param <br>
     * 
     */
	public CountryNode(){
		System.out.println("Warning, no data input, return to upper level");
		return;
	}
	/**
     * show first constructor, for initialize  
     * <p>show only input name and initialize, for the add() in CountryList <br>
     * 
     */
	public CountryNode(Country cou){
		this.cou=cou;
	}
	
	/**
     * show second constructor, for initialize of testCountryList.  
     * <p>show set the next point and the CountryNode at the same time<br>
     * 
     */
	public CountryNode(Country cou, CountryNode next){
		this.cou=cou;
		setNext(next);
	}
	/**
     * show getter of CountryNode  
     * <p> return next pointer
     * 
     */
	public CountryNode getNext() {
		return next;
	}
	/**
     * show setter of CountryNode  
     * <p> set next pointer
     * 
     */
	public void setNext(CountryNode next) {
		this.next = next;
	}
	/**
     * show getter of cou  
     * <p> return country object cou
     * 
     */
	public Country getCou() {
		return cou;
	}
	
	/**
     * add input country node country name in to string
     * <p> return String str
     * 
     */
	public String toString(String str, CountryNode nod) {
		str+=" "+nod.getCou().getName();
		return str;
	}
	
	/**
     * Copy for CountryNode without the next CountryNode
     * <p> return CountryNode object
     * 
     */
	public Country copy() {
		String strAlt=new String(cou.getName());
		SubscriptionYear[] subAlter=cou.getSubscriptions();
		Country couAlt=new Country(strAlt,subAlter);
		return couAlt;
	}
}
