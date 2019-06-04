package week09_part02;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Example demonstrates resizing a Circle shape object via
 * MouseEvent and KeyEvent handlers.
 * @author Liang, Introduction to Java Programming
 */
public class ControlCircleWithMouseAndKey extends Application
{
    private CirclePane circlePane = new CirclePane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Hold two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);

        // Create and register the handler
        btEnlarge.setOnAction(e -> circlePane.enlarge());
        btShrink.setOnAction(e -> circlePane.shrink());

        // H
        circlePane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY)
            {    circlePane.enlarge(); }
            else if (e.getButton() == MouseButton.SECONDARY)
            {    circlePane.shrink(); }
        });

        // Note: Specifies that this node should be part of a focus traversal cycle.
        //       Focus is moved to this Node and from this Node using regular focus traversal keys.
        // Question: Do we need requestFocus() after commenting in the line below?
        // circlePane.setFocusTraversable(true);

        circlePane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.U)
            {    circlePane.enlarge(); }
            else if (e.getCode() == KeyCode.D)
            {    circlePane.shrink(); }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 400, 350);
        primaryStage.setTitle("ControlCircle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Try using your mouse or keys to resize the circle.
        // Then, click on one of the buttons to resize the circle.
        // Now, use your mouse or keys to resize the circle.
        // QUESTION: What happens?
        circlePane.requestFocus();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args)
    {    launch(args); }
}
