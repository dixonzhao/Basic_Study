package week02_part01;

public class TestFileReader 
{
	public static void main(String[] args) 
	{
		String filename = "data/input.txt";
		
		FileReader fr = new FileReader(filename);
		
		String [] linesRead = fr.getLinesRead();
		
		System.out.println(linesRead[0]);
		System.out.println(linesRead[linesRead.length-1]);
	}

}
