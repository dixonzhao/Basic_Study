Practice Problems
========================

Learning Objectives
-------------------
- Class
- Interface
- Abstract classes

<br><br>


Problem 1
---------
**Write an interface called `Shape` with the following attributes and method interfaces:**

- An attribute of type `String` called `LABEL` and set it to the interface name.
- A method **interface** called `getArea()` that returns a value of type `double`.
- A method **interface** called `draw()` that does *not* have a return value.


<br><br>


Problem 2
---------
**Write a class called `Rectangle` which *implements* the interface `Shape`:**

- Two attributes of type `double` called `width` and `height`.
- Specify the behavior of `getArea()` by getting the area (width * height) and returning it.
- Specify the behavior of `draw()` to print out to console a message with the class name included.
<br><br>


Problem 3
---------
<br><br>
Without using your IDE…

**Will the `interface Drivable` compile successfully?**

Hint: Use Java 8.

```java
public interface Drivable 
{
	public final double STOPSPEED = 0;
	private double speed;
	
	public void start()
	{
		this.speed = 30;
	}
	
	public void turn();
	public void backup();
	
	public void stop()
	{
		this.speed = STOPSPEED;
	}
}
```

Problem 4
--------

**Given the interface `Playable` define a class called `MP3Player` with the following attributes and method interfaces as described below.**

- A constant attributes of type `int` called `MAXNUMSONGS` that is set to `10`.
- An attribute of type `boolean` called `isCharged` that is initialized to `false` in the constructor.
- An attribute of type `String` called `brand`.
- An attribute of called `songs` which is array of type `String` that is initialized to a length of `MAXNUMSONGS` in the constructor.
- A constructor that takes in one parameters of type `String` and sets it to the instance variable `brand`.
- A method called `charge()` that sets `isCharged` to `true` and has no return type.
- A method called `toString()` which has already been implemented for you.

```java
// somewhere in class MP3Player
// returns string representation of class MP3Player
public String toString()
{
    String str = brand + ".";
    if (!this.isCharged)
        return str + " Need to charge. Goodbye.";
    str += " battery full.";
    str += " Capacity " + this.songs.length + " songs.";
    return str;
}
```

<br>
- Implement any methods required such that the output matches below.

```java
public interface Playable 
{    
    public static int MUTEVOLUME = 0;
    public void play();
    public void stop();
}


public class TestMP3Player 
{
    public static void main(String [] args) 
    {
        MP3Player zune = new MP3Player("zune");
        System.out.println(zune);
        zune.charge();
        System.out.println(zune);
        zune.play();
    }
}
```

Output:
<pre><code>zune. Need to charge. Goodbye.
zune. battery full. Capacity 10 songs.
Playing your song.
 </code></pre>




<br><br>

Problem 5
---------
**Given the abstract class `Instrument` *define* a class called `Piano` with the
following attributes and methods:**

- Two attributes of type `String` called `style` and `type` and an attribute of type `boolean`
called `isTuned`.
- A constructor that takes in two parameters of type `String` and sets it to the instance
variables `style` and `type` respectively.
- A method called `checkIfTuned()` that returns whether or not the instrument is tuned (i.e. return value of attribute `isTuned`).
- Define any abstract methods required by the parent class.

Note: Make sure to initialize the attribute `isTuned` when the object is allocated.

```java
public abstract class Instrument 
{
	public int volume;
	
	// Note: For simplicity this mehtod sets the attribute
	// isTuned to true when called
	public abstract void tune();

	public void setVolume(int volume)
	{
		this.volume = volume;
	}
	
	public int getVolume()
	{
		return this.volume;
	}
}
```

