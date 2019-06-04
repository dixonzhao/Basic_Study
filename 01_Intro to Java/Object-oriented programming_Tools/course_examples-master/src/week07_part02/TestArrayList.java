package week07_part02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class TestArrayList 
{	
	public static void main(String [] args)
	{
		// create an array list that can hold Strings
		ArrayList<String> mylist = new ArrayList<String>();

		// add elements to the list
		mylist.add("apples");
		mylist.add("bananas");
		mylist.add("carrots");

		System.out.print("Elements in the list: ");
		Iterator<String> i = mylist.iterator();
		while(i.hasNext()) 
		{
			Object element = i.next();
			System.out.printf("%s -> ", element);
		}
		System.out.println("null");

		// modify an element
		ListIterator<String> li = mylist.listIterator();
		while(li.hasNext()) 
		{
			String element = li.next();
			li.set("2 lbs of " + element);
		}

		System.out.print("traverse list to show update: ");
		i = mylist.iterator();
		while(i.hasNext()) 
		{
			Object element = i.next();
			System.out.printf("%s -> ", element);
		}
		System.out.println("null");

	}
}
