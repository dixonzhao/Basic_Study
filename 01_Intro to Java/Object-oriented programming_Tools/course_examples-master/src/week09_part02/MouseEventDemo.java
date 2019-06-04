package week09_part02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Example demonstrates creating a Text object and registering a MouseEvent.
 *
 * @author Liang, Introduction to Java Programming
 */
public class MouseEventDemo extends Application
{
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage)
  {
    // Create a pane and set its properties
    Pane pane = new Pane();
    Text text = new Text(50, 50, "Programming is fun");
    text.setFont(Font.font("Courier", 40));
    pane.getChildren().addAll(text);
    text.setOnMouseDragged(e -> {       
      text.setX(e.getX());
      text.setY(e.getY());
    });
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 700, 400);
    primaryStage.setTitle("MouseEventDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args)
  {  launch(args); }
} 

