	
// EXAMPLE: TESTING BOOLEAN EXPRESSIONS WITH RETURN VALUES, TRUE OR FALSE
/////////////////////////////////////////////////////////////////////////
import becker.robots.*;

class StreetTester1 extends Robot {
	StreetTester1(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public boolean isNorthOfStreet(int someStreet) {
		if (getStreet() < someStreet) {
			return true;
		} else {
			return false;
		}
		// HINT: You can write this method as 1 simple line (see BooleanReturns2.java)!
	}
}

public class BooleanReturns1 extends Object {
	public static void main(String[] args) {
		City wallingford = new City();
		StreetTester1 jo = new StreetTester1(wallingford, 3, 2, Direction.SOUTH, 0); // The
																						// Robot
																						// is
																						// on
																						// Street
																						// 3,
																						// Avenue
																						// 2

		int streetNum = 2;

		System.out.println("QUESTION: Is the Robot North of Street " + streetNum + "?\n");

		if (jo.isNorthOfStreet(streetNum)) {
			System.out.print("ANSWER: True. The Robot is North of Street " + streetNum + ".");
			System.out.println(" The Robot is on Street " + jo.getStreet() + ".");
		} else {
			System.out.print("ANSWER: False. The Robot is NOT North of Street " + streetNum + ".");
			System.out.println(" The Robot is on Street " + jo.getStreet() + ".");
		}
	}
}
