package week09_part01.practice;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Demonstrates bidrectional binding of values.
 * @author Liang, based on Introduction to Java Programming
 */
public class BindingExample
{
    public static void main(String[] args)
    {
        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);
        d1.bind(d2);
        System.out.println("d1 is " + d1.getValue()
                + " and d2 is " + d2.getValue());

        // QUESTION: What happens when we set the value of d1?
        d1.setValue(50.1);
        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());


        // QUESTION: What happens when we set the value of d2?
        d2.setValue(70.2);
        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
    }
}