package reference_debugging;

public class TestHands 
{
	public static void main(String [] args)
	{
		Hand myhand = new Hand(4);
		Hand aliceHand = new Hand(4);
		Hand bobHand = new Hand(7);
		myhand.hand = aliceHand.hand;
		
		System.out.println("my hand has " + myhand);
		System.out.println("alice's hand has " + aliceHand);
		System.out.println("bob's hand has " + bobHand);

		if (!myhand.equals(aliceHand))
			System.out.println("my hand does not match hand of alice ");
		
		if (!myhand.equals(bobHand))
			System.out.println("my hand does not match hand of bob ");
		
		System.out.println("Done.");
	}
}
