// Zhili Zhao, Jiaping Zeng, Eric Heldt, Dylan Yanovsky
// CS1A Foothill Fall 2017
// Assignment 4 ADVANCED: Guessing Game
// The 'METHODS' File

import java.util.*;

public class GuessingGame extends Object {

    /**
     * Random object used to generate random number
     */
    Random randomNumberGenerator = new Random();

    /**
     * Scanner for listening keyboard input
     */
    Scanner keyboard = new Scanner(System.in);

    /**
     * Secret number for player to guess
     */
    int secretNumber = this.GetRandomNumber();

    /**
     * Numbers the player has guessed
     */
    int[] userGuesses = {-1, -1, -1, -1, -1};

    /**
     * Number of guesses already used
     */
    int guessesUsed = 0;

    /**
     * Generates random integer between 0 and 15 (inclusive)
     * @return random integer between 0 and 15 (inclusive)
     */
    public int GetRandomNumber() {
        return randomNumberGenerator.nextInt(16);
    }

    /**
     * Displays welcome messages and instructions
     */
    public void welcome() {
        System.out.println("Welcome, new player! Let's play the guessing game!");
        System.out.println();
        System.out.println("Rules of the guessing game:");
        System.out.println();
        System.out.println("1. You've got 5 guesses to guess my secret number");
        System.out.println("2. The number is a whole number that's between 0 and 15 (inclusive at both ends)");
        System.out.println("3. I'll give you hints about the number, if you don't guess right");
        System.out.println();
        System.out.println("Ok, I just thought of a new number for you to guess");
    }

    /**
     * Displays messages in case the guess is incorrect
     * @param guess Number guessed by user
     */
    public void isGuessNum(int guess) {
        System.out.println();
        if (isGuessedPreviously(guess)) {
            System.out.println("You've already guessed " + guess);
        } else {
            System.out.println("I'm sorry, but my secret number is not " + guess);
            storeGuess(guess);
        }
        printPreviousGuess();
        System.out.println("You have " + (5 - guessesUsed) + " guessed left");
    }

    /**
     * Displays the user's previous guesses
     */
    public void printPreviousGuess() {
        System.out.print("So far, you've guessed:");
        for (int i = 0; i < guessesUsed; i++) {
            System.out.print(" " + userGuesses[i]);
        }
        System.out.println();
    }

    /**
     * Stores user's guess in the @userGuesses variable and updates @guessesUsed
     * @param guess Number guessed by user
     */
    public void storeGuess(int guess) {
        userGuesses[guessesUsed] = guess;
        guessesUsed++;
        giveHint(guess);
    }

    /**
     * Checks if guess is within valid range of 0 and 15
     * @param guess Number guessed by user
     * @return true if guess is valid, false if not
     */
    public boolean isValidGuess(int guess) {
        if (guess >= 0 && guess <= 15) {
            return true;
        }
        return false;
    }

    /**
     * Checks if guess has been guessed previously
     * @param guess Number guessed by user
     * @return true if guessed previously, false if not
     */
    public boolean isGuessedPreviously(int guess) {
        for (int i : userGuesses) {
            if (guess == i) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if guess matches secret number
     * @param guess Number guessed by user
     * @return true if matches secret number, false if not
     */
    public boolean isSecretNumber(int guess) {
        if (secretNumber == guess) {
            return true;
        }
        return false;
    }

    /**
     * Displays hints based on user's guess
     * @param guess Number guessed by user
     */
    public void giveHint(int guess) {
        // s==g won't happen because isSecretNumber is called before this
        if (secretNumber < guess) {
            System.out.println("My secret number is less than " + guess);
        } else {
            System.out.println("My secret number is greater than " + guess);
        }
    }

    /**
     * Asks for user's guess
     * @return integer the user guessed
     */
    public int getInput() {
        System.out.println("Your next guess?");
        System.out.println();
        if (keyboard.hasNextInt()) {
            int guess = keyboard.nextInt();
            if (isValidGuess(guess)) {
                return guess;
            }
        }
        keyboard.nextLine();
        System.out.println();
        System.out.println("Please enter number between 0 and 15");
        System.out.println();
        return getInput();
    }

    /**
     * Asks if user wants to play again
     * @return true if user wants to play again, false if not
     */
    public boolean playGame() {
        System.out.println("Want to play again? Type \"1\" to continue.");
        System.out.println();
        if (keyboard.hasNextInt()) {
            if (keyboard.nextInt() == 1) {
                return true;
            }
        }
        System.out.println();
        System.out.println("Bye! Have a nice day!");
        return false;
    }

    /**
     * Checks if user guessed correctly as long as there are guesses left
     * @return true if user wants to play again, false if not
     */
    public boolean playGuessingGame() {
        welcome();
        while (guessesUsed < 5) {
            System.out.println();
            int guess = getInput();
            if (isSecretNumber(guess)) {
                System.out.println("Great guess!!! That's my number!! Winner!!");
                System.out.println();
                break;
            } else {
                isGuessNum(guess);
            }
            keyboard.nextLine();
        }
        if (guessesUsed >= 5) {
            System.out.println("You're out of guesses!");
        }
        return playGame();
    }

}