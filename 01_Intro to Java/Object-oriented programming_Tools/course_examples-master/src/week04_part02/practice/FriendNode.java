package week04_part02.practice;

/**
 * Holds data for one node in a data structure.
 * 
 * @author Foothill College, Bita M
 */
public class FriendNode 
{
	private String name;	
	private FriendNode next;

	/**
	 * Constructs an object to hold the name of a friend
	 * and point to null as the next node.
	 * @param friend
	 */
	public FriendNode(String friend) 
	{
		this.name = friend;
		this.next = null;
	}

	/**
	 * Constructs an object to hold the name of a friend
	 * and point to another friend as the next node.
	 * @param friend			The data portion of this node.
	 * @param anotherFriend		The node following this node.
	 */
	public FriendNode(String friend, FriendNode anotherFriend) 
	{
		this.name = friend;
		this.next = anotherFriend;
	}
	
	/**
	 * Checks if the other node has the same name as this one.
	 * @param other
	 */
	public boolean equals(Object other) 
	{
	    if (other instanceof FriendNode) 
	    {                           
	        FriendNode current = (FriendNode)other;
	        if (current.name.equals(this.name))
	                return true;        
	    }
	    return false;
	}
	
	/**
	 * Checks if this node is pointing to another FriendNode object.
	 */
	public boolean isLastNode() 
	{
	    // Checks if I am pointing to null*.
		// If so, then I know I am the last node.
		// *Note: From the perspective of this instance of FriendNode.
	    if (this.next == null)
	    {
	        return true;
	    }
	    
	    // Otherwise, I know I am not last,
	    // because there is a next node after me.
	    return false;
	}
	
	/**
	 * Mutator method returns the data portion of the node.
	 * @return
	 */
	public String getName()
	{ 	return this.name; }

	/** 
	 * Mutator method sets the next node.
	 * @param anotherFriend		The node following this node.
	 */
	public void setNext(FriendNode anotherFriend)
	{	this.next = anotherFriend; }

	/**
	 * Mutator method get the next node.
	 * @return the next node
	 */
	public FriendNode getNext()
	{	return this.next; }
	
	/**
	 * String representation of the node as follows:
	 * nameOfFriend
	 */
	public String toString()
	{
		String result = "";
		result += this.name;
		return result;
	}
}
