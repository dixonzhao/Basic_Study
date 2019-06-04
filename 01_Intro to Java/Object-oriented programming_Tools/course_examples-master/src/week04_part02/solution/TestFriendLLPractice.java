package week04_part02.solution;

public class TestFriendLLPractice 
{

	public static void main(String[] args) 
	{	
		FriendLinkedList myfriends = new FriendLinkedList();
		
		myfriends.addInFront("alice");
		myfriends.addInFront("peter");
		myfriends.addInFront("rumple");		

		// PRACTICE: complete implementation of printFirstNode()
		myfriends.printFirstNode();
	
		// PRACTICE: complete implementation of printList()		
		System.out.println("\nList after adding " + myfriends.getSize());
		myfriends.printList();
		
		// PRACTICE: complete implementation of removeFirstNode()
		myfriends.removeFirstNode();		
		System.out.println("\nList after removing first node ");
		myfriends.printList();
	}

}
