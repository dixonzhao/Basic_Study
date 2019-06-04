package week02_part01.practice;

import week02_part01.*;

public class TestMammals02
{
	//given the definitions of Mammal class and Dog class
	public static void main(String[] args) 
	{
		week02_part01.Mammal m;
		m = new Dog(8, "Snoopy"); // QUESTION 1: What is the result?

		m.printMammal();          // QUESTION 2: What is the result? 

		m.printDog();             // QUESTION 3: What is the result? 

		((Dog)m).printDog();      // QUESTION 4: What is the result? 

		Dog d;
		d = new week02_part01.Mammal(40);       // QUESTION 5: What is the result?
	}
}