package cellularData;

/**
 *  Tests the CellularData class by reading in one dimensional arrays of countries.
 *  Given a country name and a range of years, computes the total number of subscriptions
 *  during that period.
 *
 *  @author Foothill College, Bita M, Zhili Zhao
 */


/**
 * show instruction class. 
 * <p>show data, country name, year name was store in three different array<br>
 * show has tostring() and getNumSubscriptionsInCountryForPeriod methods for users <br>
 * show create countC to count the number of add country and for other function behind
 */
public class CellularData
{
    double table[][];
    String name[] ;
    int year[];
    int countC=0;
    int rowNum;
    int colNum;
    int startNum;
    /**
     * show default constructor
     * <p>show in case user miss input data<br>
     * show  warning and exit program when no data input<br>
     * 
     */
    CellularData(){
       System.out.println("Warning: No data input, automatically stop");
   }

    /**
     * show primary constructor. 
     * <p>show input table(2D), name(country), year array , <br>
     *  show input row, column, start year<br>
     * show initialize year[] with years [start, end] <br>
     * show create table only define 1D, other one wait for input
     * @param rowNum true
     * @param colNum true
     * @param startNum true
     * @param table true
     * @param name true
     */
   CellularData(int rowNum, int colNum, int startNum){
        this.rowNum=rowNum;
        this.colNum=colNum;
        this.startNum=startNum;
	   
	   table = new double[rowNum][];
        name= new String[rowNum];
        year= new int[colNum];
        
        for (int i =0; i<colNum;i++){
            year[i]=startNum+i;
        }

   }

   /**
    * show Add country into table[]][]. 
    * <p>show the input array direct input to the table[i][]<br>
    * show the name of country input into name[], also check if array full<br>
    * show 
    */
   public void addCountry(String cName, double[] ins){
	   
	   if(countC<rowNum) {
	   table[countC]= ins;
	   name[countC]= cName;
	   countC++;
	   } else {
		   System.out.println("Warning: Maxium input Country from"
		   		+ " the input country number. ");
	   }
	   
   }

   /**
    * show print the table in an specific format
    * <p>show three String variable, firstRow build for country year<br>
    * show outP store the output, the middleRow create to store the data<br>
    * show use printf and String.format to limited the format of table
    * @param firstRow true
    * @param outP true
    * @param middleRow true
    */
   public String toString() {
	   
	   String firstRow="Country	Year          "; 
	   String outP=null;
	   String middleRow= null;
//	   Output the year
	   for (int j = startNum; j < colNum+startNum; j++) {  
				   firstRow+=j+ "        ";  
				}  
	   outP=firstRow;
//	   Output the country name + country data
	   for (int i = 0; i < rowNum; i++) { 
		   
		   middleRow="";
		   
		   for (int j = 0; j < colNum; j++) {  
			   middleRow+=String.format("%8s", String.format("%.2f", table[i][j]))+"   ";
			}
		   outP+="\n" +String.format("%-16s", name[i]) +"         "+middleRow; 
		}
	   
	return outP;
	   
   }

   /**
    * show get total sum for assigned [start,end]year of a specific country . 
    * <p>show 1. determine if this country can be find in name[]<br>
    * show 2. if yes, confirm the start, end date inside the avaliable range <br>
    * show 3-1. if  NO, set year into maxium avaliable year <br>
    * show 3-2. if YES, use for to get sum <br>
    * show dest
    * @param locatC true
    * for determine if invalid country
    * @param dest true
    * used for store start, end date incase false use.
    * @param deen true
    * used for store start, end date incase false use.
    * @param startY false
    * modify for use
    * @param endY false
    * modify for use
    * @param totalN true
    * output 
    */
public double getNumSubscriptionsInCountryForPeriod(String cName, int stY, int enY) {
	   int locatC=-1, dest=stY, deen=enY,startY=startNum,endY=startNum+colNum;
	   double totalN= -1;
	   for(int i=0; i< rowNum; i++) {
		   if(name[i].equals(cName)){
			   locatC=i;
			   break;
		   } 
	   }
	   
	   if(locatC==-1) {
		   System.out.println("Invalid country, sorry.");
	   } else {
		   if(stY<startNum) {
			   stY=startNum;
			   System.out.println("Warning: out of range of start year "
			   		+ "has been set to default start year: "+ startY);
		   }
		   if(enY>=startNum+colNum) {
			   enY=startNum+colNum-1;
			   System.out.println("Warning: out of range of end year "
				   		+ "has been set to default end year: "+ (endY-1));
		   }
		   
		   totalN=this.calF(stY,enY,table[locatC]);
		   this.prinTA(cName, totalN, dest, deen);
		   return totalN;
	   }
	   return totalN;
   }
   
/**
 * show Print function of get sum method. 
 * <p>show set private for not reach by users<br>
 * show output directly<br>
 * show 
 * @param name true
 * name of country 
 * @param ans true
 * answer 
 * @param start true
 * start date of output
 * @param end true
 * end date of output
 * 
 */
   private void prinTA(String name, double ans, int start , int end) {

	   
	   System.out.printf(
	   		 "Country is " +name +" , subscriptions from " +start+ " to " +end+ 
	   		"		\n The output is:" 
//			+  "		\n"+name +" (" +start +" to "+ end+ "): %.2f" , ans 
	   );
	   System.out.println();
	   
   }
   
   /**
    * show calculate the sum. 
    * <p>show for loop to get sum<br>
    */
   private double calF(int start, int end, double[] cou) {
	   double ans=0;
	   int times;
	   times=end-start;
	   times++;
	   start-=startNum;
	   end-=startNum;
	   for(int i=0;i<times;i++) {
		   ans+=cou[i+start];
	   }
	   return ans;
   }

}
