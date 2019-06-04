package week08_part01.solution;

public class EmployeeNameComparator 
{
	public int compare(Employee first, Employee second) 
	{
		// compare if the first name is lexographically:
		
		// less than the second
		if (first.getName().compareTo(second.getName()) < 1)
			return -1;
		
		// greater than the second
		if (first.getName().compareTo(second.getName()) > 1)
			return 1;
		
		// the same as the second
		// same as calling first.getName().equals(second.getName();
		return 0;
		
		// alternatively we could have replaced all the above lines with:
		// return first.getName().compareTo(second.getName());
	}
}
