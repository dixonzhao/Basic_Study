package week07_part02.practice;

import java.util.Iterator;


public class Payroll 
{
	public static void main(String [] args)
	{
		// create a list of employees
		MyLinkedList<Employee> employees;
		employees = new MyLinkedList<Employee>();
		
		employees.addToFront(new Employee("alice", 1000, 7));
		employees.addToFront(new Employee("peter", 1000, 4));
		employees.addToFront(new Employee("rumple", 1000, 4));
		employees.addToFront(new Employee("hook", 1000, 9));
		employees.addToFront(new Employee("bell", 1000, 2));
		
		// search for Employee with name "rumple"
		Iterator<Employee> itr = employees.iterator();
		Employee foundEmployee = null;
		while(itr.hasNext()) 
		{
			Employee element = itr.next();
			// TODO: CHECK IF ELEMENT IS EQUAL TO "rumple"
			// NOTE: You must override the "equals" method
		}
		
		// NOTE: for now we’ll just print the found element
		System.out.println("found employee = " + foundEmployee);
		
		// print the updated to match sample output below.
		// sample output:
		// alice, $1000.0, years served  7 -> 
		// etc
		// hook, $1150.0, years served  9 -> 
		// bell, $1000.0, years served  2 -> null
		// 
		// TODO: Use an iterator to traverse and print
		// the elements in your employees list.
	}
}
