package week09_part02;

/**
 * Demonstrate using inner classes.
 */
public class OuterClass
{
    private int data;

    /**
     * A method in the outer class
     */
    public void someMethod()
    {
        // Do something
        InnerClass instance = new InnerClass();
    }

    // An inner class
    class InnerClass
    {
        /**
         * A method in the inner class
         */
        public void someInnerMethod()
        {
            // Directly reference data and method defined in its outer class
            data++;
            someMethod();
        }
    }
}