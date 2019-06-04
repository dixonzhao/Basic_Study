package week02_part02;

public class InsufficientFundsException extends Exception 
{	
	private String message = null;

	public InsufficientFundsException(double amount)
	{
		super("Insufficient funds for $" + amount);
		this.message = "Insufficient funds for $" + amount;
	}
	
	public String toString()
	{
		return message;
	}
}
