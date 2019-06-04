package week09_part01.solution;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


/**
 * Creates a LineChart for Foothill College enrollment history.
 * @author Foothill College, Bita M.
 */
public class ChartEnrollmentHistory extends Application
{
    @Override
    public void start(Stage stage)
    {
        FoothillCollege fc = new FoothillCollege();
        stage.setTitle("Enrollment History");

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year");
        xAxis.setForceZeroInRange(false);
        yAxis.setLabel("Enrollment Count");

        //creating the chart
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Foothill College Enrollment History");
        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Foothill College");
        //populating the series with data

        for(FoothillCollege.EnrollmentYear e : fc.getEnrollmentHistory())
        {
            XYChart.Data currentData = new XYChart.Data(e.getYear(), e.getEnrollment());
            series.getData().add(currentData);
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}