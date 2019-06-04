package week01_part01;

import java.util.Scanner;

public class ParseInput02 
{

	public static void main(String[] args) 
	{
		Scanner user_input = new Scanner(System.in);

		System.out.println("Enter some text:");
		String str =  user_input.next();
		// foothill college Los Altos
		System.out.println("First thing you entered: " + str);
		str =  user_input.next();
		System.out.println("second thing you entered: " + str);
	}

}
