package week02_part02;

public class TestContractor 
{

	public static void main(String[] args) 
	{
		Contractor contractor01 = new Contractor();

		contractor01.setName("bob");
		
		double [] week1 = {8, 8, 7.5, 8, 6.5};
		contractor01.setHours(week1);

		System.out.println("contractor : " +  contractor01);


		double hours;
		hours = contractor01.getHourOnDay(2);		// QUESTION 1: What happens here?
		System.out.println("number of hours on " + hours);
		
		hours = contractor01.getHourOnDay(7);		// QUESTION 1: What happens here?
		System.out.println("number of hours on " + hours);
	}

}
