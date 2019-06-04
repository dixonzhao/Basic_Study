package week09_part02;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Example demonstrates observing and handling a change in an object of
 * type DoubleProperty.
 * @author Liang, based on Introduction to Java Programming
 */
public class ObservablePropertyDemo
{
    public static void main(String[] args)
    {
        DoubleProperty balance = new SimpleDoubleProperty();
        balance.addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                System.out.println("The new value is " +
                        balance.doubleValue());
            }
        });

        DoubleProperty requiredPayment = new SimpleDoubleProperty(0);
        requiredPayment.bindBidirectional(balance);

        balance.set(4.5);
        requiredPayment.setValue(100);
    }
}
