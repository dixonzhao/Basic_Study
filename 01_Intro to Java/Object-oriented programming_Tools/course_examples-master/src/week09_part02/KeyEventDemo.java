package week09_part02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Example demonstrates creating a Text object and registering a MouseEvent.
 * @author Liang, Introduction to Java Programming
 */
public class KeyEventDemo extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a pane and set its properties
        Pane pane = new Pane();
        Text myText = new Text(40, 40, "A");
        myText.setFont(Font.font("Courier", 40));

        pane.getChildren().add(myText);
        myText.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    myText.setY(myText.getY() + 10);
                    break;
                case UP:
                    myText.setY(myText.getY() - 10);
                    break;
                case LEFT:
                    myText.setX(myText.getX() - 10);
                    break;
                case RIGHT:
                    myText.setX(myText.getX() + 10);
                    break;
                default:
                    if (Character.isLetterOrDigit(e.getText().charAt(0)))
                        myText.setText(e.getText());
            }
        });

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("KeyEventDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Enables myText to receive key events.
        myText.requestFocus();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args)
    {    launch(args); }
} 

