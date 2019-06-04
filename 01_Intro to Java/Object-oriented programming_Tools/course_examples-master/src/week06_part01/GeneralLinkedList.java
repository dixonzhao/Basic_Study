package week06_part01;

public class GeneralLinkedList
{
	// keeps track of the front of the list
	private GeneralNode head;
	
	// keeps track of the number of nodes in the list
	private int length;

	/**
	 *  Creates an new list that is empty.
	 */
	public GeneralLinkedList()
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
	public void addFirstNode(Object newData)
	{
		// Check if the list is empty. 
		// If so, then this will be the first node in the list.
		// So, we will go ahead and add this node.
		if (this.isEmpty())
		{
			GeneralNode current = new GeneralNode(newData);
			head = current;
			this.length++;
		}

		// Otherwise do nothing, 
		// because this is NOT the first node in the list.
		// in the list.
	}

	/**
	 * Add a node to the front of the list.
	 * @param name		A new data item to be added to our list.
	 */
	public void addInFront(Object newData) 
	{	
		// create a node to hold our data
		GeneralNode current = new GeneralNode(newData);

		// Check if the list is empty.
		// If so, add the new folder as the first node.
		// Note: Alternatively we could have called the method addFirstNode()
		if ( this.isEmpty() ) 
		{
			head = current;
			this.length++;
			
			// we're done, so we need to return to the caller
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
	public GeneralNode getNodeAtIndex(int index)
	{
	    GeneralNode walker = head;
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

	/**
	 * String representation of the list as follows:
	 * [alice, peter, rumple]
	 */
	public String toString()
	{
		// Uses a StringBuffer to concatenate strings
		StringBuilder rep = new StringBuilder();
		
		// The line below is the same as:
		// String rep;
		// rep += "[";
		rep.append("[");
		
		// start at the beginning of the list
		GeneralNode walker = head;
		
		while(walker != null)
		{
			// When concatenating a String object with a GeneralNode object,
			// the toString() method of walker is automatically called.
			rep.append(walker);
			
			// optional: to prettify the output
			if (walker.getNext() != null)
				rep.append(", ");
			
			// move to the next node
			walker = walker.getNext();
		}
		
		rep.append("]");
		
		// return the string representation of the list
		return rep.toString();
	}
}
