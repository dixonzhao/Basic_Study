package week05_part02.practice;

/**
 * Tests deep copy of MagazineSubscriptions and Customer class.
 * @author Foothill College, Bita M
 */
public class TestMagazineSubscriptions 
{
	public static void main(String[] args) 
	{
		MagazineSubscriptions computing;
		
	 	computing = new MagazineSubscriptions("computing");
	 	
		double fee = 14.95;
	 	computing.addCustomer( new Customer("alice", fee));
	 	computing.addCustomer( new Customer("peter", fee));
	 	computing.addCustomer( new Customer("hook", fee));
	 	
	 	
		MagazineSubscriptions acm;
		
		acm = new MagazineSubscriptions("computing");
		
		System.out.println("BEFORE computing = " + computing);
		System.out.println("BEFORE acm = " + acm);


		// QUESTION: Can you identify which customer information is changed?
		int randomCustomerNum = 2;
		double priceHike = fee * 1.20;
		computing.setCustomerFee(randomCustomerNum, priceHike);

		System.out.println("\nAFTER  computing = " + computing);
		System.out.println("AFTER  acm = " + acm);
		
		// QUESTION: How about now?
		randomCustomerNum = 0;
		priceHike = 9999;
		computing.setCustomerFee(randomCustomerNum, priceHike);
		
		System.out.println("\nCHANGE  computing = " + computing);
		System.out.println("CHANGE  acm = " + acm);
	}
}
