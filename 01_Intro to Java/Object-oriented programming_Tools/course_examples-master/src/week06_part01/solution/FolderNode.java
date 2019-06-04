package week06_part01.solution;

/**
 * Holds data for one node in a data structure.
 * 
 * @author Foothill College, Bita M
 */
public class FolderNode 
{
	private Folder data;	
	private FolderNode next;

	/**
	 * Constructs an object to hold the name of a folder
	 * and point to null as the next node.
	 * @param newDirectory			The data portion of this node.
	 */
	public FolderNode (Folder newDirectory) 
	{
		this.data = newDirectory;
		this.next = null;
	}

	/**
	 * Constructs an object to hold the directory information
	 * and point to another folder as the next node.
	 * @param theDirectory			The data portion of this node.
	 * @param another				The node following this node.
	 */
	public FolderNode (Folder theDirectory, FolderNode another) 
	{
		this.data = theDirectory;
		this.next = another;
	}
	
	/**
	 * Checks if the other node has the same name as this one.
	 * @param other
	 */
	public boolean equals(Object other) 
	{
	    if (other instanceof FolderNode) 
	    {                           
	        FolderNode current = (FolderNode)other;
	        if (current.data.equals(this.data))
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
	public Folder getData()
	{ 	return this.data; }

	/** 
	 * Mutator method sets the next node.
	 * @param anotherFriend		The node following this node.
	 */
	public void setNext(FolderNode anotherFriend)
	{	this.next = anotherFriend; }

	/**
	 * Mutator method get the next node.
	 * @return the next node
	 */
	public FolderNode getNext()
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
