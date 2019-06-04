import becker.robots.*;

class DumbBot extends Robot {
    int street;
    int avenue;

    public DumbBot(City c, int st, int ave, Direction dir, int t) {
        super(c, st, ave, dir, t);
        rememberLocation();
        printStartingLocation();
    }

    public void rememberLocation() {
        street = getStreet();
        avenue = getAvenue();
    }

    public void printStartingLocation() {
        System.out.println("This Robot was created at street #" + this.street + ", avenue #" + this.avenue);
    }
}

public class ICE12_Part_3 extends Object {
    public static void main(String[] args) {
        City toronto = new City();
        DumbBot jo = new DumbBot(toronto, 3, 0, Direction.EAST, 0);
        new Thing(toronto, 3, 2);

		/* Your code should after here: */
		jo.rememberLocation();
        jo.move();
        jo.turnLeft();
    }
}