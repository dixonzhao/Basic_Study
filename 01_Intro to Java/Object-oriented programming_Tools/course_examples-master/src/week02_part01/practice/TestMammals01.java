package week02_part01.practice;

import week02_part01.*;

public class TestMammals01
{
	//given the definitions of Mammal class and Dog class
    public static void main(String[] args) 
    {
        Dog d;
        d = new Dog(5, "Buster");
    
        d.printDog();
        d.printMammal();       // QUESTION 1: What is the result? 

        week02_part01.Mammal m;
        m = new week02_part01.Mammal(8);
        m.printMammal();

        m.printDog();          // QUESTION 2: What is the result? 
        ((Dog)m).printDog();   // QUESTION 3: What is the result? 
    } 
}
