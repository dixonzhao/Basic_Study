package week03_part01;

public class TestMammals02 
{
	public static void main(String[] args) 
	{
		Mammal m; 

		m = new Dog(); 
		
		m.printMammal(); 
		
		//m.printDog(); 
		
		((Dog)m).printDog(); 
		
		Dog d;
		
		//d = new Mammal(); 
	}
}
