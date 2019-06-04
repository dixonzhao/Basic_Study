package week02_part02;

public class Account 
{
	public static int nextAccountID = 1000;
	String name;
	double balance;
	int accountNumber;

	public Account(String name)
	{
		this.name = name;
		this.balance = 0;
		this.accountNumber = Account.nextAccountID;
		Account.nextAccountID++;
		
		System.out.println("Successfully created an account for " + name);
	}

	public void deposit(double amount)
	{	balance += amount; }

	public void withdraw(double amount) throws InsufficientFundsException
	{
		if (balance - amount < 0)
			throw new InsufficientFundsException(amount);
		balance = balance - amount;
		
		System.out.printf("Successfull withdraw of $%.2f and current balance is $%.2f %n", amount, balance);
	}

	public String toString()
	{
		return this.name + " $" + this.balance;
	}
}
