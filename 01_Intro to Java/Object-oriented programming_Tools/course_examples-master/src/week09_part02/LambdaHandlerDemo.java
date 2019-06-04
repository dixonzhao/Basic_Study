package week09_part02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Example demonstrates creating found handlers using lambda expressions.
 * NOTE: In IntelliJ you can disable the lambda gutter icon via:
 * File -> Preferences -> Editor -> General ->Gutter Icons
 * Then under "Common" window uncheck the icon you do not want displayed.
 * @author Liang, Introduction to Java Programming
 */
public class LambdaHandlerDemo extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Hold two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btNew = new Button("New");
        Button btOpen = new Button("Open");
        Button btSave = new Button("Save");
        Button btPrint = new Button("Print");
        hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint);

        // Create and register the handler
        btNew.setOnAction((ActionEvent e) -> {
            System.out.println("Process New");
        });

        btOpen.setOnAction((e) -> {
            System.out.println("Process Open");
        });

        btSave.setOnAction(e -> {
            System.out.println("Process Save");
        });

        btPrint.setOnAction(e -> System.out.println("Process Print"));

        // Create a scene and place it in the stage
        Scene scene = new Scene(hBox, 300, 50);
        primaryStage.setTitle("LambdaHandlerDemo"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args)
    {    launch(args); }
}