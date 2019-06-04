package week09_part01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Example demonstrates a border pane. Places five buttons in five regions
 * of the pane.
 * @author Liang, Introduction to Java Programming
 */
public class ShowBorderPane extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a border pane
        BorderPane pane = new BorderPane();

        // Place nodes in the pane
        pane.setTop(new CustomPane("Top"));
        pane.setRight(new CustomPaneBlue("Right"));
        pane.setBottom(new CustomPane("Bottom"));
        pane.setLeft(new CustomPaneBlue("Left"));
        pane.setCenter(new CustomPaneGrey("Center"));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowBorderPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

// Define a custom pane to hold a label in the center of the pane
class CustomPane extends StackPane {
    public CustomPane(String title) {
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: red");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}

// TODO: Define the inner class CustomPaneBlue to be similar to CustomPane
//       with a blue border.
// Define a custom pane to hold a label in the center of the pane
class CustomPaneBlue extends StackPane
{
    public CustomPaneBlue(String title)
    {
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: blue");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}

// TODO: Define the inner class CustomPaneGrey to be similar to CustomPane
//       with a grey border.
// Define a custom pane to hold a label in the center of the pane
class CustomPaneGrey extends StackPane
{
    public CustomPaneGrey(String title)
    {
        getChildren().add(new Label(title));
        setStyle("-fx-background-color: grey");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}
