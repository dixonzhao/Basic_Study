//Jakob Hetland
//Aishwar Gupta
//Anubhav Bhattarai
//Jannes Huehnerbein

// CS1A - Assignment 3 - "The Maze"
////////////////////////////////////////////////////////////////////////////////

import becker.robots.*;


public class Maze extends Object {
    private static void makeMaze(City theCity) {
        for (int i = 1; i < 11; i++) {
            // north wall
            new Wall(theCity, 1, i, Direction.NORTH);

            // Second to north wall
            if (i <= 9)
                new Wall(theCity, 1, i, Direction.SOUTH);

            // Third to north wall
            if (i >= 4)
                new Wall(theCity, 4, i, Direction.SOUTH);

            // south wall
            if (i != 9) // (9, 10, SOUTH), is where the 'exit' is
                new Wall(theCity, 10, i, Direction.SOUTH);

            // west wall
            if (i != 1) // (1,1, WEST) is where the 'entrance' is
                new Wall(theCity, i, 1, Direction.WEST);

            // second to west-most wall
            if (i >= 3 && i < 6)
                new Wall(theCity, i, 6, Direction.WEST);

            // east wall
            new Wall(theCity, i, 10, Direction.EAST);
        }

        // cul-de-sac
        new Wall(theCity, 3, 10, Direction.WEST);
        new Wall(theCity, 3, 10, Direction.SOUTH);

        new Wall(theCity, 2, 8, Direction.WEST);
        new Wall(theCity, 2, 8, Direction.SOUTH);

        new Wall(theCity, 10, 8, Direction.NORTH);
        new Wall(theCity, 10, 9, Direction.EAST);
        new Wall(theCity, 10, 9, Direction.NORTH);
        makeSpiral(theCity, 8, 9, 3);
        new Wall(theCity, 8, 10, Direction.SOUTH);

        makeSpiral(theCity, 10, 5, 4);
    }

    public static void makeSpiral(City theCity, int st, int ave, int size) {
        // We start out building the wall northward
        // the walls will be built on the east face of the current
        // intersection
        Direction facing = Direction.EAST;

        while (size > 0) {
            int spacesLeft = size;
            int aveChange = 0;
            int stChange = 0;
            switch (facing) {
                case EAST:
                    stChange = -1;
                    break;
                case NORTH:
                    aveChange = -1;
                    break;
                case WEST:
                    stChange = 1;
                    break;
                case SOUTH:
                    aveChange = 1;
                    break;
            }

            while (spacesLeft > 0) {
                new Wall(theCity, st, ave, facing);
                ave += aveChange;
                st += stChange;
                --spacesLeft;
            }
            // back up one space
            ave -= aveChange;
            st -= stChange;

            switch (facing) {
                case EAST:
                    facing = Direction.NORTH;
                    break;
                case NORTH:
                    facing = Direction.WEST;
                    size--;
                    break;
                case WEST:
                    facing = Direction.SOUTH;
                    break;
                case SOUTH:
                    facing = Direction.EAST;
                    size--;
                    break;
            }
        }
    }

    // ###########################################################################################
    // Main Method
    // ###########################################################################################
    public static void main(String[] args) {
        City calgary = new City(12, 12);
        Mazebot don = new Mazebot(calgary, 1, 1, Direction.EAST, 10000); // <-- YOU


        Maze.makeMaze(calgary);

        don.navigateMaze(10, 9);


    }
}