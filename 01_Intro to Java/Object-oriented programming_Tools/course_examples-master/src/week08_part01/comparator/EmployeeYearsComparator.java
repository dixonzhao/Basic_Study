package week08_part01.comparator;

import java.util.Comparator;

public class EmployeeYearsComparator implements Comparator<Employee>
{
	public int compare(Employee alice, Employee bob) 
	{
		if (alice.getYearsEmployed() < bob.getYearsEmployed())
			return -1;
		if (alice.getYearsEmployed() > bob.getYearsEmployed())
			return 1;
		return 0;
	}
}
