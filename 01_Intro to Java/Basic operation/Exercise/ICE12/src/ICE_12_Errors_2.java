import becker.robots.*;


// This robot will be able to keep track of how many
// moves it's made, and then be able to print a message to
// the user saying that.
class MoveRobot extends Robot {
	int numberOfMovesMade = 0; // Syntax/compile time error, no variable type
	int numberOfLeftTurns = 0; // makes a variable to keep track of the amount of left turns

	MoveRobot(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void moveCounted() {
		this.move();
		this.numberOfMovesMade++; // Logic error should not be * 2, numberOfMovesMade should ++
	}

	public void printNumberOfMoves() {
		System.out.println("Since I started counting, I moved:"); // prints number of moves
		System.out.println(this.numberOfMovesMade);
		System.out.println("times!");
	}

	public void leftTurnCounted() { // new method for turning left with left turn counter implimentation

		this.turnLeft();
		this.numberOfLeftTurns++; // increases the number of left turns variable each time mary does a left turn

	}

	public void printNumberOfLeftTurns() // print left turn method
	{
		System.out.println("Since I started counting, I took:");
		System.out.println(this.numberOfLeftTurns);
		System.out.println("left turn(s)!");
	}
}

public class ICE_12_Errors_2 extends Object {
	public static void main(String[] args) { // main
		City ForgetsVille = new City();
		MoveRobot mary = new MoveRobot(ForgetsVille, 4, 1, Direction.EAST, 0);
		new Wall(ForgetsVille, 2, 5, Direction.NORTH);
		// CityFrame frame = new CityFrame(ForgetsVille); Commented out, this is how
		// Becker USED TO make cities. Syntax/compile time error

		// First keep track of these 4

		mary.moveCounted();
		mary.moveCounted();  //mary moves
		mary.moveCounted();
		mary.moveCounted();
		mary.printNumberOfMoves(); // prints number of moves before mary turns left
		mary.leftTurnCounted();

		while (mary.frontIsClear()) // syntax error, no ; needed
		{
			mary.moveCounted(); // syntax error, no () was present at the end of the action
		}
		mary.printNumberOfMoves(); // syntax error, missing period after mary
		mary.printNumberOfLeftTurns(); // prints number of left turns
	}
}
