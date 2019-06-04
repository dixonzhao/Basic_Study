package week05_part01.deepViaConstructor;

public class TestCopyViaConstructor
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

		TestCopyViaConstructor tester = new TestCopyViaConstructor();

		Folder copy = tester.copyDirectory03(myDocuments);
		System.out.println("copy = " + copy);
		System.out.println("\nBEFORE\t myDocuments = " + myDocuments + "\tcopy = " + copy);
		myDocuments.files[1] = new File("Supercalifragilisticexpialidocious", 0777);
		System.out.println("\nAFTER 1\t myDocuments = " + myDocuments + "\tcopy = " + copy);
	}

	public Folder copyDirectory03(Folder original)
	{
		Folder newFolder = new Folder(original);
		return newFolder;
	}

	private static File simulateFile(String name)
	{
		return new File(name, DEFAULT_PERMISSIONS);
	}
}
