package reference_debugging;

import java.util.Random;


public class Hand 
{
	Card [] hand = null;	/* QUESTION: What is the visibility of "hand" ? */

	public Hand(int num)
	{	
		hand = new Card[num];
		for(int i = 0; i < num; i++)
		{
			String rank = chooseRank();
			String suit = chooseSuit();
			hand[i] = new Card(rank, suit);
		}
	}

	public String toString()
	{
		String str = "{";
		for (int cardNum = 0; cardNum < hand.length; cardNum++)
			str += hand[cardNum] + ",";
		str += "}\n";
		return str;
	}

	public String chooseSuit()
	{
		String [] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

		Random rand = new Random();
		int randomIndex = rand.nextInt(suits.length);
		return suits[randomIndex];
	}

	public String chooseRank()
	{
		String [] ranks = {"", "2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

		Random rand = new Random();
		int randomIndex = rand.nextInt((ranks.length - 1) + 1);
		return ranks[randomIndex];
	}

	public boolean equals(Object other)
	{
		boolean matches = true;
		if (other instanceof Hand)
		{
			Card[] otherCards = ((Hand) other).getCards();
			for (int i = 0; i < otherCards.length; i++)
			{
				if (!hand[i].equals(otherCards[i]))
					matches = false;
			}
		}
		return matches;
	}
	
	public Card[] getCards()
	{
		return this.hand;
	}
	
	public Card[] getMatchingSetOfCards()
	{
		Card [] newSet = new Card[hand.length];
		for (int i = 0; i < newSet.length; i++)
			newSet[i] = hand[i];
		return newSet;
	}
}
