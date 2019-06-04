import java.util.Scanner;
// notice that we don't have "import becker.robots.*;" anymore

// Note that you don’t have to explicitly write that ReadConsoleChecked extends Object (java.lang.Object)
public class ReadConsoleChecked {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		int a = 0;
		boolean doneGettingA = false;
		while (!doneGettingA) {
			System.out.print("Enter an integer: ");
			if (keyboard.hasNextInt()) // Checks to see whether an int has been
										// typed in keyboard
			{
				a = keyboard.nextInt();
				keyboard.nextLine(); // newline flush to “clear the buffer”
				doneGettingA = true; // 'flag' signals leaving the while-loop
										// which is better than using 'break;'
			} else {
				String next = keyboard.nextLine(); // newline flush
				System.out.println(next + " is not an integer such as 10 or -3.");
			}
		}

		int b = 0;
		boolean doneGettingB = false;
		while (!doneGettingB) {
			System.out.print("Enter an integer: ");
			if (keyboard.hasNextInt()) {
				b = keyboard.nextInt();
				keyboard.nextLine(); // newline flush
				doneGettingB = true;
			} else {
				String next = keyboard.nextLine(); // newline flush
				System.out.println(next + " is not an integer such as 10 or -3.");
			}
		}

		System.out.println(a + " * " + b + " = " + a * b);
		keyboard.close();
	}
}
