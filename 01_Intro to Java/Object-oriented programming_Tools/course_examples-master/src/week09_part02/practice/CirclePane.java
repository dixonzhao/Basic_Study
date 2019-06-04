package week09_part02.practice;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Creates a Circle object and provides functionality to modify
 * its size.
 * @author Liang, based on Introduction to Java Programming
 */
class CirclePane extends StackPane
{
    private Circle circle = new Circle(50);

    public CirclePane()
    {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void enlarge()
    {
        System.out.println("increasing ");
        circle.setRadius(circle.getRadius() + 2);
    }

    public void shrink()
    {
        System.out.println("shrinking ");
        circle.setRadius(circle.getRadius() > 2 ?
                circle.getRadius() - 2 : circle.getRadius());
    }
}

