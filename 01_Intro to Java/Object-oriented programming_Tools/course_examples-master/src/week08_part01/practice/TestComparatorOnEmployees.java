package week08_part01.practice;

public class TestComparatorOnEmployees 
{
	public static void main(String [] args)
	{	
	    Employee alice = new Employee("alice", 1000, 5);
	    Employee peter = new Employee("peter", 1400, 3);
	    
	    EmployeeNameComparator ceName = new EmployeeNameComparator();
	    int result = ceName.compare(alice, peter);
	    System.out.println("Comparing names: " + result);
	}
}
