package week09_part02.practice;

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
    {
        // TODO: translate the ball's X axis by 10 pixes left
    }

    public void moveRight()
    {
        // TODO: translate the ball's X axis by 10 pixes right
    }

    public void moveUp()
    {
        // TODO: translate the ball's Y axis by 10 pixes up
    }

    public void moveDown()
    {
        // TODO: translate the ball's Y axis by 10 pixes down
    }
}

