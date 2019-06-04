package week09_part02.solution;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveBall extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        final Circle ball = new Circle(100, 100, 25);

        // Use radial gradient to make shapes appear three-dimensional.
        // Gradient paint can interpolate between two or more colors, which gives depth to the shape.
        // See http://www.java2s.com/Tutorials/Java/JavaFX/0110__JavaFX_Gradient_Color.htm
        //Setting the radial gradient
        RadialGradient radialGradient = new RadialGradient(0,
                .1,
                100,
                100,
                20,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.LIGHTBLUE),
                new Stop(1, Color.BLUE));

        ball.setFill(radialGradient);
        BallPane ballPane = new BallPane(ball);

        // Hold two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        hBox.getChildren().add(btLeft);
        hBox.getChildren().add(btRight);
        hBox.getChildren().add(btUp);
        hBox.getChildren().add(btDown);

        // Uses lambda expression to create and register the handler
        btLeft.setOnAction(event -> ballPane.moveLeft());
        btRight.setOnAction(event -> ballPane.moveRight());
        btUp.setOnAction(event -> ballPane.moveUp());
        btDown.setOnAction(event -> ballPane.moveDown());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(ballPane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 400, 350);
        primaryStage.setTitle("Move Ball"); // Set the stage title
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


