package week03_part01;

public class TestMammals03 
{
	public static void main(String[] args) 
	{
		Mammal m;
		
		m = new Mammal();
		m.print();
		
		Dog d = new Dog();
		((Mammal)d).print(); 	  // QUESTION 1: What is the result?
		
		m = new Dog();
		m.print(); 				  // QUESTION 2: What class type is "((Mammal)m)" referring to?
		
		((Mammal)m).print(); 	  // QUESTION 3: What is the result?
	}
}
