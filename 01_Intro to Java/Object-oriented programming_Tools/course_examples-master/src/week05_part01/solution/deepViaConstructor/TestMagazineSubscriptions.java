package week05_part01.solution.deepViaConstructor;

public class TestMagazineSubscriptions
{
	public static void main(String[] args) 
	{
		// example test of Customer
		/*
		Customer wendy = new Customer("wendy", 18);
		Customer wcopy = (Customer)wendy.clone();
		System.out.println("Wendy = " + wendy);
		System.out.println("the copy = " + wcopy);
		
		wcopy.setID(999);
		
		System.out.println("after update");
		System.out.println("Wendy = " + wendy);
		System.out.println("the copy = " + wcopy);
		System.exit(0);
		*/
		
		MagazineSubscriptions computing;

	 	computing = new MagazineSubscriptions("computing");

		double fee = 14.95;
	 	computing.addCustomer( new Customer("alice", fee));
	 	computing.addCustomer( new Customer("peter", fee));
	 	computing.addCustomer( new Customer("hook", fee));


		MagazineSubscriptions acm = new MagazineSubscriptions(computing);
		
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
