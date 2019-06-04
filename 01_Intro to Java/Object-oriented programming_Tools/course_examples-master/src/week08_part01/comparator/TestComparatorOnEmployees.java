package week08_part01.comparator;

public class TestComparatorOnEmployees 
{
	public static void main(String [] args)
	{	
	    Employee alice = new Employee("alice", 1000, 5);
	    Employee peter = new Employee("peter", 1400, 3);
	    
	    EmployeeYearsComparator ceYears = new EmployeeYearsComparator();
	    int result = ceYears.compare(alice, peter);
	    System.out.println("Comparing alice & peter's years served: " + result);
	}
}
