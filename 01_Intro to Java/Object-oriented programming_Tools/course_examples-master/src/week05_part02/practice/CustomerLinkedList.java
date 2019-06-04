package week05_part02.practice;

public class CustomerLinkedList
{
	/**
	 * inner class CNode used by the outer class CustomerLinkedList
	 */
	class CNode
	{
		private Customer data;
		private CNode next;

		public CNode(Customer c) 
		{
			this.data = c;
			this.next = null;
		}

		public String toString()
		{	return data.toString();	}
		
		// PRACTICE	
		// TODO: Crate a deep copy an instance of CNode
		// we must implement which interface and define which method?
		// Hint: Take a look at class Customer examples.
	}


	private CNode head;
	private int length;

	/*
	 *  creates an empty new list
	 */
	public CustomerLinkedList()
	{
		this.head = null;
		this.length = 0;
	}

	/*
	 * Check's if head is pointing to any node
	 */
	public boolean isEmpty()
	{
		if (this.head == null)	// alternatively, check this.length == 0;
			return true;
		return false;
	}

	/**
	 * Add a node to the front of the list.
	 * @param name		A new data item to be added to our list.
	 */
	public void addInFront(Customer newGuy) 
	{	
		// creates a node to hold our data
		// Note: CNode is an inner class
		CNode current = new CNode(newGuy);

		if ( this.isEmpty() ) 
		{
			head = current;
			this.length++;
			
			// we're done, so we need to return to the caller
			return;
		} 	

		// QUESTION: Why do we have access to the next attribute? Isn't it private?
		current.next = head;
		
		// move head to point to our new node
		head = current;
	}	
	
	public Customer getCustomerAtIndex(int index)
	{
		if (index > length)
		{
			System.err.println("Requested customer # " + index + " does not exist");
			return null;
		}
		
		CNode current = head;
		for (int pos = 0; pos < index; pos++)
		{
			current = current.next;
		}
		
		// QUESTION: Why do we have access to the data attribute? Isn't it private?
		return current.data;
	}
	
	public int getSize()
	{	return this.length; }

	/**
	 * String representation of all nodes in the list
	 */
	public String toString()
	{		
		if (head == null)
		{
			return "empty list";
		}
	
		String info = "";

		CNode walker = head;
		while (walker != null)
		{
			info += walker;
			
			if (walker.next != null)
				info += ", ";			
		
			walker = walker.next;
		}
		return info;
	}

	// PRACTICE	
	// TODO: Create a copy constructor such that it performs a deep copy
	//       of the CustomerLinkedList.
	// Question: Which methods should we define?
	// Hint: Take a look at class MagazineSubscriptions examples.
}
