package week04_part02.practice;

public class FriendLinkedListPractice
{
	// keeps track of the front of the list
	private FriendNode head;
	
	// keeps track of the number of nodes in the list
	private int length;

	/**
	 *  Creates an new list that is empty.
	 */
	public FriendLinkedListPractice()
	{
		this.head = null;
		this.length = 0;
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
			this.length++;
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
			this.length++;
			
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
	 * Gets a node at a specific index.
	 * @param index		The index after the start of the list.
	 */
	public FriendNode getNodeAtIndex(int index)
	{
	    FriendNode walker = head;
	    int i = 0;

	    // traverse the list until either:
	    // walker reaches the end of the list; or
	    // we've reached client's index of interest.
	    while(walker != null && i < index)
	    {
	        // reached requested interest  
	        // so return the node we're at 
	        if (i == index)
	            return walker;

	        // move to the next node
	        walker = walker.getNext();

	        // increment the position
	        i++;
	    }
	    
	    // we have NOT reached the client's index of interest
	    // so we have nothing to return
	    return null;
	}
	
    /**
     * The number of nodes in the list. 
     */
    public int getSize() 
    {
        return this.length;
    }


	// PRACTICE
	public void printFirstNode()
	{
		// TO COMPLETE: print only first node in list

	}

	// PRACTICE
	public void printList()
	{
		// TO COMPLETE: print all nodes in list, starting at head node
		// Note: Do NOT use the method getNodeAtIndex()
	}
	
	// PRACTICE
	public String removeFirstNode()
	{
		// TO COMPLETE: removes the first node in the list
		
		return null;
	}
	
	// PRACTICE
	public String removeLastNode()
	{
		// TO COMPLETE: removes the last node in the list
		
		return null;
	}
}
