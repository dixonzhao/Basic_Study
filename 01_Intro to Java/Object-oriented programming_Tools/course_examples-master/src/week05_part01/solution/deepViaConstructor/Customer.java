package week05_part01.solution.deepViaConstructor;

public class Customer
{
	private static int count = 1000;
	private String name;
	private int id;
	private double fee;
	
	/*
	 * Gives the new customer an id
	 * Updates the customer count.
	 * Note: We only want updated count for new customers
	 *       and *not* cloned ones.
	 */
	public Customer(String customerName, double fee)
	{
		id = count++;
		this.name = customerName;
		this.fee = fee;
	}

	/**
	 * Initializes this object by using another object of the same class.
	 * @param original   the customer we want to make a deep copy of
	 */
	public Customer(Customer original)
	{
		// Using the new constructor to avoid the problem of updating customer count
		this(original.name, original.fee, original.id);
	}

	/*
	 * A second constructor used for cloning;
	 */
	public Customer(String customerName, double fee, int number)
	{
		this.id = number;
		this.name = customerName;
		this.fee = fee;
	}
	
	
	public void setID(int number)
	{
		this.id = number;
	}
	
	public void setFee(double updatedFee)
	{	fee = updatedFee;  }
	
	
	public String toString()
	{	
		String info = "";
		info += String.format("#%-4d", id); 
		info += String.format(" %6s", name);
		info += String.format(" %.2f", fee);
		return info;
	}
}
