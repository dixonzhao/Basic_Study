package week06_part01.practice;

public class Folder 
{
	String name;
	String [] filenames;
	int permissions;
	
	// constructor
	public Folder(String name, String [] files)
	{
		this.name = name;
		this.filenames = files;
		this.permissions = 0744;
	}
	
	// copy constructor
	// Note: Does a shallow copy.
	public Folder(Folder other)
	{
		this.name = other.name;
		this.filenames = other.filenames;
		this.permissions = other.permissions;
	}
	
	public String toString()
	{
		String result = name + ": " + permissions + "\t";
		for (int i = 0; i < filenames.length; i++)
			result += filenames[i] + "\t";
		result += "\n";
		return result;
	}
}
