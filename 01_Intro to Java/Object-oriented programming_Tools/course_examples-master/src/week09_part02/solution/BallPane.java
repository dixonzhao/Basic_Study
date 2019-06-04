package week09_part02.solution;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

/**
 * Creates a Circle object representing a ball.
 */
class BallPane extends StackPane
{
    private Circle ball;

    public BallPane(Circle theBall)
    {
        ball = theBall;
        getChildren().add(ball);
    }

    public void moveLeft()
    {    ball.setTranslateX(ball.getTranslateX() - 10); }

    public void moveRight()
    {    ball.setTranslateX(ball.getTranslateX() + 10); }

    public void moveUp()
    {    ball.setTranslateY(ball.getTranslateY() - 10); }

    public void moveDown()
    {    ball.setTranslateY(ball.getTranslateY() + 10); }
}

