package week05_part02.solution;

public class Customer
{
	private static int count = 1000;
	private String name;
	private int id;
	private double fee;
	
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
        // TODO: Complete the definition of the copy constructor and
        //       all non-primitive and immutable object such that
        //       this new object is a deep copy of the original.
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
