package week05_part01.practice.deepViaConstructor;

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


		MagazineSubscriptions acm = new MagazineSubscriptions(computing);
		
		System.out.println("BEFORE computing = " + computing);
		System.out.println("BEFORE acm = " + acm);


		int randomCustomerNum = 2;
		double priceHike = fee * 1.20;
		computing.setCustomerFee(randomCustomerNum, priceHike);
		
		System.out.println("\nAFTER  computing = " + computing);
		System.out.println("AFTER  acm = " + acm);
	}

}
