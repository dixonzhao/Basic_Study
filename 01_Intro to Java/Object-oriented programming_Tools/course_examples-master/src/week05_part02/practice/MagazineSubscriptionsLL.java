package week05_part02.practice;

/**
 * An instance of MagazineSubscription has a logo
 * and linked list of 0 or more subscribing customers.
 * @author Foothill College, Bita M
 */
public class MagazineSubscriptionsLL
{
	private String logo;
	private int totalSubscriptions;
	private CustomerLinkedList customers;

	public MagazineSubscriptionsLL(String logo) 
	{
		this.logo = logo;
		this.customers = new CustomerLinkedList();
		this.totalSubscriptions = 0;
	}
	
	/**
	 * Initializes this object by using another object of the same class.
	 * @param original   the linked list of Customers we want to make a deep copy of
	 */
	public MagazineSubscriptionsLL(MagazineSubscriptionsLL original)
	{
		// TODO: Complete the definition of the copy constructor and
		//       all non-primitive and immutable object such that
		//       this new object is a deep copy of the original.

	    // Hint: This one is a short one.
	    //       Implement clone for class CustomerLinkedList such that it
	    //       provides a clone of every single node.     
	}

	
	public void addCustomer(Customer subscriber)
	{
		customers.addInFront(subscriber);
		totalSubscriptions++;
	}

	protected void setCustomerFee(int index, double updatedFee) throws java.util.NoSuchElementException
	{	
		// get the requested customer number
		Customer found = customers.getCustomerAtIndex(index);
		
		// if customer does not exist, do nothing and return
		if (found == null)
			throw new java.util.NoSuchElementException();
		
		found.setFee(updatedFee);
	}

	public int getNumberOfSubscribers()
	{	return customers.getSize(); } 

 	public String toString() 
	{ 
		String details = "(" + String.format("%-10s, #subs: %-3d", this.logo, this.totalSubscriptions);
		
		details += " customers: " + customers + ")";

		return details;
	}
}
