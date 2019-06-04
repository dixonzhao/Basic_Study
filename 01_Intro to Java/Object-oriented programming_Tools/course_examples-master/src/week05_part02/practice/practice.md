Practice Problems
========================

Learning Objectives
-------------------
- Defining a copy constructor
- Making a deep copy of a `LinkedList` object


<br><br>

Problem 1
---------

*Note: This problem builds on top of the MagazineSubscriptions class which requires a copy constructor.*

<br>

**Given the previous class `Customer`, `MagazineSubscriptions` and class `MagazineSubscriptionsLL` ("LL" for Linked List):**

a) Make deep copy of the list of `Customer`s in class `MagazineSubscriptionsLL`. 

Refer to: Customer.java, MagazineSubscriptionsLL.java, update TestMagazineSubscriptions.java

```java
public class MagazineSubscriptionsLL
{
    private String logo;
    private int totalSubscriptions;
    private CustomerLinkedList customers;

    public MagazineSubscriptionsLL(String logo) 
    {
        this.logo = logo;
        this.customers = new CustomerLinkedList();
        this.totalSubscriptions = 0;
    }
    
	public MagazineSubscriptionsLL(MagazineSubscriptionsLL original)
	{
		// TODO: Complete the definition of the copy constructor and
		//       all non-primitive and immutable object such that
		//       this new object is a deep copy of the original.

	    // Hint: This one is a short one.
	    //       Implement clone for class CustomerLinkedList such that it
	    //       provides a clone of every single node.     
	}
    
    public void addCustomer(Customer subscriber)
    {
        customers.add(subscriber);
        totalSubscriptions++;
    }

    // other attributes and methods 
}
```
<br>

b) Copy TestMagazineSubscriptions.java and rename it to TestMagazineSubscriptionsLL.java file. 

Then, modify `TestMagazineSubscriptionsLL` by adding test cases that check whether `MagazineSubscriptionsLL` successfully created a deep copy of *all* the nodes.


