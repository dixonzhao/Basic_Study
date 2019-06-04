// Zhili Zhao <---<<< Name
// BIT115 Fall 2015
// Assignment 4 ADVANCED: Guessing Game
// The 'METHODS' File

// You may use the nested comments below as hints only. Remember, there is no one right or wrong way 
// to 'solve' this Assignment, so feel free to delete the comments if you find them distracting.

import java.util.Random;
import java.util.Scanner;


public class GuessingGame extends Object
{
	// List any instance variables here (e.g., userGuess, numberChoice)
   
	Random randomNumberGenerator = new Random();
	Scanner keyboard = new Scanner(System.in);
   
	 /** @pdOid 1bef8835-df11-4c73-aa2f-14980c62bef4 */
	   private int[] arra= {-1,-1,-1,-1,-1};
		   
	   /** @pdOid 10cff9f9-3d35-4121-994d-48f22abe6692 */
	   private int inP;
	   /** @pdOid 11b478fd-58ff-431f-8f5a-70ea69c382f8 */
	   private int cou=5;
	   /** @pdOid 0422f0a5-8541-4ee3-a6eb-e0a43bed527d */
	   private int secNum;
	   
	   private int controlNum=1;
	   
	   
	   /** @pdOid a3c3d2c0-0cf9-40f6-82f4-230bb903bdfe 
	     */
	   private void playMethod(int secNum) {
	      // TODO: implement
		   this.secNum=secNum;
		   
		   while(cou-->0) {
 
//			   3
			  inP= this.inputNum();
			  System.out.println();
//			  9, 5
			   if(this.ifExist(arra, inP)) {
				   cou=this.sameInput(arra, inP, cou);
			   }
			   

			   else {
//				   4
				   if(this.checkEquals(inP, secNum)) {
					   System.out.println("Great guess!!! That¡¯s my number!! Winner!!");
					   break;
				   }else {
					   arra=this.falseInput(arra, inP, secNum);
				   }
				   
				   
			   }
			   
			   this.printSoFar(arra);
			   System.out.println("You have " +cou+" guesses left");
		   }
		   for(int i=0; i<5; i++) {
			   arra[i]=-1;
		   }
		   
	   }
	   
	   /** @pdOid 506cdccd-84a5-4586-a9aa-7b36f33c8d3c */
	   private int inputNum() {
	      // TODO: implement
		   Scanner sc= new Scanner(System.in);
		   System.out.println("Your next guess? ");
		   System.out.println();
		   if(sc.hasNextInt())
			   	return sc.nextInt();
		   System.out.println("You didn't input a number ! please do it again");

	      return inputNum();
	   }
	   
	   /** @param inP 
	    * @param secNum
	    * @pdOid 713139d4-6217-48c0-84c9-cdb75b235bfd */
	   private boolean checkEquals(int inP, int secNum) {
	      // TODO: implement
		   if(inP==secNum) {
			   return true;
		   }
	      return false;
	   }
	   
	   /** @param arra 
	    * @param inP 
	    * @param cou
	    * @pdOid b40f7e79-14ee-4aa9-b4a6-8f12b4a93afd */
	   private int sameInput(int[] arra, int inP, int cou) {
	      // TODO: implement
		   System.out.println("You¡¯ve already guessed "+inP); 
		   return cou+=1;
	   }
	   
	   /** @param arra 
	    * @param inP
	    * @pdOid b3eb68e7-ca38-4655-9a64-887193d8102b */
	   private int[] falseInput(int[] arra, int inP, int secNum) {
	      // TODO: implement
//		   I¡¯m sorry, but my secret number is not 7
//		    less than 7
		   String st;
		   if( inP>secNum) {
			   st="less";
		   } else {
			   st="more";
		   }
		   
		   System.out.println(" I¡¯m sorry, but my secret number is not "+ inP);
		   System.out.println("My secret number is "+ st+ " than "+ inP );
		   for(int i=0; i<5;i++) {
			   if(arra[i]==-1) {
				   arra[i]=inP;
				   break;
			   }
		   }
	      return arra;
	   }
	   
	   /** @pdOid cfe7d0ba-7301-43d7-b936-829512e82a8a */
	   public void gameOver() {
		   // TODO: implement
		   Scanner sc= new Scanner(System.in);
		   System.out.println("Want to play again (type 1 for ¡°yes¡±, and 0 for ¡°no¡±)");
		   System.out.println();
		   int pd = 0;
		   if(sc.hasNextInt()) {
			   pd=sc.nextInt();
		   }
		   
		   if(pd==0) {
			   System.out.println();
			   System.out.println("Have a nice day!");
			   controlNum=0;
		   } 
		   else 
		   {
			   cou=5;
			   pd=0;
			   controlNum=1;
		   }
	   }
	   
	   /** @pdOid 8d75796c-43da-460f-9c57-3c3096db1ae3 */
	   private void wel() {
	      // TODO: implement
		   System.out.println("Welcome, new player!  Let¡¯s play the guessing game!"
			   		+ "\n "
			   		+ "\n Rules of the guessing game: "
			   		+ "\n "
			   		+ "\n 1. You¡¯ve got 5 guesses to guess my secret number"
			   		+ "\n 2. The number is a whole number that¡¯s between 0 and 15 (inclusive at both ends)"
			   		+ "\n 3. I¡¯ll give you hints about the number, if you don¡¯t guess right."
			   		+ "\n "
			   		+ "\n Ok, I just thought of a new number for you to guess.");
	   }
	   
	   public void setCou(int cou) {
		this.cou = cou;
	}

	/** @param arra 
	    * @param inP
	    * @pdOid 1526cb34-0628-416b-8b4e-2df9df99f97f */
	   private boolean ifExist(int[] arra, int inP) {
	      // TODO: implement
		   for(int i: arra) {
   			if(i==inP) {
   				return true;
   			}
   		}
   	
   		return false;
	   }
	   
	   /** @param arra
	    * @pdOid 53ccc6e9-c210-4872-8299-18a539d963aa */
	   private void printSoFar(int[] arra) {
		// TODO: implement
		   System.out.print("So far, you¡¯ve guessed: ");
		   for(int i : arra) {
			   if(i!=-1) {
				   System.out.print(i+" ");
			   }
		   }
		   System.out.println();
	   }
	   
	   /** @pdOid abb81f5e-0d07-4621-b004-a0116644b274 */
	
	   private int GetRandomNumber()
	{
		return randomNumberGenerator.nextInt(16); 
	}
	
   
	   
	   
	   
	   
   public int PlayGuessingGame()
	{
		int secretNumber = this.GetRandomNumber(); 
                                      
                   
		this.wel();          
		this.playMethod(secretNumber);
		this.gameOver();
				
		return controlNum; 
	}
	
}
