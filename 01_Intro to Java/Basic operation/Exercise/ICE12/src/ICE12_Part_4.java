import becker.robots.*;

class SecondDumbBot extends Robot {
    int startingStreet;
    int startingAvenue;

    public SecondDumbBot(City c, int st, int ave, Direction dir, int t) {
        super(c, st, ave, dir, t);
        startingStreet = st;
        startingAvenue = ave;
        printStartingLocation();
    }

    public void printStartingLocation() {
        System.out.println("This Robot was created at street #" + this.startingStreet + ", avenue #" + this.startingAvenue);
    }

    public void printDistanceMoved() {
        int streetMoved = getStreet() - startingStreet;
        int avenueMoved = getAvenue() - startingAvenue;
        String streetMovedDirection = streetMoved > 0 ? "south" : "north";
        String avenueMovedDirection = avenueMoved > 0 ? "east" : "west";
        streetMoved = streetMoved > 0 ? streetMoved : -streetMoved;
        avenueMoved = avenueMoved > 0 ? avenueMoved : -avenueMoved;
        System.out.println("This Robot has moved:");
        System.out.println(streetMoved + " streets " + streetMovedDirection);
        System.out.println(avenueMoved + " avenues " + avenueMovedDirection);
    }
}

public class ICE12_Part_4 extends Object {
    public static void main(String[] args) {
        City toronto = new City();
        SecondDumbBot jo = new SecondDumbBot(toronto, 3, 0, Direction.EAST, 0);
        new Thing(toronto, 3, 2);

		/* Your code should after here: */
        jo.move();
        jo.move();
        jo.move();
        jo.turnLeft();
        jo.move();
        jo.move();

        jo.printDistanceMoved();
    }
}