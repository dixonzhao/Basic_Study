package week06_part01;

/**
 * Holds data for one node in a data structure.
 * 
 * @author Foothill College, Bita M
 */
public class GeneralNode 
{
	private Object data;	
	private GeneralNode next;

	/**
	 * Constructs an object to hold the data
	 * and point to null as the next node.
	 * @param theData		the data of this element
	 */
	public GeneralNode (Object theData) 
	{
		this.data = theData;
		this.next = null;
	}

	/**
	 * Constructs an object to hold the data
	 * and point to another as the next node.
	 * @param theData			The data portion of this node.
	 * @param another		The node following this node.
	 */
	public GeneralNode (Object theData, GeneralNode another) 
	{
		this.data = theData;
		this.next = another;
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
	public Object getData()
	{ 	return this.data; }

	/** 
	 * Mutator method sets the next node.
	 * @param anotherFriend		The node following this node.
	 */
	public void setNext(GeneralNode anotherFriend)
	{	this.next = anotherFriend; }

	/**
	 * Mutator method get the next node.
	 * @return the next node
	 */
	public GeneralNode getNext()
	{	return this.next; }
	
	/**
	 * String representation of the node as follows:
	 * nameOfFriend
	 */
	public String toString()
	{
		String result = "";
		result += this.data;
		return result;
	}
}
