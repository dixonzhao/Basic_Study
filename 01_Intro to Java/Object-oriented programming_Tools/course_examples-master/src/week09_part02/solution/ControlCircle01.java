package week09_part02.solution;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControlCircle01 extends Application
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
        btEnlarge.setOnAction(new EnlargeHandler());
        btShrink.setOnAction(new ShrinkHandler());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("Control Circle with EventHandler classes"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    class EnlargeHandler implements EventHandler<ActionEvent>
    {
        @Override // Override the handle method
        public void handle(ActionEvent e)
        {    circlePane.enlarge(); }
    }

    class ShrinkHandler implements EventHandler<ActionEvent>
    {
        @Override // Override the handle method
        public void handle(ActionEvent e)
        {    circlePane.shrink(); }
    }
}


