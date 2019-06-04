Practice Problems
========================

Learning Objectives
-------------------
- Defining a copy constructor
- `Cloneable` interface
- Overriding `clone()` method


<br><br>

Let's practice making a deep copy of a MagazineSubscriptions class by:
- defining a copy constructor for `MagazineSubscriptions` and all related classes under the **deepViaConstructor** subpackage.
- implementing the `clone()` method for `MagazineSubscriptions` and all related classes under the **deepViaClone** subpackage.

<br><br>

Problem 1
---------
**Define a copy constructor for class `MagazineSubscriptions` such that the output
looks similar to console snapshot. Make sure to do a deep copy of all three variables.**

Hint: For a deep copy make sure to implement a **copy constructor** for all objects.


Refer to: Customer.java, MagazineSubscriptions.java, TestMagazineSubscriptions.java

```java
// (...deepViaConstructor.MagazineSubscriptions.java)
public class MagazineSubscriptions 
{
    public static final int MAX_SIZE = 10;
    private String logo;
    private int totalSubscriptions;
    private Customer [] customers;

    public MagazineSubscriptions(String logo) 
    { 
        // ...
    }
    
    public MagazineSubscriptions(MagazineSubscriptions original) 
    { 
        // TODO: Complete the definition of the copy constructor and
        //       all non-primitive and immutable object such that
        //       this new object is a deep copy of the original
    }

    
    // other attributes and methods...
}

// Note: For the required classes see the included classes below under deepViaConstructor subpackage.
// (Customer.java) 
// (TestMagazineSubscriptions.java)
```
<br>

console output:
<pre>
<code>BEFORE computing = (computing, #subs: 3 : #1000 alice 14.95,#1001 peter 14.95,#1002 hook 14.95)
BEFORE acm = (computing, #subs: 3 : #1000 alice 14.95,#1001 peter 14.95,#1002 hook 14.95)
**AFTER computing** = (computing, #subs: 3 : #1000 alice 14.95,#1001 peter 14.95,#1002 hook **17.94**)
**AFTER acm** = (computing, #subs: 3 : #1000 alice 14.95,#1001 peter 14.95,#1002 hook **14.95**)</code>
</pre>


<br><br>


Problem 2
---------
**Complete the following method to *clone* `MagazineSubscriptions` such that the output
looks similar to console snapshot. Make sure to do a deep copy of all three variables.**

Hint: For a deep copy make sure to implement clone for all objects.

```java
// (...practice.deepViaClone.MagazineSubscriptions.java)
public class MagazineSubscriptions implements Cloneable
{
    public static final int MAX_SIZE = 10;
    private String logo;
    private int totalSubscriptions;
    private Customer [] customers;

    public MagazineSubscriptions(String logo) 
    { 
        // see your course_examples repo
    }

    protected Object clone()
    {            
        // TO COMPLETE
        
        return null;
    }
    
    // other attributes and methods...
}

// Note: For the required classes see the included classes below under deepViaClone subpackage.
// (Customer.java) 
// (TestMagazineSubscriptions.java)
```
<br>
Gives the following output:
<pre>
<code>BEFORE computing = (computing, #subs: 3  : #1000  alice 14.95,#1001  peter 14.95,#1002   hook 14.95)
BEFORE acm = (computing, #subs: 3  : #1000  alice 14.95,#1001  peter 14.95,#1002   hook 14.95)

<span style="background-color=yellow">AFTER  computing</span> = (computing, #subs: 3  : #1000  alice 14.95,#1001  peter 14.95,#1002   hook <span style="background-color=yellow">17.94</span>)
<span style="background-color=yellow">AFTER  acm</span> = (computing, #subs: 3  : #1000  alice 14.95,#1001  peter 14.95,#1002   hook <span style="background-color=yellow">14.95</span>)
...
</code></pre>

