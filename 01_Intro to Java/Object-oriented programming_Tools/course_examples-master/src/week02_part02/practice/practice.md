Practice Problems
========================

Learning Objectives
-------------------
- Exception Handling

<br><br>

Problem 1
---------

**In Java, what is the difference between throwing an error and catching an error?**

Provide an example for each.

<br><br>

Problem 2
---------
**Circle the lines that result in compilation error. Then rewrite the entire method with corrections.**

NOTE: Circle each line with a compiler error separately.



```java
public int getHouseNumber(String address) {
        int result = 0;
        try {
            String [] parts = address.split(" ");
        } 
        catch (NullPointerException) {
            System.out.println("ERROR: address cannot be empty");
        }
        result = Integer.parseInt(parts[0]);
        catch (NumberFormatException) {
            System.out.println("ERROR: invalid format");
        }
        return result;
    }
```

<br><br>