package week03_part01;

public class TestPerson 
{
	public static void main(String args[])
	{ 
		Person minnie = new Person("Minnie", 41);
		
		minnie.older();	  			// QUESTION 1: What happens here?
		minnie.print();
		(minnie.older()).print(); 	// QUESTION 2: How about here?
	}
}
