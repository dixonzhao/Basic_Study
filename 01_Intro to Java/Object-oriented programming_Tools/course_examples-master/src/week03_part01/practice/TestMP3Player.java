package week03_part01.practice;

public class TestMP3Player
{
	public static void main(String [] args)
	{
		MP3Player zune = new MP3Player("zune"); 
		System.out.println(zune.toString());  
		zune.charge();  
		System.out.println(zune);   
		zune.play();    
	}
}
