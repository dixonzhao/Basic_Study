TestCopyCountryList.java
	- test files 
	- Six test block 
		1. Test for initialize
		2. Test for copy inside the Linked list 
		3. Test of modify the name to affect original list 
		4. Test of modify the Subscriptions to affect original list 
		5. Test of modify the Country object  to affect original list 
					-1. random country 
					-2. just test( a country newly generated)
		6. Second test of the everyting by changing the input data 
						
						
CountryList.java
	- Use to create/control linkedlist about country
	-Functions 
		- add the Country object to the end of the list 
		- get country of selected index
		- search if contains country and return
		-  print all country in the list
		- return size of list 
		- deep copy the country it self
		- replace assigned position list object 

CountryNode.java
	- Use to create/control basic element of Linkedlist CountryList
	-Functions 
		- initialize with name or name+next pointer
		- getter of Next pointer and Country object
		- Setter of next pointer 
		- deep Copy the country object inside the CountryNode

		
Country.java
	- store Country data and able to return sum of given range subscription 
	- Functions 
		- Add subscription year into array inside to store
		- return sum of subscription of given range of year
		- toString to return the name + all subscription data of one country 
		- equals() override to test only the Country name
		- return a deep copy of the subscription array 

SubscriptionYear.java
	- store single subscription & year  
	- Function 
		- Getter /Setter of year & subscription
		- toString to return the subscription 
		
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