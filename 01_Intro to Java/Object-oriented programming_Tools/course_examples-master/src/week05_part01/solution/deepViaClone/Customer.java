package week05_part01.solution.deepViaClone;

public class Customer implements Cloneable 
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
	
	
	/*
	 * A second constructor used for cloning;
	 */
	public Customer(String customerName, double fee, int number)
	{
		this.id = number;
		this.name = customerName;
		this.fee = fee;
	}
	
	/*
	 * Clones a customer by allocating a new object of type customer.
	 */
	protected Object clone()
	{
		// Using the new constructor to avoid the problem of updating customer count
		Customer newGuy = new Customer(this.name, this.fee, this.id);
		
		return newGuy;
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
