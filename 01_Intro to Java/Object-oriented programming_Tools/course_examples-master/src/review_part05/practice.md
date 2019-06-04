Review Part 5
========================

Learning Objectives
-------------------
- Generics
- Iterator

<hr>

<br>

*Discuss your answers in the discussion forum titled "Questions on Modules".*

<br>


Problem 1
---------
**Given the definition of class `Card` and `Hand` and partial definition of
`MyLinkedList`. Complete the definition of `Hand` as described below.**

- Add an attribute to class `Hand` of type `MyLinkedList` called `playingHand`, which
holds `Card` objects.
- Complete the constructor `Hand` to add the requested `num` cards to `playingHand`.

```java
public class MyLinkedList<T> implements Iterable<T> 
{
	private Node<T> head;
	private int size;
	
	// other methods and definitions...
	
	public void addToFront(T object) 
	{
		Node<T> newNode = new Node<T>(object);
		if (this.isEmpty() == false)
			newNode.setNextNode(head);
		head = newNode;
		this.size++;
	}
	
	public Iterator<T> iterator() 
	{
		return new MyListIterator();
	}
}


public class Card 
{
	String rank;
	String suit;
	public Card(String rank, String suit) 
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	public String toString()
	{ return this.rank + " of " + this.suit; }
}

public class Hand 
{
	// TODO: COMPLETE
	
	public Hand(int num) 
	{
		for(int i = 0; i < num; i++) 
		{
			String rank = chooseRank();
			String suit = chooseSuit();
			
			// add a card to the hand
			// TODO: COMPLETE
		}
	}
}
```

<br><br>


Problem 2
---------
**Given the previous definitions from problem 1, update the class `Hand` as described in parts a and b.**

Part a) Implement the generic interface `Iterable`.

Part b) Add method `iterator()` that returns a Iterator object for `playingHand`.

<br><br>