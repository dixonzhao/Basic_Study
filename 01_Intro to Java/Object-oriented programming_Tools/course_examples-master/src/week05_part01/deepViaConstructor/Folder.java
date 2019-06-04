package week05_part01.deepViaConstructor;

//
public class Folder implements Cloneable
{
	String name;
	File [] files;
	int permissions;
	
	// constructor
	public Folder(String name, File [] files)
	{
		this.name = name;
		this.files = files;
		permissions = 0744;
	}
	
	// copy constructor
	public Folder(Folder other)
	{
		int arraySize = other.files.length;
		files = new File[arraySize];
		for (int i = 0; i < arraySize; i++)
			files[i] = new File(other.files[i]);
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
