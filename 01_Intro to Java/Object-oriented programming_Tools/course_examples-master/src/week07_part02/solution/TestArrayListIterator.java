package week07_part02.solution;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayListIterator 
{
	public static void main(String[] args) 
	{
		// create a list of employees
		ArrayList<Employee> employees = new ArrayList<>();	
		employees.add(new Employee("alice", 1000));
		employees.add(new Employee("peter", 1000));
		employees.add(new Employee("rumple", 1000));
		employees.add(new Employee("hook", 1000));
		employees.add(new Employee("bell", 1000));
		// adds some more employees...

		// search for Employee with name "rumple"
		Iterator<Employee> itr;

	    // TODO: Instantiate an iterator called "itr"
		itr = employees.iterator();

		// an object to hold the employee if found
		Employee foundEmployee = null;

		// traverse the list until the employee with
		// the name "rumple" is found
		while(itr.hasNext())
		{
			Employee element = itr.next();
	        // TODO: Check if the current element is equal to "rumple"
	        //       If so, stop traversing the list.
			if (element.equals("rumple"))
			{
				foundEmployee = element;
				break;
			}
		}

		System.out.println("BEFORE modifying element = " + foundEmployee);

		// TODO: Give "rumple" a raise
		foundEmployee.giveRaise(500);

		System.out.println("AFTER modifying element = " + foundEmployee);
	}
}
