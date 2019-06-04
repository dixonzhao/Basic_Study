Review Part 1
========================

Learning Objectives
-------------------
- Arrays
- Inheritance
- Exception handling

<hr>

<br>

*Discuss your answers in the discussion forum titled "Questions on Modules".*

<br>

Problem 1
---------
**What is the output of the following program segment?**


```java
    double [][] firstQuarterDeposits = new double[4][];
    double [] jan = {0, 200, 250, 50};
    double [] feb = {25, 50, 300, 75};
    double [] march = {400, 175, 250, 225};
    double [] april = {125, 0, 200, 100};
	
    firstQuarterDeposits[0] = jan;
    firstQuarterDeposits[1] = feb;
    firstQuarterDeposits[2] = march;
    firstQuarterDeposits[3] = april;
	
    int month = 3;
    int week = 2;
	
    double deposit = firstQuarterDeposits[month][week];
    System.out.println("a) deposit month " + (month-1) + " week " + week + " is " + deposit);
	
    month = 2;
    System.out.println("b) deposit month " + (month-1) + " week " + week + " is " + firstQuarterDeposits[month][week-1]);
	
    week++;
    System.out.println("c) deposit month " + (month-1) + " week " + week + " is " + firstQuarterDeposits[month][week]);
	
    double total = firstQuarterDeposits[month-1][week-2] +
    firstQuarterDeposits[month][week];
    System.out.println("d) deposit total is " + total);
```

<u>your output here:</u>

<br><br>


Problem 2
---------
**Check for compilation and runtime errors.<br>
Then, correct the following program.**

```java
class TestBillboard
{
    public static void main(String args[])
    {
        Rectangle r;
        r = new Rectangle();
        r.printRect();
        r.printBillBoard();
        BillBoard b;
        b = new BillBoard();
        b.printBillBoard();
        b.printRect();
        b = new Rectangle();
        r = new BillBoard();
        r.printRect();
        r.printBillBoard();
        ((BillBoard)r).printBillBoard();
    }
}

class Rectangle
{
    private int length = 0;
    private int width = 0;
    public void printRect()
    { System.out.println ("Length = " + length + ", Width = " + width); }
}

class BillBoard extends Rectangle
{
    private String message = “hello”;
    public void printBillBoard()
    {
        System.out.println (message);
        super.printRect();
    }
}
```

<br><br>


Problem 3
---------
**What is the output of the following program.**

```java
public class ReviewException
{
    public static void main(String args[])
    {
        int x;
        try
        {
            x = foo(10);
        }
        catch (Exception e)
        {
            System.out.println ("Caught an exception: " + e);
            x = 99;
        }
        System.out.println("x = " + x);
    }
    
    public static int foo (int x) throws Exception
    {
        System.out.println ("foo started with " + x);
        int temp = bar (x);
        System.out.println ("foo returning " + temp);
        return temp;
    }
    
    public static int bar (int y) throws Exception
    {
        System.out.println ("bar started with " + y);
        if ( y > 0)
            throw new Exception ("just a test");
        System.out.println ("when is this executed?");
        return y;
    }
}
```

<br><br>



