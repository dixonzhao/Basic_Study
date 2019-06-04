package cellularData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

/**
 *  Generate series and chart data of the input data 
 *  used for 2 dataset 
 * @author Foothill College, Zhili Zhao
 * @param DataModel datamodel
    * input the datamodel
 */

public class GraphView {
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private Country [] countries;
    private LinkedList<SubscriptionYear> subscriptions;
    private LineChart lineC;
    private LineChart chart;
    private ObservableList<XYChart.Series<Number,Number>> lineChartData;
    private ObservableList<XYChart.Series<Number,Number>> lineChartData2;
    
	/**
     * Consucture new Graph view class and initialize the variables and input data
     * <p>show input data model <br>
     * initiazlize the variables 
     * 
     */
	public GraphView(DataModel model) {
		// TODO Auto-generated constructor stub
		countries=model.getCellularData();
		xAxis = new NumberAxis();
	    yAxis = new NumberAxis();
	    xAxis.setLabel("Year of subscription");
	    yAxis.setLabel("subscriptions per 100 people");
		 lineC=new LineChart<Number,Number>(xAxis,yAxis);
		 lineC.setTitle("Selected Data Set");
		 
		 lineChartData= FXCollections.observableArrayList();
		 lineChartData2= FXCollections.observableArrayList();
	}
	

	
	/**
     * Return the linchart C that is used for test, not for use
     * 
     * 
     */
	public LineChart getLineC() {
		return lineC;
	}

	
	/**
	 * Return linechart for the first dataset, 
	 * @return 
	 */
	public LineChart getOBC() {
		subscriptions=countries[0].getSubscriptions();
		int xLowerB=subscriptions.getIndex(0).getYear();
		int xUpperB=subscriptions.getIndex(subscriptions.size()-1).getYear();
	     xAxis = new NumberAxis("Year", xLowerB, xUpperB, 1);
	     yAxis = new NumberAxis();
	     yAxis.setLabel("Numbers of subscriptions");
		return new LineChart(xAxis, yAxis, lineChartData);
	}

	/**
     * construct the full dataset 1
     * 
     */
	public void update() {
		for(int i=0 ;i<countries.length;i++) {
			XYChart.Series series=seriesFromCountry(countries[i]);
			lineC.getData().add(series);
			lineChartData.add(series);
		}
	}
	
	
	/**
	 * Return linechart for the Second dataset, 
	 * @return 
	 */
	public LineChart getOBC2() {
		subscriptions=countries[0].getSubscriptions();
		int xLowerB=subscriptions.getIndex(0).getYear();
		int xUpperB=subscriptions.getIndex(subscriptions.size()-1).getYear();
	     xAxis = new NumberAxis("Year", xLowerB, xUpperB, 1);
	     yAxis = new NumberAxis();
	     yAxis.setLabel("Numbers of subscriptions");
		return new LineChart(xAxis, yAxis, lineChartData2);
	}
	
	/**
     * construct the full dataset 2 based on half of series,<br>
     * since assignment didn't required new set, but can be modified in this method 
     * 
     */
	public void update2() {
		for(int i=0 ;i<countries.length/2;i++) {
			XYChart.Series series=seriesFromCountry(countries[i]);
			lineChartData2.add(series);
		}
	}
	
	/**
     * Takes a Country object as parameter and returns a Series<Number, Number> object. 
     * <p>series based on the SubscriptionYear information of the current country.  <br>
     * Set the name of the series to the name of the country
     * 
     */
	public Series<Number,Number> seriesFromCountry(Country cou) {
		XYChart.Series series = new XYChart.Series();
		series.setName(cou.getName());
		subscriptions=cou.getSubscriptions();
		for(int i=0;i<subscriptions.size();i++) {
			series.getData().add(
					new XYChart.Data(subscriptions.getIndex(i).getYear(), subscriptions.getIndex(i).getSubscription()));
		}
	
		return series;
	
	}
	

}
