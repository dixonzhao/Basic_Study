resources
    -Testfiles
        -Excel-01_result table
            -The excel table wich store the raw data and primary table with expliantion
    -source picutre
        -00
            -snapshot of all figures provided in this result
        -01-03
            -Pictures which used as result explaination
        -04 series
            -Pictures used to search or to have closer over view of raw data
    -RUN.txt
        -results and comments of table while some mentioned pictures are provided by sources picture
        -The abstract result
         1.    The fluctuation time correlates with the table generate method of the array.
         2.    The range that seems to be flat has a positive correlation with the size of the array. (more massive the array, flatter the running time)
         3.    The sort time has a negative correlation with the recursion size.
         4.    The sort time minimal range has a negative correlation with the array size.
         5.    Suggested best optimal recursion limit arrays of various sizes will be
                 1. Arrary Size should be at least exceed 2,000,000, suggests 3,000,000 or more.
                 2. Recursion limit should be at least 100, suggests 150 or more.

Src
    -FH_QS_Test.java
         use the static mutator FHsort.setRecursionLimit(int)
         to change this limit to any int value in the range of 2 to 300 to find
         the optimal recursion limit arrays of various array sizes.
    -FHsort.java
        -Sorts method util class.
