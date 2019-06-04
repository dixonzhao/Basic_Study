package stacks;
import java.util.*;

/**

 Use to create/control StackList by generic linked list to simulate Stack
 * @author Foothill College, Zhili Zhao
 */
public class StackList<T> implements Iterable{
    private String name;
    private Node top;

    private Node temp;
    private Node prev;
    private int count=0;
    private int size=0;


    /**
     * default constructor
     * <p>show initialize the class <br>
     *
     */
    public StackList(){
    }

    /**
     * push method
     * <p>takes a generic item as the argument and adds the item to the top of the stack <br>
     */
    public void push(T t) {
        temp=top;
        if(count==0) {
            top= new Node(t);
            count++;
            return;
        }
        while(top.getNext()!=null) {
            top=top.getNext();
        }
        top.setNext(new Node(t));
        count++;
        size=count;
        top=temp;
    }

    /**
     * return top object while delect it
     * <p>
     *     receives no arguments and removes the item from the top of the stack.<br>
     *         This method should return the generic item popped.
     * </p>
     * @return
     */
    public T pop(){
        temp=top;

        while(temp.getNext()!=null) {
            prev=temp;
            temp=temp.getNext();
        }
        prev.setNext(null);
        size--;
        count--;
        return (T)temp.getData();
    }

    /**
     * check top item while not delete
     * <p>
     *     looks at the top of the stack and returns a generic type for the data seen at the top of the stack.<br>
     *         The item should not be removed
     * </p>
     * @return
     */
    public T peek(){
        temp=top;
    if (temp==null)
        return null;

        while(temp.getNext()!=null) {
            prev=temp;
            temp=temp.getNext();
        }

        return (T)temp.getData();
    }

    /**
     * Clear reference by drop top reference
     */
    public void clear(){
        top=null;
        System.out.println("All reference has been cleared. Good luck");
    }

    /**
     * output the link numbers and the specific content
     * @return
     */
    public String toString() {
        temp=top;
        String reu="the link number is " + size +"\n";
        int c=count;
        if(top==null){
            return null;
        }
        while(c-->0) {
            reu+=temp+"\n";
            temp=temp.getNext();
        }
        return reu;
    }

    /**
     * check for if the top is empty
     * @return boolean
     */
    public boolean isEmpty(){
        if(top==null){
            return true;
        }
        return false;
    }

    /**
     * return list size
     * <p>show return size <br>
     *
     */
    public int size() {
        return size;
    }



//Node ------------------------------------------------------------------------------------------

    private class Node<T> {
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

//Iterator----------------------------------------------------------------------------------------------------

    /**
     * Internal Iterator class
     */
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
            current=top;
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

        public T getCurrentD(){
            if(current!=null)
                return (T) current.getData();
            return null;
        }
        /**
         * show test if there is next for iterator.
         */
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            if(current==null){
                return false;
            }
            if(current.getNext()!=null)
                return true;

            return false;
        }
    }









    }





