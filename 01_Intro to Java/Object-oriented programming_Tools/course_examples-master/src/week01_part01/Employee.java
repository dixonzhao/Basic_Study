package week01_part01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class Employee 
{
	public static int numAllotedVacationDays = 3;
	
	// ...
	
	private String name;
	private double salary;
	private double bonus;
	private Date [] vacationLeaves;
	private int lastLeaveIndex = 0;

	/**
	 *  Overrides the default constructor
	 */
	public Employee() 
	{
		this.name = "none";
		this.salary = 1000;
		this.bonus = 0;
		
		vacationLeaves = new Date[numAllotedVacationDays];
		for (int i = 0; i < numAllotedVacationDays; i++)
			vacationLeaves[i] = null;
		
		// …
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param name
	 * @param salary
	 */
	public Employee(String name, double salary) 
	{
		this.name = name;
		this.salary = salary;
		this.bonus = 0;
		
		vacationLeaves = new Date[numAllotedVacationDays];
		for (int i = 0; i < numAllotedVacationDays; i++)
			vacationLeaves[i] = null;
		
		// …
	}
	
	public void setName(String theName) 
	{
		this.name = theName;
	}

	public void setSalary(double salary) 
	{
		this.salary = salary;

		if( giveBonus() )		
			bonus = this.salary * 0.05;
		
		System.out.println("DEBUG: bonus = $" + bonus);
	}


	public boolean giveBonus()
	{
		for (int i = 0; i < vacationLeaves.length; i++)
		{
			if (vacationLeaves[i] != null)
				return false;
		}
		return true;
	}
	
	
	public void addVacationDateTaken(String day)
	{	
		if (day == null)
		{
			System.err.println("WARNING : Undefined vacation date.");
			return;
		}
		
		if (this.lastLeaveIndex >= vacationLeaves.length)
		{
			System.out.println("No vactaion days left :(");
			return;
		}
		
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date;
		try 
		{
			date = format.parse(day);
			vacationLeaves[lastLeaveIndex] = date;
			lastLeaveIndex++;
			System.out.println("Number of vacation days left for " + name +  " is " + (this.numAllotedVacationDays - lastLeaveIndex));
		} catch (ParseException e) 
		{
			System.err.println("ERROR: Invalid date. Format is January 1, 1999");
			e.printStackTrace();
		}
		
	}
	
	
	public static void setNumVacationDays(int numDays)
	{	numAllotedVacationDays = numDays;  } 
	
	
	public String getName()
	{	return this.name; }
	

	public double getSalary()
	{	return this.salary + this.bonus; }
	
	
	public static void main(String [] args)
	{
		Employee alice = new Employee("alice", 1000);
		
		alice.addVacationDateTaken("August 1, 2015");
		
		alice.addVacationDateTaken("September 1, 2015");
		
		alice.setSalary(1200);

		System.out.println(alice.getName() + " salary = $" + alice.getSalary());
		alice.addVacationDateTaken("October 1, 2015");
		
		alice.addVacationDateTaken("November 1, 2015");
	}
}