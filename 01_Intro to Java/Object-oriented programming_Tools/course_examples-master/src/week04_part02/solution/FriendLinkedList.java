package week04_part02.solution;

public class FriendLinkedList
{
	// keeps track of the front of the list
	private FriendNode head;

	// keeps track of the number of nodes in the list
	private int size;

	/**
	 *  Creates an new list that is empty.
	 */
	public FriendLinkedList()
	{
		this.head = null;
		this.size = 0;
	}

	/**
	 * Checks if head is pointing to any node.
	 */
	public boolean isEmpty()
	{
		// If head is not pointing to any nodes, then our list is empty.
		if (this.head == null)	// alternatively, check this.length == 0;
			return true;

		// Otherwise, there are one or more nodes in the list.
		return false;
	}

	/**
	 * Add a node to any empty list.
	 * @param name		A new data item to be added to our list.
	 */
	public void addFirstNode(String name)
	{
		// Check if the list is empty. 
		// If so, then this will be the first node in the list.
		// So, we will go ahead and add this node.
		if (this.isEmpty())
		{
			FriendNode current = new FriendNode(name);
			head = current;
			this.size++;
		}

		// Otherwise do nothing, 
		// because this is NOT the first node in the list.
		// in the list.
	}

	/**
	 * Add a node to the front of the list.
	 * @param name
	 */
	void addInFront(String name) 
	{	
		// Create a node to hold our data.
		FriendNode current = new FriendNode(name);

		// Check if the list is empty.
		// If so, add the new friend as the first node.
		// Note: Alternatively we could have called the method addFirstNode()
		if ( this.isEmpty() ) 
		{
			head = current;
			this.size++;

			// we're done, so we need to return;
			return;
		} 	

		// If we reach here, it means that the list is NOT empty.
		// So, we adjust the current's next reference such that
		// the next node following us is where head is pointing to
		current.setNext(head);

		// move head to point to our new node
		head = current;
	}

	/**
     * The number of nodes in the list. 
	 * @return size
	 */
	public int getSize() 
	{	return size;	}
	
	// PRACTICE
	public void printFirstNode()
	{
		System.out.println(head);
	}

	// PRACTICE
	public void printList()
	{
		// start at the beginning of the list
		FriendNode walker = head;

		while(walker != null)
		{
			// prints the current node
			System.out.println(walker);

			// move to the next node
			walker = walker.getNext();
		}
	}
	
	
	// PRACTICE
	public String removeFirstNode()
	{
		// Check if the list is empty.
		// If so, there is nothing to return
		if (head == null)
		{
			System.err.println("Warning: The list is empty!");
			return null;
		}
		
		// save the data for the first node
		String saved = head.getName();
		
		// move head to the next node.
		// this will disconnect the node from the list.
		// eventually the node we just disconnect is garbage collected.
		head = head.getNext();
		
		// return the data of the node we just removed
		return saved;
	}
	
	// PRACTICE
	public String removeLastNode()
	{
		// Check if the list is empty.
		// If so, there is nothing to return.
		if (head == null)
		{
			System.err.println("Warning: The list is empty!");
			return null;
		}
		
		FriendNode secondToLast = head;
		
		// Check if there is only one node in the list.
		// If so, remove it and return.
		if (secondToLast.getNext() == null)
		{
			String saved = head.getName();
			head = null;
			return saved;
		}
		
		// store a reference to the next node, 
		// which may potentially be the last node in our list
		FriendNode potentialLast;
		potentialLast = secondToLast.getNext();
		
		// traverse the list until potientialLast is the last node in the list 
		while (potentialLast.getNext() != null)
		{
			secondToLast = potentialLast;
			potentialLast = secondToLast.getNext();
		}

		// save the data for the first node
		String saved = potentialLast.getName();
		
		// disconnect second to last node from the last node.
		// after this method call, no references should be pointing to the last node.
		// eventually the node we just disconnect is garbage collected.
		secondToLast.setNext(null);
		
		// return the data of the node we just removed
		return saved;
	}
}
