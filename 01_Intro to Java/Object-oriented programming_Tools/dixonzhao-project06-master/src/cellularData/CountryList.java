package cellularData;
/**
 *  use for initialize the linkedlist  
 *  Creates one list with CountryNode as the basic element used for control country.
 *
 * @author Foothill College, Zhili Zhao
 *  show Main class for country. 
 * <p>show  complete the function while using the Country.java <br>
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
public class CountryList {
	private CountryNode begin;
	private CountryNode temp;
	private CountryList cL;
	private int count=0;
	private int size=0;
	/**
     * show default constructor   
     * <p>show initialize the class <br>
     * 
     */
	public CountryList(){
	}
	
	public CountryList(CountryList cL){
		this.cL=cL.copy();
		this.begin=this.cL.begin;
		this.count=this.cL.count;
		this.size=this.cL.size;
	}
	/**
     * show add method 
     * <p>show add the Country object to the end of the list <br>
     * @param Country cou
     */
	public void add(Country cou) {
		if(cou.getName()==null) {
			System.out.println("Warning! Empty country!");
			return;
		}
		temp=begin;
		if(count==0) {
			begin= new CountryNode(cou);
			count++;
			return;
		}
		while(begin.getNext()!=null) {
			begin=begin.getNext();
		}
		begin.setNext(new CountryNode(cou));
		count++;
		size=count;
		begin=temp;
	}
	
	/**
     * show get country of selected index
     * <p>show from the top to the end count for the number<br>
     * return the Country object if found<br>
     * throw  IndexOutOfBoundsException if index exceed limit 
     */
	public Country getIndex(int ind) throws IndexOutOfBoundsException {
		temp=begin;
		if(ind>=0&&ind<count) {
			while(ind-->0) {
				temp=temp.getNext();
			}
			return temp.getCou();
		} else {
			throw new IndexOutOfBoundsException("index out of bound!");
		}

	}
	
	/**
     * show search if contains country 
     * <p>show return country if find  <br>
     * 
     */
	public Country contains(Country cou) {
		temp=begin;
		while(temp.getNext()!=null) {
			if(temp.getCou().equals(cou)) {
				System.out.println("Yes, contains "+ cou.getName());
				return temp.getCou();
			}
			temp=temp.getNext();
		}
		
		if(temp.getCou().equals(cou)) {
			System.out.println("Yes, contains "+ cou.getName());
			return temp.getCou();
		} 
		else 
		{
			System.out.println("Sorry, this list doesn't contain  "+ cou.getName());
		}
		return null;
	}
	
	/**
     * show @override  the toString() method
     * <p>show print all country in the list  <br>
     * 
     */
	public String toString() {
		temp=begin;
		String reu="";
		int c=count;
		while(c-->0) {
			reu+=temp.getCou()+"\n";
			temp=temp.getNext();
		}
		return reu;
	}
	
	/**
     * show return list size 
     * <p>show return size <br>
     * 
     */
	public int size() {
		return size;
	}
	
	/**
     * show Copy the current list 
     * <p>show  CountryList cL <br>
     * return CountryList cL
     */
	public CountryList copy() {
		//initialize 
		temp=begin;
		CountryList couListAlter=new CountryList();
		//go through all the array 
		while(temp.getNext()!=null) {
			couListAlter.add(temp.copy());
			temp=temp.getNext();
		}
		couListAlter.add(temp.copy());
		
		return couListAlter;
	}

	/**
     * show Replace the index  country 
     *  <br>
     *  1. find the index-1 country  2. take it next() to create a new country 3. replace the previous country next()
     *  
     */
	public void replaceAtIndex(int index, Country cou) {
		temp=begin;
		index+=1;
		if(index==1){
			CountryNode couNe=new CountryNode(cou,begin.getNext());
			begin=couNe;
			return;
		}
		
		for(int i=1;i<index-1;i++) {
			temp=temp.getNext();
		}
		CountryNode couNe=new CountryNode(cou,temp.getNext().getNext());
		temp.setNext(couNe);
	}
}
