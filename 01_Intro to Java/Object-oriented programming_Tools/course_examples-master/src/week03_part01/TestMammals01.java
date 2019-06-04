package week03_part01;

public class TestMammals01 
{
	public static void main(String[] args) 
	{
		Dog d;
		d = new Dog(5, "Buster");
		
		d.printDog();
		d.printMammal(); 	  // QUESTION 1: What is the result? 
		
		Mammal m;
		m = new Mammal(8);
		m.printMammal();
		
		//m.printDog(); 		 // QUESTION 2: What is the result? 
		((Dog)m).printDog(); 	// QUESTION 3: What is the result? 
	} 
}
