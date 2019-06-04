package week07_part02;

import java.util.ArrayList;
import java.util.Iterator;


public class TestStringList 
{
	public static void main(String [] args)
	{
		ArrayList<String> names = new ArrayList<String>();

		// somehow we ended up inserting valid and invalid names...
		names.add("alice");
		names.add("bob");
		names.add("");
		names.add("");
		names.add("dan");
		names.add("george");
		names.add("");
		names.add("cindy");

		// print original list of names
		System.out.println("original :\t" + names);
		
		// remove invalid names from list
		// QUESTION: What happens when you remove an element while traversing
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals("")) {
				names.remove(i);
				System.out.println("index # " + i + ":\t" + names);
			}
		}
		
		// modifying the list while traversing
		Iterator<String> itr = names.iterator();
	    while (itr.hasNext()) {
	        String str = itr.next();
			if (str.equals("")) {
	            itr.remove();
	        }
	    }
		
		// print updated list of names
		System.out.println("updated :\t" + names);
	}
}
