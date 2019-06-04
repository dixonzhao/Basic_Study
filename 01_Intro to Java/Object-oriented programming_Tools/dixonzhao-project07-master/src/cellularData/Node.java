package cellularData;
/**
 *  store the basic element of linkedlist
 * Create new Node and ready 2 constructors
 *
 * @author Foothill College, Zhili Zhao
 *  show basic element of linkedlist. 
 * <p>show  complete the function while using generic class, method, variable<br>
 * show Except the required function, all method and variables are been set to private
 * @param data true
    * store data
    * @param next true
    * store point at the next object
 */
public class Node<T> {
	private T data;
	private Node next=null;
	
	/**
     * show default constructor   
     * <p>show incase one input without param <br>
     * 
     */
	public Node(){
		System.out.println("Warning, no data input, return to upper level");
		return;
	}
	/**
     * show first constructor, for initialize  
     * <p>show initialzie with the generic variable <br>
     * 
     */
	public Node(T data){
		this.data=data;
	}
	
	/**
     * show second constructor.  
     * <p>initialzie with the generic variable and parametrized variable <br>
     * 
     */
	public Node(T data, Node next){
		this.data=data;
		setNext(next);
	}
	/**
     * show getter of Node  
     * <p> return next pointer
     * 
     */
	public Node getNext() {
		return next;
	}
	/**
     * show setter of Node  
     * <p> set next pointer
     * 
     */
	public void setNext(Node next) {
		this.next = next;
	}
	/**
     * show getter of data  
     * <p> return generic object data
     * 
     */
	public T getData() {
		return data;
	}
	
	/**
     * add use toString of the data
     * <p> return data.toString()
     * 
     */
	public String toString() {
		return data.toString();
	}
	
	/**
     * Override of data 
     * <p> redundance
     * 
     */
	public boolean equals(Object t) {
		t=(T)t;
		return t.equals(data);
	}

}
