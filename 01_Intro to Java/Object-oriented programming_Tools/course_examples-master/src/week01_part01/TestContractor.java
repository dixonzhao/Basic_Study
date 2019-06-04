package week01_part01;

public class TestContractor 
{
	public static void main(String[] args) 
	{
		Contractor contractor01 = new Contractor();
		
		contractor01.setName("bob");
		
		int [] hours = {7, 8, 8, 8, 6};
		
		contractor01.setHours(hours);
		
		System.out.println("contractor : " +  contractor01);
		
		
		Contractor [] allContractors = new Contractor[4];
		int [] initHours = {1, 1, 1};
		for (int i = 0; i < allContractors.length; i++)
		{
			allContractors[i].setHours(initHours);
		}
	}

}
