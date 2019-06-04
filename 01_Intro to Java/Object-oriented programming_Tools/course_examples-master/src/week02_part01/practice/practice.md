Practice Problems
========================

Learning Objectives
-------------------
- Extending a Class
- == vs .equals


<br><br>

**Extending a Class**
=============

Problem 1
---------
**Create a class named `BlueWhale` which extends `Whale`.**

- Add a new instance variable for color called `rgb`, which holds an array of three integers. 
  Set this your favorite RGB color.
- Add a new instance variable of type `String` called `name`
- Add a new constructor, which takes an integer for the `age` and `String` for `name`.
- Add a default constructor, which sets the name to `Moby Dick` and the default
`age` to `162`. (That’s how long we’ve been reading about this famous whale!)
Initializes instance variables by calling the previous constructor.
Hint: use `this(...)` keyword
- Write setters and getters for the class attribute `name`.
- Write a getter for the class attribute `rgb`
- Override the `toString()` method to return the `name` of our BlueWhale followed by calling the `toString()` method of the **superclass** 


Below is an ASCII representation of the inheritance hierarchy.
<pre>
           Object
             ^
             |
           Mammal
            ^  ^
            |  |
        Whale  Other
         ^ 
         |
    BlueWhale 
</pre>

<br><br><br>



**== vs .equals**
=============

Problem 2
---------

**Given the class `SimplePoint` below complete the `equals` method such
  that two instances of type `SimplePoint` are equal if they have exactly
  the same x & y coordinate as well as the same color.**

```java
public class SimplePoint 
{
	int x;	  
	int y;
	int [] rgb;

	public SimplePoint()
	{
		x = 0;
		y = 0;
		
		rgb = new int[3];
		rgb[0] = 0;	// red
		rgb[1] = 0; // green
		rgb[2] = 0; // blue
	}
	
	public SimplePoint(int x, int y, int [] color)
	{
		this.x = x;
		this.y = y;
		
		rgb = new int[3];
		rgb[0] = 0;	// red
		rgb[1] = 0; // green
		rgb[2] = 0; // blue
	}
	
	public boolean equals(Object other)
	{
		// TODO: COMPLETE
	}
		
	public String toString()
	{
		String result;
		result = "" + x;
		result += ",";
		result += y;
		return result;
	}
}
```


Problem 3
---------
**What is the output in the code segment?**

```java
        int [] colorBlue = {0, 0, 255};

		SimplePoint pt1;
		SimplePoint pt2;

		pt1 = new SimplePoint (100, 200, colorBlue);
		pt2 = new SimplePoint (100, 200, colorBlue);

		// QUESTION 1: What happens when comparing via == ?
		if ( pt1 == pt2)
			System.out.println("They are equal!");
		else
			System.out.println("They aren't equal!");

		// QUESTION 2: What happens when comparing via .equals ?
		if ( pt1.equals( pt2))
			System.out.println("They are equal!");
		else
			System.out.println("They aren't equal!");

		// QUESTION 3: Now, what happens when comparing via == ?
		pt1 = pt2;
		if ( pt1 == pt2)
			System.out.println("After assignment, they are equal!");
		else
			System.out.println("After assignment, they still aren't equal!");
```

<br><br>


Problem 4
---------
**In class named `BlueWhale`, override the method `equals`, such that two objects of
type `BlueWhale` are equal if they have the same `name`.**



