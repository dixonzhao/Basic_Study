package week05_part02.solution;

public class MagazineSubscriptions
{
	public static final int MAX_SIZE = 10;
	private String logo;
	private int totalSubscriptions;
	private Customer[] customers;

	public MagazineSubscriptions(String logo)
	{
		this.logo = logo;

		this.customers = new Customer[MAX_SIZE];
		for (int i = 0; i < customers.length; i++)
			this.customers[i] = null;

		this.totalSubscriptions = 0;
	}

	/**
	 * Initializes this object by using another object of the same class.
	 * @param original   the magazine subscriptions we want to make a deep copy of
	 */
	public MagazineSubscriptions(MagazineSubscriptions original)
	{
		this(original.logo);

		// NOTE: Alternatively:
		// this.totalSubscriptions = original.totalSubscriptions;
		totalSubscriptions = original.totalSubscriptions;

		// Important: Every single array position of attribute "customer" must be copied.
		for (int pos = 0; pos < customers.length; pos++)
		{
			// QUESTION: What happens if we call the Customer copy
			//           with "null" object?
			if (original.customers[pos] == null)
				continue;

			// The current object of type Customer is valid, so copy it.
			Customer copiedCustomer = new Customer(original.customers[pos]);
			addCustomer(copiedCustomer);
		}
	}

	public void addCustomer(Customer subscriber)
	{
		this.customers[totalSubscriptions] = subscriber;
		this.totalSubscriptions++;
	}

	protected void setCustomerFee(int index, double updatedFee) throws java.util.NoSuchElementException
	{
		// get the requested customer number
		Customer found = customers[index];

		// if customer does not exist, do nothing and return
		if (found == null)
			throw new java.util.NoSuchElementException();

		found.setFee(updatedFee);
	}

	public int getNumberOfSubscribers()
	{	return customers.length; }

	public String toString()
	{
		String details = "(" + String.format("%-4s, #subs: %-3d: ", this.logo, this.totalSubscriptions);

		for (int i = 0; i < customers.length; i++)
		{
			if (customers[i] ==  null)
				continue;

			details += customers[i];

			if (i < customers.length-2 && customers[i+1] != null)
				details += ", ";
		}

		details += ")";

		return details;
	}
}
