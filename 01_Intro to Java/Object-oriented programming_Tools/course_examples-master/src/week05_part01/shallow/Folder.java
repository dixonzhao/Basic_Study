package week05_part01.shallow;

public class Folder 
{
	String name;
	File [] files;
	int permissions;
	
	// constructor
	public Folder(String name, File [] files)
	{
		this.name = name;
		this.files = files;
		this.permissions = 0744;
	}
	
	// copy constructor
	// Note: Does a shallow copy.
	public Folder(Folder other)
	{
		this.name = other.name;
		this.files = other.files;
		this.permissions = other.permissions;
	}
	
	public String toString()
	{
		String result = name + ": " + permissions + "\t";
		for (int i = 0; i < files.length; i++)
			result += files[i] + "\t";
		result += "\n";
		return result;
	}
}
