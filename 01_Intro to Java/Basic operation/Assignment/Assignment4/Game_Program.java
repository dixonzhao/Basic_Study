// Zhili Zhao, <---<<< PUT YOUR NAMES HERE 
// BIT115 Fall 2015
// Assignment 4 ADVANCED: Guessing Game
// The 'MAIN' File

public class Game_Program extends Object
{    
    public static void main(String[] args)
    {  
		GuessingGame gg = new GuessingGame(); 	
		int control=1;
		
		while(control==1) {
			control=gg.PlayGuessingGame();
		} 
			
			
    }
    
   
}
