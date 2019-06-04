package week07_part02;

import java.util.Iterator;

/**
 * Parameterized class that we can traverse using an Iterator object.
 * 
 * @author Foothill College, [YOUR NAME HERE]
 *
 * @param <T>		The type of the elements.
 */
public class MyLinkedList<T> implements Iterable<T>
{
	private Node head;
	private int elementCount;
	
	/** Nested class, which holds the generic data.
	 * NOTE: for your project, create Node as *separate* class,
	 *       which means you will be submitting a Node.java file.
	 */
	public class Node
	{
		private T data;	
		private Node next;

		public Node(T newData) 
		{
			this.data = newData;
			this.next = null;
		}

		public Node(T newData, Node n) 
		{
			this.data = newData;
			this.next = n;
		}
		
		public String toString()
		{
			return this.data.toString();
		}
	}
	
	
	/**
	 * Nested class, which iterates over the elements of the outer class.
	 */
	private class MyListIterator implements Iterator<T> 
	{
		private Node current;
		
		public MyListIterator() 
		{	current = head; }
		
		public boolean hasNext() 
		{
			// check if the next node is valid
			// if node is invalid, return false
			if (current == null)
				return false;
			
			// otherwise we haven't reached the end of the list
			return true;
		}

		public T next() 
		{	
			if (current == null)
			{
				throw new java.util.NoSuchElementException();
			}
			
			// if we're here, then we're looking at a valid curre node
			// so grab the data portion, to give to the caller
			T data = current.data;
			
			// move in preparation for the next time.
			current = current.next;
			
			return data;  
		}

		public void remove() 
		{
			throw new UnsupportedOperationException();
		}
	}

	/**
	 *  creates an empty new list
	 */
	public MyLinkedList()
	{
		this.head = null;
		this.elementCount = 0;
	}

	/**
	 * Check's if head is pointing to any node
	 */
	public boolean isEmpty()
	{
		if (this.head == null)	// alternatively, check this.length == 0;
			return true;
		return false;
	}

	/**
	 * Adds a node to the beginning of a list
	 */
	public void addToFront(T newData)
	{
		Node newNode = new Node(newData);
		if (this.isEmpty() == false)
		{
			newNode.next = head;
		}

		head = newNode;
		this.elementCount++;
	}


	/**
	 * create an iterator object that starts at beginning of the list
	 */
	public Iterator<T> iterator() 
	{
		return new MyListIterator();
	}
}
