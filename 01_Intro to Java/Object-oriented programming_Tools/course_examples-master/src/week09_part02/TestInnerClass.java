package week09_part02;

/**
 * Tests creating objects of an inner class.
 */
public class TestInnerClass
{

    public static void main(String [] args)
    {
        OuterClass oc = new OuterClass();
        oc.someMethod();

        OuterClass.InnerClass ic = new OuterClass.InnerClass();
        ic.someInnerMethod();

        OuterClass.InnerClass ic2 = new InnerClass();

        OuterClass.InnerClass ic3 = oc.new InnerClass();

    }
}
