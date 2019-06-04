package week02_part01;

import java.util.Random;
import java.util.Scanner;

public class Safari 
{
	private final int TYPES_OF_ANIMALS = 4;
	
	private Animal createAnimal() 
	{
		Animal creature = null;
		
		Random randomGenerator = new Random();
		int num = randomGenerator.nextInt(TYPES_OF_ANIMALS);
		switch(num)
		{
		case 0: 
			boolean isPolar = false;
			creature = new Bear(isPolar);
			break;
		case 1: 
			int soaringHeight = 3000; // meters!
			creature = new Eagle(soaringHeight);
			break;
		case 2: 
			creature = new Ostrich();
			break;
		case 3: 
			int mobysAge = 165; // the famous Moby-Dick was written in 1851
			int speed = 12; // miles per hour
			creature = new Whale(mobysAge, speed);
			break;
		default:
			throw new IllegalArgumentException("ERROR: Number " + num + " is not valid case for animal.");
		}

		return creature;
	}
	
	public static void main(String [] args)
	{
		Animal [] theAnimals;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many animals are in your safari?");
		int count = Integer.parseInt(keyboard.nextLine());
		
		Safari safari = new Safari();
		
		theAnimals = new Animal[count];
		for(int i = 0; i < count; i++)
		{
			theAnimals[i] = safari.createAnimal();
		}
		
		System.out.println("\nThe animals in the safari are:");
		for (int i = 0; i < theAnimals.length; i++)
		{
			Animal current = theAnimals[i];
			
			// skip positions in the array which are not valid animals
			if (current == null)
				continue;
			
			System.out.printf("\n #%d ", i);
			
			//option 1: implicitly call the first available toString() method 
			System.out.println(current);
			
			//option 2: explicitly call the first available toString() method 
			// System.out.println(current.toString());
			
			//option 3: store the return value of toString() in a variable 
			//String description = current.toString();
			//System.out.println(description);
		}
	}
}


// sample run and output:
/*
How many animals are in your safari?
5

The animals in the safari are:

 #0 Eagle's average soaring height is 3000

 #1 Whale age is 165, and speed is 12.0

 #2 Ostrich has feathers and can not fly. 

 #3 Eagle's average soaring height is 3000

 #4 Bear age is 162 java.awt.Color[r=0,g=0,b=0]
*/
