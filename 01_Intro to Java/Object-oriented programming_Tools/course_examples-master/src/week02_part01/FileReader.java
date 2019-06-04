package week02_part01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader 
{
	String [] linesOfText;
	
	public FileReader(String filename)
	{
		linesOfText = new String[10];
		
	    Scanner input;
		try 
		{
		    File infile = new File (filename);

			input = new Scanner (infile);
			
			int count = 0;
						
			while (input.hasNextLine() && count < 10)
		    {
		      String line = input.nextLine();
		      linesOfText[count] = line;
		      
		      // for debugging
		      count++;
		    }
			
		    input.close();
		} 
		catch (FileNotFoundException someobject) 
		{
			System.out.println("File " + filename + " not found!");
		}
	}
	
	
	public String [] getLinesRead()
	{	
		return linesOfText;
	}
}
