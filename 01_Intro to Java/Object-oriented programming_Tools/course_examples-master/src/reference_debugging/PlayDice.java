package reference_debugging;

import java.util.Random;

public class PlayDice 
{
	final int MINROLL = 1;
	final int MAXROLL = 6;
	
	
	public void fillRolls(int [] rolls)
	{
		Random rand = new Random();
		int newRoll;
		
		for (int i = 0; i < rolls.length; i++)
		{
			newRoll = rand.nextInt(MAXROLL) + 1;
			rolls[newRoll] = newRoll;
		}
	}
	
	public void printRolls(int [] rolls)
	{
		for (int i = 0; i < rolls.length; i++)
			System.out.print(rolls[i] + ", ");
		System.out.println("");
	}

	public static void main(String [] args)
	{
		int [] aliceRolls = new int[5];
		int [] bobsRolls = new int[5];
		
		System.out.println("Welcome to roll dice game!");
		PlayDice game = new PlayDice();
		
		game.fillRolls(aliceRolls);
		
		game.fillRolls(bobsRolls);
		
		System.out.println("Goodbye.");
	}
}
