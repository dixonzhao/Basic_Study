package week10;

import java.io.File;
import java.text.DecimalFormat;

public class DiskUsage 
{
	public static long getSizeOfFile(File path)
	{
		// the total size of all files
		long size = 0;

		// base case
		if (path.isFile()) 
		{
			size = path.length();
			return size;
		}

		// Note: Not yet complete
		if (path.isDirectory())
		{
			System.err.println("File is a directory. Unable to complete request.");
		}

		return size;
	}


	public static String convertToReadableSize(long sizeInBytes)
	{
		if (sizeInBytes <= 0)
			return "0";

		double kb = sizeInBytes / Math.pow(1024, 1);	// 1 KB = (1024 bytes)^1
		double mb = sizeInBytes / Math.pow(1024, 2); 	// 1 MB = 1024^2
		double gb = sizeInBytes / Math.pow(1024, 3); 	// 1 GB = 1024^3
		double tb = sizeInBytes / Math.pow(1024, 4); 	// 1 TB = 1024^4

		String readableSize =  "";
		DecimalFormat dec = new DecimalFormat("0.00");
		if (tb > 1)
			readableSize = dec.format(tb).concat(" TB");
		else if (gb > 1)
			readableSize = dec.format(gb).concat(" GB");
		else if (mb > 1)
			readableSize = dec.format(mb).concat(" MB");
		else if (kb > 1)
			readableSize = dec.format(kb).concat(" KB");
		else
			readableSize = dec.format(sizeInBytes).concat(" B");

		return readableSize;
	}

	public static void main(String [] args)
	{
		String filePath = "/Users/betamaz/Music/Jazz/Louis Armstrong/What A Wonderful World.mp3";

		// display the size
		long dirSize = getSizeOfFile(new File(filePath));
		System.out.printf("%20s : %10s bytes\n", filePath, dirSize);
		System.out.printf("%20s : %10s\n", filePath, convertToReadableSize(dirSize));

	}
}
