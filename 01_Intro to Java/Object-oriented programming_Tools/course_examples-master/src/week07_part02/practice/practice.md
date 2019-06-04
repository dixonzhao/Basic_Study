Practice Problems
========================

Learning Objectives
-------------------
- Using a nested class
- Traversing a list using `Iterator` class

<br><br>

Problem 1
---------
**Given the class `Employee`. Complete the following the test class `TestArrayListIterator`, such that the iterator stops searching the list once the element of interest is found.**

```java
// (Employee.java)
public class Employee 
{
    private String name;
    private double salary;

    public Employee(String name, double newSalary) 
    {
        this.name = name;
        this.salary = newSalary;
    }
    
    public void giveRaise(double raise) 
    {    
        this.salary = this.salary + this.salary * raise;  
    }
    
    public boolean equals(Object o) 
    {
        if (o instanceof Employee) 
        {
            Employee other = (Employee)o;
            if (other.name.equals(this.name))
                return true;
        }

        if (o instanceof String) 
        {
            String otherName = (String)o;
            if (otherName.equals(this.name))
                return true;
        }

        return false;
    }

    // other methods
}
```

The test class TestArrayListIterator.java :

```java
    // (TestArrayListIterator.java)
    // somewhere in main
    // create a list of employees
    ArrayList<Employee> employees = new ArrayList<>();    
    employees.add(new Employee("alice", 1000));
    employees.add(new Employee("peter", 1000));
    employees.add(new Employee("rumple", 1000));
    employees.add(new Employee("hook", 1000));
    employees.add(new Employee("bell", 1000));
    // adds some more employees...

    // search for Employee with name "rumple"
    Iterator itr;
    
    // TODO: Instantiate an iterator called "itr"
    
    // an object to hold the employee if found
    Employee foundEmployee = null;
    
    // traverse the list until the employee with
    // the name "rumple" is found
    while(itr.hasNext())
    {
        Employee element = itr.next();
        // TODO: Check if the current element is equal to "rumple"
        //       If so, stop traversing the list.
    }

    System.out.println("BEFORE modifying element = " + foundEmployee);

    // TODO: Give "rumple" a raise
    
    System.out.println("AFTER modifying element = " + foundEmployee);
```



<br><br>


Problem 2
---------
**Given the class `Employee` and `MyLinkedList`. Create an object called `employees`, which is of type `MyLinkedList` with Employee as the type parameter.**

(See Employee.java, MyLinkedList.java, Payroll.java)

```java
public class MyLinkedList<T> implements Iterable<T>
{
    private Node head;
    
    /** Inner Node class.
     * NOTE: for your project, create Node as *separate* class,
     *       which means you will be submitting a Node.java file.
     */
    public class Node
    {
        private T data;    
        private Node next;

        // ...		
    }
    
    private class MyListIterator implements Iterator<T> 
    {
        private Node current;
        
        public MyListIterator() 
        {    current = head; }
        
        // ...		
    }

    /*
     *  creates an empty new list
     */
    public MyLinkedList()
    {
        this.head = null;
        this.elementCount = 0;
    }

    // ...		


    /**
     * create an iterator object that starts at beginning of the list
     */
    public Iterator<T> iterator() 
    {
        return new MyListIterator();
    }
    
    /**
     * call the toString() method of all nodes in the list
     */
    public void printList()
    {
        // TODO: traverse the list to print the elements
        System.out.println("null");
    }
}
```

**Add the objects "alice", "peter", etc. to your list.**
```java
		employees.addToFront(new Employee("alice", 1000, 7));
		employees.addToFront(new Employee("peter", 1000, 4));
		employees.addToFront(new Employee("rumple", 1000, 4));
		employees.addToFront(new Employee("hook", 1000, 9));
		employees.addToFront(new Employee("bell", 1000, 2));
```

**Then, traverse your list using an iterator.
Then, print all elements in the list.**
<br><br>
