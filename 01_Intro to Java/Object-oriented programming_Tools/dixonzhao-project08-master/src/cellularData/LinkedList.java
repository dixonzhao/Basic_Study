package cellularData;
/**
 *  use for initialize the linkedlist  
 *  Creates one list with Node as the basic element used for control object with  generic.
 *
 * @author Foothill College, Zhili Zhao
 *  show Main class for linkedlist .
 * show Except the required function, all method and variables are been set to private
 */
import java.util.Iterator;
import java.lang.Iterable;

public class LinkedList<T> implements Iterable{
	 private Node<T> begin;
	 private Node<T> temp;

	private int count=0;
	private int size=0;

	/**
     * show add method 
     * <p>show add the Country object to the end of the list <br>
     * @param Country cou
     */
	public void add(T t) {
		temp=begin;
		if(count==0) {
			begin= new Node(t);
			count++;
			return;
		}
		while(begin.getNext()!=null) {
			begin=begin.getNext();
		}
		begin.setNext(new Node(t));
		count++;
		size=count;
		begin=temp;
	}
	

	
	/**
     * show search if contains object
     * <p>show return object if find  <br>
     * 
     */
	public T contains(T t) {
		temp=begin;
		while(temp.getNext()!=null) {
			boolean result=t.equals(temp.getData());
			if(result) {
				System.out.println("Yes, contains it");
				return (T)temp.getData();
			}
			temp=temp.getNext();
		}
		
		if(temp.equals(t)) {
			System.out.println("Yes, contains it");
			return (T) temp.getData();
		} 
		else 
		{
			System.out.println("Sorry, this list doesn't contain  it");
		}
		return null;
	}
	
	/**
     * show @override  the toString() method
     * <p>show print all object in the list  <br>
     * 
     */
	public String toString() {
		temp=begin;
		String reu="";
		int c=count;
		while(c-->0) {
			reu+=temp+"\n";
			temp=temp.getNext();
		}
		return reu;
	}
	
	/**
     * show return list size 
     * <p>show return size <br>
     * 
     */
	public int size() {
		return size;
	}
	
	/**
     * show get country of selected index
     * <p>show from the top to the end count for the number<br>
     * return the Country object if found<br>
     * throw  IndexOutOfBoundsException if index exceed limit 
     */
	public T getIndex(int ind) throws IndexOutOfBoundsException {
		temp=begin;
		if(temp==null) {
			return null;
		}
		if(ind>=0&&ind<count) {
			while(ind-->0) {
				temp=temp.getNext();
			}
			return (T) temp.getData();
		} else {
			throw new IndexOutOfBoundsException("index out of bound!");
		}

	}


	/**
     * show override the iterator for basic use 
     *
     * 
     */
	@Override
	public ListIterator iterator() {
		// TODO Auto-generated method stub
		ListIterator lis=new ListIterator();
		return lis;
	}
	/**
     * show Inner class of basic iterator functions
     * <p>show return size <br>
     * 
     */
	class ListIterator<T>  implements Iterator{
		boolean isFirst=true;
		Node current;
		ListIterator(){
			current=begin;
		}
		
		/**
	     * show return next data of node 
	     * 
	     * 
	     */
		public T next() {  
			if(isFirst) {
				isFirst=false;
				return(T)current.getData();
			}
			
			if(hasNext()&&!isFirst) {
				current=current.getNext();
				return (T) current.getData();
			}
			
			
				
			System.out.println("Warning, LinkedList`, ListIterator, Next()has no next"); 
			return null;
		}
		/**
	     * show test if there is next for iterator.
	     */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(current.getNext()!=null)
				return true;

			return false;
		}
	}
	
	
	
	
	
	
	
	
	
}

