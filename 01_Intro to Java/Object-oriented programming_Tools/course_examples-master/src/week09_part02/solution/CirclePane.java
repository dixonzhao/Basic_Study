package week09_part02.solution;

import javafx.beans.property.DoubleProperty;
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
    DoubleProperty startCenterX;

    public CirclePane()
    {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        circle.setCenterX(50);
        circle.setCenterX(50);
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

    public void moveLeft()
    {    circle.setTranslateX(circle.getTranslateX() - 10); }

    public void moveRight()
    {    circle.setTranslateX(circle.getTranslateX() + 10); }

    public void moveUp()
    {    circle.setTranslateY(circle.getTranslateY() - 10); }

    public void moveDown()
    {    circle.setTranslateY(circle.getTranslateY() + 10); }
}

