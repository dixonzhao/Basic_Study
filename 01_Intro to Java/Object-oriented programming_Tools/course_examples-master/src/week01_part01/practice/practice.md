Practice Problems (Review)
===============================

Learning Objectives
-------------------
- Review one-dimensional arrays.
- Review two-dimensional arrays.


<br><br>

1D arrays
=============

Problem 1
---------
**Declare four arrays:**

a) Name the first array `studentNames` with *three* elements of type `String`. The elements of
this array will hold the value for the grade for each of the students in array names.

b) Name the second array `gradesOfStudent01`, third array `gradesOfStudent02` and
fourth array `gradesOfStudent03`. All three are equal length with *seven* elements of type
`int`. The arrays will hold the grade for students Alice, Bob and yourName respectively.

Note: For now our array names are a bit wordy, but descriptive and easier to remember...
Also, perhaps one too many arrays, but we’ll simplify this later.


<br><br>


Problem 2
---------
**Initialize all elements of the four arrays.**

a) Initialize the array `studentNames` to start with the empty `String` “” (i.e. quotes with no space).

b) Initialize the remaining arrays that hold grades with the value `0`

Hint: Use `for`-loop(s) to iterate through all the elements of the arrays.
Hint: The size of an array is stored in `length` (For example, `names.length`) which is the array
size - 1. The first array index is 0.


<br><br>

Problem 3
---------

**Assign values to your arrays as follows:**

a) Set the first element of array `studentNames` to `Alice`, set the second element to `Bob`, set
the last element of the array to your first name.

b) Set the indices of the `gradesOfStudent01`, `gradesOfStudent02` and `gradesOfStudent03` to produce the following output:


<pre><code>Alice, 100, 90, 0, 0, 0, 0, 0
Bob, 70, 80, 0, 0, 0, 0, 0
Bita, 0, 0, 90, 0, 0, 0, 0
</code></pre>



<br><br><br>


2D arrays
=============

Problem 4
---------
**Managing individual student grades via separate arrays is impractical as the number
of students increase. Rather than creating and managing N arrays
(`gradesOfStudent01`,…, `gradesOfStudentN`), let’s use a 2D array instead.**

Given the program segment below (similar to before),
declare an array called `allGrades` to hold all the grades of all students.
- A row holds all grades of a single student. For example: `allGrades[0]` for all Alice’s
grades.
- A column holds one grade for a student. For example `allGrades[0][2]` for the third
grade of Alice.

Initialize all grades to 0.
Set the grades and output the array `allGrades` such that the output is similar to below.
Note: You may ignore white space

<pre><code>Alice, 100, 90, 95, 90
Bob, 100, 95, 80, 95
Cindy, 85, 90, 80, 100
</code></pre>



```java
	String [] names = {"Alice", "Bob", "Cindy"};
	int [] gradesStudent01 = {100, 90, 95, 90};
	int [] gradesStudent02 = {100, 95, 80, 95};
	int [] gradesStudent03 = {85, 90, 80, 100};
	int numStudents = names.length;
	int numGrades = gradesStudent01.length;
	int [][] allGrades; // ALLOCATE SPACE
	
	// TO COMPLETE: Set allGrades[0] to grades of Student01, etc…
	// Use a for-loop to set grades of Student01 to the first row of allGrades;
	// Use another for-loop to set grades of Student02 to second row of allGrades;
	// etc
```

<br><br>
