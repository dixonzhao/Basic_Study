import becker.robots.*;

class RechargableRobot extends Robot {
    int actions;

    public RechargableRobot(City c, int st, int ave, Direction dir, int t, int ac) {
        super(c, st, ave, dir, t);
        actions = ac;
    }

    public void recharge() {
        actions += 20;
    }

    @Override
    public synchronized void move() {
        if (actions > 0) {
            super.move();
            actions--;
        } else {
            System.out.println("Out of battery");
        }
    }

    @Override
    public synchronized void turnLeft() {
        if (actions > 0) {
            super.turnLeft();
            actions--;
        } else {
            System.out.println("Out of battery");
        }
    }

    @Override
    public void pickThing() {
        if (actions > 0) {
            super.pickThing();
            actions--;
        } else {
            System.out.println("Out of battery");
        }
    }

    @Override
    public void putThing() {
        actions--;
        if (actions >= 0) {
            super.putThing();
        } else {
            System.out.println("Out of battery");
        }
    }
}

public class ICE12_Part_5 extends Object {
    public static void main(String[] args) {
        City toronto = new City();
        RechargableRobot jo = new RechargableRobot(toronto, 3, 0, Direction.EAST, 0, 2);
        new Thing(toronto, 3, 2);

		/* Your code should after here: */
        jo.move();
        jo.move();
        jo.move();
        jo.recharge();
        jo.turnLeft();
        jo.move();
        jo.move();
    }
}