
import java.util.*;
/**
 * use the static mutator FHsort.setRecursionLimit(int)
 * to change this limit to any int value in the range of 2 to 300 to find
 * the optimal recursion limit arrays of various sizes
 *
 * @author Foothill College, Zhili Zhao
 */
public class FH_QS_Test
{
    /**
     * recursion two level
     * The size is from 20,000 to 100,000,000 with gap of 100,000.
     * There are two loops for recursion, the outer loop is the array size,
     * which generate a array of select size which fill with Math.random method of a random number from 0 to 1,000,000.
     * But must note here is that the time of generate array may affect the table.
     * @param args
     */
    public static void main (String[] args)
    {
        int ArrayTestSizeMax =10000000;
        int ArrayTestSizeInterval=100000;
        long testTime1,testTime2,testTime3,testTime4,testTime5,testTime6,avergeTime;
        int testTimeCount;
        FHsort testSort=new FHsort();
        // example of instantiating an new object

        for(int i=20000;i<ArrayTestSizeMax;i+=ArrayTestSizeInterval){

            Integer[] arrayRefVar = new Integer[i];

            System.out.println(i+", ,");

            for(int siz=0;siz<i;siz++){
                arrayRefVar[siz]=(int)Math.random()*1000000;
            }






            for(int j=200;j<=300;j+=2){

                FHsort.setRecursionLimit(j);

                System.out.print(" ,");
                System.out.print(j+",");

                //Test Case 01
                long startTime=System.currentTimeMillis();
                FHsort.quickSort(arrayRefVar);
                long endTime=System.currentTimeMillis();


                testTime1=endTime-startTime;


                //Test Case 02

                startTime=System.currentTimeMillis();
                FHsort.quickSort(arrayRefVar);
                endTime=System.currentTimeMillis();
                testTime2=endTime-startTime;

                //Test Case 03


                startTime=System.currentTimeMillis();
                FHsort.quickSort(arrayRefVar);
                endTime=System.currentTimeMillis();
                testTime3=endTime-startTime;

                //Test Case 04


                startTime=System.currentTimeMillis();
                FHsort.quickSort(arrayRefVar);
                endTime=System.currentTimeMillis();
                testTime4=endTime-startTime;


                //Test Case 05


                startTime=System.currentTimeMillis();
                FHsort.quickSort(arrayRefVar);
                endTime=System.currentTimeMillis();
                testTime5=endTime-startTime;


                //Test Case 06


                startTime=System.currentTimeMillis();
                FHsort.quickSort(arrayRefVar);
                endTime=System.currentTimeMillis();
                testTime6=endTime-startTime;


                avergeTime=(testTime1+testTime2+testTime3+testTime4+testTime5+testTime6)/6;


                System.out.print(avergeTime);
                System.out.println();
            }


        }






    }
}
