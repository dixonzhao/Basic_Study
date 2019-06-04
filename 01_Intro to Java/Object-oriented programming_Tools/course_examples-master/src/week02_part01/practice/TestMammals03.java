package week02_part01.practice;

import week02_part01.*;

public class TestMammals03
{
	//given the definitions of Mammal class and Dog class
	public static void main(String[] args) 
	{
		week02_part01.Mammal m;

		m = new week02_part01.Mammal();
		m.toString();

		Dog d = new Dog(8, "Snoopy");
		((week02_part01.Mammal)d).toString();       // QUESTION 1: What is the result?

		m = new Dog(9, "Rocky");
		m.toString();                 // QUESTION 2: What class type is "((Mammal)m)" referring to?

		((week02_part01.Mammal)m).toString();       // QUESTION 3: What is the result?
	}
}
