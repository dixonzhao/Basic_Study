package week06_part01.practice;

public class TestFriendLinkedList 
{
	public static void main(String[] args) 
	{		
		FriendLinkedList myContacts = new FriendLinkedList();
		myContacts.addInFront("alice");
		myContacts.addInFront("peter");
		myContacts.addInFront("rumple");
		myContacts.addInFront("hook");

		FriendNode result = myContacts.getFirstNode();
		
		// TO COMPLETE
		// Add your own test cases
	}
}
