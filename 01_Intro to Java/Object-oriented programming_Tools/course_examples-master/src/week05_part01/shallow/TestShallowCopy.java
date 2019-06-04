package week05_part01.shallow;

public class TestShallowCopy
{
	private static final int DEFAULT_PERMISSIONS = 0077;

	public static void main(String [] args)
	{
		File [] docs = { new File("essay1.txt", DEFAULT_PERMISSIONS),
				new File("essay2.txt", DEFAULT_PERMISSIONS),
				new File("homework1.doc", DEFAULT_PERMISSIONS),
				new File(".hidden", 0002)};

		File [] music = { new File("ImBlue.mp3", DEFAULT_PERMISSIONS),
				new File("Alice.mp4", DEFAULT_PERMISSIONS),
				new File("dog.jpg", DEFAULT_PERMISSIONS)};

		File [] pix = {new File("cat.jpg", DEFAULT_PERMISSIONS),
				new File("dog.jpg", DEFAULT_PERMISSIONS)};
		
		Folder myDocuments = new Folder("documents", docs);
		Folder myPix = new Folder("pictures", pix);
		
		TestShallowCopy tester = new TestShallowCopy();

		Folder copy1 = tester.copyDirectory01(myDocuments);	
		System.out.println("\nBEFORE\t myDocuments = " + myDocuments + "\tcopy1 = " + copy1);
		copy1.name = "alias";
		copy1.files = music;
		copy1.permissions = 0777;
		System.out.println("\nAFTER \t myDocuments = " + myDocuments + "\tcopy1 = " + copy1);

		Folder copy2 = tester.copyDirectory02(myDocuments);	
		System.out.println("copy2 = " + copy2);
		System.out.println("\nBEFORE\t myDocuments = " + myDocuments + "\tcopy2 = " + copy2 + "\tmyPix = " + myPix);
		copy2.name = "tmp";
		copy2.files = pix;
		copy2.permissions = 0777;
		System.out.println("\nAFTER 1\t myDocuments = " + myDocuments + "\tcopy2 = " + copy2 + "\tmyPix = " + myPix);
		myPix.files[1] = new File("Supercalifragilisticexpialidocious", 0777);
		System.out.println("\nAFTER 2\t myDocuments = " + myDocuments + "\tcopy2 = " + copy2 + "\tmyPix = " + myPix);
		myPix = myDocuments;
		System.out.println("\nAFTER 3\t myDocuments = " + myDocuments + "\tcopy2 = " + copy2 + "\tmyPix = " + myPix);

	}
	
	public Folder copyDirectory01(Folder original)
	{
		Folder newFolder;
		newFolder = original;
		return newFolder;
	}
	
	public Folder copyDirectory02(Folder original)
	{
		Folder newFolder = new Folder(original);
		return newFolder;
	}

	private static File simulateFile(String name)
	{
		return new File(name, DEFAULT_PERMISSIONS);
	}
}
