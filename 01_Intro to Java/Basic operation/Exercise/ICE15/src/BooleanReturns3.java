import becker.robots.*;

class StreetTester3 extends Robot {
	StreetTester3(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public boolean isInBetweenStreets(int st1, int st2) {
		return getStreet() > st1 && getStreet() < st2; // Change && to
														// 'or' || to
														// change the
														// logic
	}
}

public class BooleanReturns3 extends Object {
	public static void main(String[] args) {
		int street1 = 1;
		int street2 = 3;

		City wallingford = new City();
		StreetTester3 jo = new StreetTester3(wallingford, 2, 2, Direction.NORTH, 0);

		System.out.println("Robot is in between Streets " + street1 + " and " + street2 + ": "
				+ jo.isInBetweenStreets(street1, street2));

	}
}
