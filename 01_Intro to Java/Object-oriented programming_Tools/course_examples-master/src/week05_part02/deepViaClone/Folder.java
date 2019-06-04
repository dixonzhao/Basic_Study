package week05_part02.deepViaClone;

public class Folder implements Cloneable
{
	String name;
	File [] files;
	int permissions;
	
	// constructor
	public Folder(String name, File [] g)
	{
		this.name = name;
		this.files = g;
		this.permissions = 0744;
	}
	
	protected Object clone()
	{
		int arraySize = this.files.length;
		File [] files = new File[arraySize];
		for (int i = 0; i < arraySize; i++)
			files[i] = (File)this.files[i].clone();
		
		Folder newCopy = new Folder(this.name, files);
		return newCopy;
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
