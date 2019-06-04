package subsetsum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GroceriesFileReader {

    /**
     * Split the data from the csv file
     *
     * @param filepath which is the data required to proceed
     * @return List of all possible arrays.
     * @author Foothill College, Zhili Zhao
     * <p>
     * Split the CSV files with "," and export the data only with numbers <br>
     * The number is for the first type of csv which the numbers are in the end of the line<br>
     * catch expection with the printed trace for view and track
     */
    public ArrayList readFile(String filepath) {

        ArrayList<Double> priceOfGroceries = new ArrayList<Double>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            //reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");
                String last = item[item.length - 1];
                double value = Double.parseDouble(last);
                priceOfGroceries.add(value);
            }
            return priceOfGroceries;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList(0);
    }

}
