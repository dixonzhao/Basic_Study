package week09_part01.solution;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Example that creates a button, sets its style, adds it to a pane and
 * rotates the button.
 * @author Liang, based on Introduction to Java Programming
 */
public class NodeStyleRotateButton extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place a button in the scene
        StackPane pane = new StackPane();
        Button btOK = new Button("OK");
        btOK.setStyle("-fx-border-color: blue;");
        pane.getChildren().add(btOK);

        // TODO: Modify the propierties of the button by:
        // - rotating the button by 45 degrees and
        // - setting the color to one of your choice
        // - increasing the font size
        btOK.setRotate(45);
        btOK.setStyle(
                "-fx-text-fill: blueviolet; -fx-font-size: 200%");

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("NodeStyleRotateDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
