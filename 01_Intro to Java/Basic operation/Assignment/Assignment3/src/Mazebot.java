import becker.robots.*;


public class Mazebot extends RobotSE{
    private int steps = 0, movesWest = 0, movesEast = 0, movesSouth = 0, movesNorth = 0;

    public Mazebot(City theCity, int str, int ave, Direction dir, int numThings) {
        super(theCity, str, ave, dir, numThings);
    }
    //Getters for private member variables.
    public int getMovesNorth() {
        return movesNorth;
    }

    public int getMovesWest() {
        return movesWest;
    }

    public int getMovesEast() {
        return movesEast;
    }

    public int getMovesSouth() {
        return movesSouth;
    }

    public int getSteps() {
        return steps;
    }

    /**
     * Moves the robot one intersection.
     * also tallies total steps and also steps in each direction.
     * Stores the data in the int variables: steps, movesWest, movesEast, movesSouth, and movesNorth.
     * All these variables have getters.
     */
    public void move() {
        super.move();
        steps++;
        Direction d = getDirection();
        switch (d){
            case EAST:
                movesEast ++;
                break;
            case WEST:
                movesWest++;
                break;
            case NORTH:
                movesNorth++;
                break;
            case SOUTH:
                movesSouth++;
                break;
        }

    }


    /**
     * Prints total moves.
     */
    public void printTotalNumberOfSpacesMoved()// Or printEverything(),
    {
        System.out.printf("The robot has moved %d spaces\n", getSteps());
    }

    /**
     * Checks if robot is at end spot.
     * @param s Street
     * @param a Avenue
     * @return
     */
    private boolean isAtEndSpot(int s, int a) {
        return getAvenue() == a && getStreet() == s;
    }

    /**
     * While it is not at end spot.
     * Moves along the left wall until it reaches street: s and avenue: a.
     * First checks if it it is possible to move to the left.
     * If that is not possible it checks straight forward.
     * If that is not possible it checks right.
     * If non of these don't work it turns around.
     * @param s End street
     * @param a End Avenue
     */
    public void navigateMaze(int s, int a) {
        while (!isAtEndSpot(s, a)) {
            putThingsSafe();
            turnLeft();
            if (frontIsClear()) {
                this.move();
            } else {
                turnRight();
                if (frontIsClear()) {
                    this.move();
                } else {
                    turnRight();
                    if (frontIsClear()) {
                        this.move();
                    } else {
                        turnRight();
                        if (frontIsClear()) {
                            this.move();
                        } else {
                            turnRight();
                            this.move();
                        }
                    }

                }
            }
        }
        System.out.printf("Spaces moved: %d\nWest: %d\nEast: %d\nNorth: %d\nSouth: %d\n", getSteps(), getMovesWest()
                , getMovesEast(), getMovesNorth(), getMovesSouth());
    }

    /**
     * If there is content in backpack and the intersection is empty it puts thing
     */
    public void putThingsSafe() {
        if (countThingsInBackpack() > 0 && !canPickThing()) {
            putThing();
        }
    }

}
