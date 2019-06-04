package week05_part02.solution;

/**
 * An instance of MagazineSubscription has a logo
 * and linked list of 0 or more subscribing customers.
 * @author Foothill College, Bita M
 */
public class MagazineSubscriptionsLL implements Cloneable
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

	
	public void addCustomer(Customer subscriber)
	{
		customers.addInFront(subscriber);
		totalSubscriptions++;
	}

	/**
     * Clones a MagazineSubscriptions object by allocating a new object of type MagazineSubscriptions.
     * Then cloning information missing from the provided constructor.
     * 
     * Hint: This one is a short one.
     *       Implement clone for class CustomerLinkedList such that it
     *       provides a clone of every single node.
     *       
     * @return Object    The deep copy of the MagazineSupscriptionLL
	 */
	protected Object clone()
	{			
		// PRACTICE FOR PROJECT
		// Suggestion: Discuss your ideas in the Discussion Forum
		//             To *not* paste Java source code, 
		//             instead discuss by providing pseudo-code.
		
		return null;
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
