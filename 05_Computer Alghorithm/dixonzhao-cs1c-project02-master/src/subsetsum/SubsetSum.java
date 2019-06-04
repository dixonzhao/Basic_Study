package subsetsum;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * * /**
 * *  *  Proceed the csv data for selection by using recursion
 * *  *
 * *  * @author Foothill College, Zhili Zhao
 * *  *
 * *  * <p>First is to input the data to initialize with the static variable in findSubset<br>
 * *  * then send to the list generater to generate every possible combination for use<br>
 * *      last is to compare to data with the store of cloest data while if complete match just break
 * param recurisionArra
 * store the every combinition of data
 */

public class SubsetSum {


    static ArrayList<Double[]> recurisionArray = new ArrayList<Double[]>();

    /**
     * generate best result<p>
     * use generateList() to set up list library and use calculateList() to calculate best result
     * </p.>
     *
     * @param array
     * @param budget
     * @return ArrayList for use
     */
    public static ArrayList findSubset(@NotNull ArrayList<Double> array, Double budget) {
        Stack<Double> stac = new Stack<Double>();
        double testForFast = 0;
        for (double tes : array) {
            testForFast += tes;
        }

        Iterator<Double> it = array.iterator();
        while (it.hasNext()) {
            stac.push(it.next());
        }


        if (testForFast >= budget) {
            generateList(array, budget, array.size());


            return calculateList(budget);
        } else {
            return array;
        }


    }

    /**
     * use recursion to find every match to deploy the library array recursionArray.
     *
     * @param arrCount
     * @param budget
     * @param countNum
     */
    private static void generateList(@NotNull ArrayList<Double> arrCount, Double budget, int countNum) {
        //initialize the peremeter
        Stack<Double> tempStac = new Stack<Double>();
        ArrayList<Double> tempArray = new ArrayList<Double>();
        Stack<Double> stackCou = new Stack<Double>();
        Double[] inp = new Double[countNum];
        double temporyNum;


        Iterator<Double> it = arrCount.iterator();
        while (it.hasNext()) {
            stackCou.push(it.next());
        }
        //start out put

        //first we output the list to the total list,
        // second we put a new stack with select number been dropped (while i==j)
        if (stackCou.size() > 1) {
            for (int i = 0; i < countNum; i++) {
                tempArray = new ArrayList<Double>();

                if (stackCou.size() == 0) {
                    for (double num : arrCount) {
                        stackCou.push(num);
                    }
                }

                for (int j = 0; j < countNum; ) {
                    temporyNum = stackCou.pop();
                    if (j != i)
                        tempArray.add(temporyNum);
                    inp[j] = temporyNum;
                    j++;
                }


                recurisionArray.add(inp);

                generateList(tempArray, budget, countNum - 1);
            }
        } else {
            inp[0] = stackCou.pop();

            recurisionArray.add(inp);
        }
    }

    /**
     * Use the library to find the closet result of data.
     *
     * @param budget
     * @return
     */
    private static ArrayList<Double> calculateList(Double budget) {

        Double[] arrayChosen = new Double[0];
        double selectDifferent = 100000000;
        ArrayList<Double> returedArray = new ArrayList<Double>();
        for (Double[] numList : recurisionArray) {
            double sum = 0;
            for (int i = 0; i < numList.length; i++) {
                sum += numList[i];
            }
            if (sum - budget == 0) {
                arrayChosen = numList;
                break;
            } else if (Math.abs(sum - budget) < selectDifferent) {
                selectDifferent = sum - budget;
                arrayChosen = numList;
            }
        }

        for (int i = 0; i < arrayChosen.length; i++)
            returedArray.add(arrayChosen[i]);

        return returedArray;
    }
}
