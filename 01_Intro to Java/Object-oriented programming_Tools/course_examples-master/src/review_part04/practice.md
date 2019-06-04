Review Part 4
========================

Learning Objectives
-------------------
- Generics

<hr>

<br>

*Discuss your answers in the discussion forum titled "Questions on Modules".*

<br>


Problem 1
---------
**Which of the following statements is correct?**<br>
 (Circle all that apply.)

a. Generics can help detect type errors at compile time, thus make programs more robust.<br>
b. The parameter to a generic class can be an Object or a primitive.<br>
c. By using generic objects we can avoid cumbersome castings.<br>
d. Generics can make programs run faster.<br>


<br><br>


Problem 2
---------
**Which of the following creates a class name Container with a generic type?**<br>
 (Circle all that apply?)

a. <pre>public class Container&lt;T&gt; { ... }</pre><br>
b. <pre>public class Container { ... }</pre><br>
c. <pre>public class Container(T) { ... }</pre><br>
d. <pre>public class Container() { ... }</pre><br>


<br><br>


Problem 3
---------
**Does the JVM have information regarding type parameters and type arguments?**<br>
  Provide a brief description. Include an example.


<br><br>


Problem 4
---------
**( True / False ) Given the statement the JVM loads two different types for `employeeNames` and `employeeIDs`.**

```java
    ArrayList<String> employeeNames = new ArrayList<String>();
    
    ArrayList<Integer> employeeIDs = new ArrayList<Integer>();
```
 
 
<br><br>


Problem 5
---------
**Define a generic class called `Room` with the following attributes and methods described below.**

- a `width` and a `height` of type `int`.
- two generic fields of the same type called `firstContainer` and `secondContainer`.
- A constructor which takes in two integers and sets it to `width` and `height`.
- A method called `setContents` that takes in two generic parameters and sets `firstContainer` and `secondContainer` respectively.


<br><br>
