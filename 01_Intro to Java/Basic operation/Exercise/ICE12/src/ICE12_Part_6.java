import becker.robots.*;

class IceCubeBot extends Robot {

    int iceCubes;

    public IceCubeBot(City city, int st, int ave, Direction dir, int th, int ic) {
        super(city, st, ave, dir, ic); //need to equal the ic with the backpack content, or it breaks
        iceCubes = ic;
    }

    public void dispenseIce(int howManyCubes) {
        for (int i = 0; i < howManyCubes; i++) {
            if(iceCubes > 0) {
                System.out.println("Here's some ice!");
                putThing();
                iceCubes--;
            } else {
                System.out.println("Out of ice cubes");
            }
        }
    }
}

public class ICE12_Part_6 {
    public static void main(String[] args) {
        City toronto = new City();
        IceCubeBot jo = new IceCubeBot(toronto, 3, 0, Direction.EAST, 0, 10);

        jo.dispenseIce(20);
    }
}
