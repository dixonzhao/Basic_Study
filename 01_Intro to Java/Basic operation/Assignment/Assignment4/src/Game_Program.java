// Zhili Zhao, Jiaping Zeng, Eric Heldt, Dylan Yanovsky
// CS1A Foothill Fall 2017
// Assignment 4 ADVANCED: Guessing Game
// The 'METHODS' File

public class Game_Program extends Object
{
    public static void main(String[] args)
    {
        boolean playAgain;
        do {
            GuessingGame gg = new GuessingGame();
            playAgain = gg.playGuessingGame();
        } while (playAgain);
    }
}