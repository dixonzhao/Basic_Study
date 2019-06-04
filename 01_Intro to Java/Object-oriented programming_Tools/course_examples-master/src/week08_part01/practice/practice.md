Practice Problems
========================

Learning Objectives
-------------------
- Creating an `ArrayList` of objects
- Implementing the `Comparator` interface

<br><br>

Problem 1
---------
**Given the class `Employee` and sample `main()` method. Circle the lines that result in compilation error and make corrections.**

```java	
public class Employee implements Comparable 
{
    private String name;
    private int yearsOfService;

    public Employee(String name, int numYearsEmployed) 
    {
        this.name = name;
        this.yearsOfService = numYearsEmployed;
    }


    public int compareTo(Employee other) 
    {
        // this employee is making less salary than the one being compared
        if(this.yearsOfService < other.yearsOfService)
            return -1;

        // this employee is making more salary
        if(this.yearsOfService > other.yearsOfService)
            return 1;

        // if both employees are making the same salary
        return 0;
    }

    public String toString() 
    {    return this.name + ", years served  " + this.yearsOfService + "\n";  }
}


    // somewhere in main
    // create a list of employees
    ArrayList<> employees = new ArrayList<Employee>();
    employees.add( Employee("rumple", 1400) );
    employees.add( Employee("hook", 1000) );
    employees.add( Employee("bell", 1200) );
    employees.add( Employee("swan", 1000) );
    
    // adds some more employees...
    
    // later get a specific element in our list
    Employee thirdEntry = employees.get(2);
    if (thirdEntry.compareTo("swan")) 
    {
        System.out.println("swan is 3rd in line.");
    }
```

<br><br>

Note: Problem 1 and Problem 2 are not related.

<br><br>

Problem 2
---------
**Given the class `Employee` and `TestComparatorOnEmployees`, define the class `EmployeeNameComparator` which implements `Comparator`.**

Recall that the compare method returns:
- -1 if first employee’s name is less than second employees, or
- 1 if first employee’s name is greater than seconds, or 
- 0 if both name’s are equal.

For future, when asked to implement a `Comparator`, assume the return values are similar.

```java
public class Employee
{
    private String name;
    private double salary;
    private int yearsOfService;
    
    // other content
}
```

and a sample main in test class:
```java
    Employee alice = new Employee("alice", 1000, 5);
    Employee bob = new Employee("bob", 1400, 3);
    
    EmployeeNameComparator ceName = new EmployeeNameComparator ();
    result = ceName.compare(alice, bob);
    System.out.println("Comparing names: " + result);
```

Define the `EmployeeNameComparator` class below: 

<br><br>
