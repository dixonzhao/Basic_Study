package week09_part01;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Demonstrates bidrectional binding of values.
 * @author Liang, based on Introduction to Java Programming
 */
public class BidirectionalBindingDemo
{
    public static void main(String[] args)
    {
        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);
        d1.bindBidirectional(d2);
        System.out.println("d1 is " + d1.getValue()
                + " and d2 is " + d2.getValue());
        d1.setValue(50.1);
        System.out.println("d1 is " + d1.getValue()
                + " and d2 is " + d2.getValue());
        d2.setValue(70.2);
        System.out.println("d1 is " + d1.getValue()
                + " and d2 is " + d2.getValue());
    }
}