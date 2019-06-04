package week09_part01;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Example demonstrates dynamic binding.
 * @author Liang, based on Introduction to Java Programming
 */
public class BindingDemo
{
    public static void main(String[] args)
    {
        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);

        // The bind() method enables the target object d1 to be bound to a
        // source object d2. If the value in the d2 changes, d1 changes.
        d1.bind(d2);

        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
        d2.setValue(70.2);
        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
    }
}