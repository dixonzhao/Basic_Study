package week08_part01;

import java.util.ArrayList;

public class TestLongestServed 
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


		// check for the employee who has served the longest
		Employee longest = (Employee)employees.get(0);
	    for (int i = 1; i < employees.size(); i++)
	    {
	        Employee current = (Employee)employees.get(i);
	        if (current.getYearsEmployed() > longest.getYearsEmployed())
	            longest = current;
	    }
	    System.out.println(longest);
	    
	} // main
}
