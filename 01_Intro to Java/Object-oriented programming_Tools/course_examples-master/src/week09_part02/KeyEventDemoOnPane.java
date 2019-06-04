package week09_part02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

/**
 * Example demonstrates creating a Text object and registering a KeyEvent.
 * // Note: Here, we only capture DOWN, UP, LEFT, RIGHT keys.
 * @author Liang, Introduction to Java Programming
 */
public class KeyEventDemoOnPane extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a pane and set its properties
        MyTextPane textPane = new MyTextPane();

        textPane.setOnKeyPressed(event ->
                textPane.moveText(event.getCode()));

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(textPane, 400, 300);
        primaryStage.setTitle("KeyEventDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Enables myText to receive key events.
        textPane.requestFocus();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args)
    {    launch(args); }
}

class MyTextPane extends StackPane
{
    Text myText = new Text(40, 40, "Foothill College");

    public MyTextPane()
    {
        myText.setFont(Font.font("Courier", 30));
        getChildren().add(myText);
    }

    void moveText(KeyCode key)
    {
        switch (key) {
            case DOWN:
                // The node's final translation will be computed as layoutX + translateX,
                // where layoutX establishes the node's stable position and translateX
                // optionally makes dynamic adjustments to that position.
                myText.setTranslateY(myText.getTranslateY() + 10);
                break;
            case UP:
                myText.setTranslateY(myText.getTranslateY() - 10);
                break;
            case LEFT:
                myText.setTranslateX(myText.getTranslateX() - 10);
                break;
            case RIGHT:
                myText.setTranslateX(myText.getTranslateY() + 10);
                break;
            default:
                /* do nothing */;
        }
    }
}

