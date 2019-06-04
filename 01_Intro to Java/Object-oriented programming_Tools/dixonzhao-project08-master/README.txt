Package view


ChartGraph.java
	- nstantiates an JavaFX application which creates a model of the data.
	-Uses the model to instantiate an object of type  javafx.scene.chart.LineChart
	-via the GraphView class. Then sets up the scene with basic modification to the stage
	-Implements Extra Credit Opportunity 2
	-Specific Steps
		1. Create two seprate data set by GraphView.class and stored by two data box HBox,
		2. Then, create two subscenes for two dataset.
		3. Last, throw two subscenes into the BorderPane module and display.
		4. The button function based on the hide() and show() function of stage object.
		5. Assgined by quick assigned syntax without inner class
		6. Using JavaFX generate GUI
	-Result 
		- Representate of two data sets that can switch the data by click button without regenerating data
		-Screen shot in "resources" : RUN-1.png, RUN-2.png, RUN-3.png


CountrySelector.java 
	- Builds a linked list of random countries
	

----------------------------------------------------------------------------------------------------------------------------------
Package cellularData

DataModel.java
 	-Provides access to CSV data.
 	
 	
GraphView.java
	-Consucture new Graph view class and initialize the variables and input data
	-Generate two set of chart data for use in the ChartGraph
		-Functions
			- GraphView(DataModel model) 
			- LineChart getLineC() 
			- LineChart getOBC() 
			- LineChart getOBC2() 
			- void update()
			- void update2()
			- Series<Number,Number> seriesFromCountry(Country cou) 
					
LinkedList.java
	- Use to create/control linkedlist by generic 
	-Functions 
		- A collection of generic Node objects.
		- A constructor that creates an empty LinkedList object.
		- A method add() that takes a generic object as parameter and adds that new object to the end of the list.
		- A method contains that takes a generic object as parameter and checks if the object can be found in the linked list.
		- A method toString() which returns a string containing information about every country in the list.
		- A method iterator() that returns object of type ListIterator.

Node.java
	- Use to create/control basic element of Linkedlist  by generic
	-Functions 
		- A constructor that takes in a generic object as a parameter. 
		- A constructor that takes in two parameters, a generic object and an object of parametrized Node type.
		- Getter methods for all attributes.
		- A setter method for the attribute next.
		- A toString method that returns the string representation of data. 

		
Country.java
	- store Country data and able to return sum of given range subscription 
	- Functions 
		- Add subscription year into array inside to store
		- return sum of subscription of given range of year
		- toString to return the name + all subscription data of one country 
			- modify with iterator()
		- equals() override to test only the Country name
		- return a deep copy of the subscription array 

SubscriptionYear.java
	- store single subscription & year  
	- Function 
		- Getter /Setter of year & subscription
		- toString to return the subscription 
		-equals() override for linkedlist compare the subscription 
		
CellularData.java
	- same as the Assignment 02
	Store given country's data with year. Has function:  
		1. print the full table in a given format 
		2. give sum of assign country in assigned time zone.
	
CSVReader.java
	-main files 
	- the purpose is to complete the function while using the CellularData.java and without change it 
			- In constructor method split the data and put it into a temporary CellularData object and use that to process data
			- Except the required function, all method and variables are been set to private 
			- avoid to use the extend for the purpose of built a unit instead of chain.
	- The functions will be 
		- returns String arrays countryNames
		- returns int arrays yearLabels
		- returns 2D double arrays cellularDataTable 