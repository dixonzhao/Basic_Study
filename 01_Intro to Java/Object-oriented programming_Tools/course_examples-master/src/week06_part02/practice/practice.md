Practice Problems
========================

Learning Objectives
-------------------
- Creating a generic `Node` to hold the elements of a generic `LinkedList`.

<br><br>


Problem 1
---------
**Given the generic class `LinkedList<T>` which is composed of `Node<T>` objects, define the class `Node<T>` to hold data of type `T`.**

```java
public class LinkedList<T> 
{
    private Node<T> head;
	private int length;

    public LinkedList() 
    {
        this.head = null;
        this.elementCount = 0;
    }

    public void add (Node<T> newNode) 
    {
         // ...
    }

    // other methods...
}
```

<br><br>
