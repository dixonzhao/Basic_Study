package week02_part02;

public class ATM 
{

	public static void main(String[] args) 
	{
		Account account1 = new Account("alice");
		account1.deposit(100);
		System.out.println(account1);

		try 
		{
			account1.withdraw(50);
			account1.withdraw(30);
			account1.withdraw(50);
		} 
		catch (InsufficientFundsException e) 
		{
			System.out.println("Insufficient funds! ");
			e.printStackTrace();
		}
		
		System.out.println("Done");
	}
}
