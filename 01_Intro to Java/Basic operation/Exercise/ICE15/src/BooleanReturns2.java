import becker.robots.*;

class StreetTester2 extends Robot {
	StreetTester2(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public boolean isNorthOfStreet(int st) {
		return getStreet() < st;
	}

	public boolean isSouthOfStreet(int st1) {
		return getStreet() > st1;
	}
}

public class BooleanReturns2 extends Object {
	public static void main(String[] args) {
		City wallingford = new City();
		StreetTester2 jo = new StreetTester2(wallingford, 2, 2, Direction.NORTH, 0);

		System.out.println("Robot is North of Street 3: " + jo.isNorthOfStreet(3));
		System.out.println("Robot is South of Street 6: " + jo.isSouthOfStreet(6));

	}
}
