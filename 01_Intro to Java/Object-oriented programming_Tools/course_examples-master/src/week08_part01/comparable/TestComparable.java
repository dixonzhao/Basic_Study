package week08_part01.comparable;

import java.util.ArrayList;

public class TestComparable 
{

	public static void main(String[] args) 
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();		
		Employee e1 = new Employee("alice", 1000, 5);
		employees.add(e1);
		employees.add(new Employee("peter", 1400, 3));
		employees.add(new Employee("rumple", 1000, 6));
		employees.add(new Employee("hook", 1200, 3));
		employees.add(new Employee("bell", 1200,4));


		// get a reference to the second (i.e. at index 1) employee
		Employee e2 = employees.get(1);
		
		// check whether employee 1 or 2 has served longer
		if (e1.compareTo(e2) == 1)
	    {
	        System.out.println("employee 1 has served more number of years than employee 2");
	    }
	    
	} // main
}
