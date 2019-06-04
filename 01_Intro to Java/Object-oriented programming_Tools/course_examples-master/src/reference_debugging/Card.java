package reference_debugging;

public class Card 
{
	String rank;
	String suit;
	
	public Card(String rank, String suit) 
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	public String toString()
	{	return this.rank + " of " + this.suit; }
}
