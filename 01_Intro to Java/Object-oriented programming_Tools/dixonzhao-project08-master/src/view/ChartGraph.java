package view;

import cellularData.DataModel;
import cellularData.GraphView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.*;


/**
 * Instantiates an JavaFX application which creates a model of the data.
 * Uses the model to instantiate an object of type  javafx.scene.chart.LineChart
 * via the GraphView class. Then sets up the scene with basic modification to
 * the stage.<br>
 * Create two seprate data set by GraphView.class and stored by two data box HBox,<br>
 * Then, create two subscenes for two dataset.<br>
 * Last, throw two subscenes into the BorderPane module and display.<br>
 * The button function based on the hide() and show() function of stage object.<br>
 * Assgined by quick assigned syntax without inner class
 *
 * @author Foothill College, Zhili Zhao
 */
public class ChartGraph extends Application
{	
	/**
	 * Called by launch method of Application
	 * Create two seprate data set by GraphView.class and stored by two data box HBox,<br>
	 * Then, create two subscenes for two dataset.<br>
	 * Last, throw two subscenes into the BorderPane module and display.<br>
	 * The button function based on the hide() and show() function of stage object.<br>
	 * Assgined by quick assigned syntax without inner class
	 * @param stage: Stage
	 */
	@Override
	public void start(Stage stage) 
	{
		// Create DataModel and 
		DataModel model = new DataModel();
		 HBox hBox = new HBox();
	        hBox.setSpacing(10);
	        hBox.setAlignment(Pos.CENTER);
	        Button DataSet1A = new Button("DataSet 1");
	        Button DataSet1B = new Button("DataSet 2");
	        hBox.getChildren().add(DataSet1A );
	        hBox.getChildren().add(DataSet1B);
	        
	        HBox hBox2 = new HBox();
	        hBox2.setSpacing(10);
	        hBox2.setAlignment(Pos.CENTER);
	        Button DataSet2A = new Button("DataSet 1");
	        Button DataSet2B = new Button("DataSet 2");
	        hBox2.getChildren().add(DataSet2A);
	        hBox2.getChildren().add(DataSet2B); 
	        

		GraphView graphView = new GraphView(model);

//Create two seprate data set by GraphView.class and stored by two data box HBox,
		graphView.update();
		SubScene subScene1 = new SubScene(graphView.getOBC(),800,800);
        graphView.update2();
        SubScene subScene2 =new SubScene(graphView.getOBC2(),800,800);
        
        hBox.getChildren().add(subScene1);
        hBox2.getChildren().add(subScene2);
        
//   hrow two subscenes into the BorderPane module and display
		  BorderPane borderPane = new BorderPane();
	      borderPane.setTop(hBox);
	      BorderPane.setAlignment(hBox, Pos.CENTER);
	        
	      BorderPane borderPane2 = new BorderPane();
	      borderPane2.setTop(hBox2);
	      BorderPane.setAlignment(hBox2, Pos.CENTER);

	        
	        
		Scene mainScene1 = new Scene(borderPane, 800, 600);
		Scene mainScene2 =new Scene(borderPane2,800,600);
		
		// Regester the button to the function, seprately 
		
		DataSet1A.setOnAction(e ->{
			stage.hide();
			stage.setScene(mainScene1);
			stage.setTitle("Data Set 1");
			stage.show();
		});

		DataSet1B.setOnAction(e ->{
		stage.hide();
		stage.setScene(mainScene2);
		stage.setTitle("Data Set 2");
		stage.show();
		});
		
		DataSet2A.setOnAction(e ->{
			stage.hide();
			stage.setScene(mainScene1);
			stage.setTitle("Data Set 1");
			stage.show();
		});
		
		DataSet2B.setOnAction(e ->{
		stage.hide();
		stage.setScene(mainScene2);
		stage.setTitle("Data Set 2");
		stage.show();
		});
		
		// Places the scene in the stage
		stage.setScene(mainScene1);

		// Set the stage title
		stage.setTitle("GraphView Test");
		
		// Display the stage
		stage.show();
	}

	/**
	 * Launches a standalone JavaFx App
	 */
	public static void main(String[] args) 
	{
		launch();
	}
	

}

