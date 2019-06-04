package week08_part01.comparator;


public class Employee
{
	private String name;
	private double salary;
	private int yearsOfService;

	public Employee() 
	{
		name = "null";
		salary = 0;
		yearsOfService = 0;
	}

	public Employee(String name, double newSalary) 
	{
		this.name = name;
		this.salary = newSalary;
		yearsOfService = 0;
	}

	public Employee(String name, double newSalary, int numYearsEmployed) 
	{
		this.name = name;
		this.salary = newSalary;
		this.yearsOfService = numYearsEmployed;
	}

	public String getName()
	{
		return this.name;
	}

	public double getSalary() 
	{
		return this.salary;
	}

	public int getYearsEmployed() 
	{
		return this.yearsOfService;
	}

	public void giveRaise(double raise)
	{ 
		this.salary = this.salary + this.salary * raise; 
	}

	public boolean equals(Object o) 
	{
		if (o instanceof Employee) 
		{
			Employee other = (Employee)o;
			if (other.name.equals(this.name))
				return true;
		}
		return false;
	}

	public String toString() 
	{
		String result = this.name + ", $";
		result += String.format("%.2f", this.salary); 
		result += ", years served  " + this.yearsOfService;
		return result + "\n";
	}
}
