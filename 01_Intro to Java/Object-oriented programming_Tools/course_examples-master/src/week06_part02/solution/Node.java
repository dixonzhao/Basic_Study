package week06_part02.solution;

/**
 * Holds data for one node in a data structure.
 * 
 * @author Foothill College, Bita M
 */
public class Node<T>
{
	private T data;	
	private Node<T> next;

	/**
	 * Constructs an object to hold the data
	 * and point to null as the next node.
	 * @param theData
	 */
	public Node(T theData) 
	{
		this.data = theData;
		this.next = null;
	}

	/**
	 * Constructs an object to hold the data
	 * and point to another element as the next node.
	 * @param theData			The data portion of this node.
	 * @param another		The node following this node.
	 */
	public Node(T theData, Node<T> another) 
	{
		this.data = theData;
		this.next = another;
	}
	
	/**
	 * Checks if this node is pointing to another Node<T> object.
	 */
	public boolean isLastNode() 
	{
	    // Checks if I am pointing to null*.
		// If so, then I know I am the last node.
		// *Note: From the perspective of this instance of Node.
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
	public T getData()
	{ 	return this.data; }

	/** 
	 * Mutator method sets the next node.
	 * @param another		The node following this node.
	 */
	public void setNext(Node<T> another)
	{	this.next = another; }

	/**
	 * Mutator method get the next node.
	 * @return the next node
	 */
	public Node<T> getNext()
	{	return this.next; }
	
	/**
	 * String representation of the node as follows:
	 * data
	 */
	public String toString()
	{
		String result = "";
		result += this.data;
		return result;
	}
}
