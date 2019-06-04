package week02_part01;

public class TestPerson 
{
	public static void main(String args[])
	{ 
		Person minnie = new Person("Minnie", 41);

		Person new_minnie = minnie.older(); // QUESTION 1: What happens here?
		new_minnie.print();
		minnie.print();
		(minnie.older()).print();           // QUESTION 2: How about here?
	}
}
