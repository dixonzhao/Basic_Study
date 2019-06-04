resources
    -Testfiles
        -findGenres.txt : sample test files
        -findGenres2.txt: repeart test files
        -findGenres3.txt: empty test files
        -findIDs.txt: sample test files
        -findIDs2.txt: repeart test files
        -findIDs3.txt: empty test files
        -findIDs4.txt: lines for LP VS QP
        -findGenres4.txt: lines for LP VS QP
    -LP VS QP. png
        - The graph which shows the running time VS. number of line proceeds(n)
        - With almost all data point the linearing probing is faster than Quardtic probing
           - However, as the number of data proceed, the time varation is smaller which compare to the increase of lines proceed while each time the proceeds number doubles.
           -As the number of line proceed larger to some limit, the linear Probing's efficient continue down to the efficient of Quartic probing since it is easy to concertate

Src
    -cs1c
        -FHhashLP
            - linearing probing Hash table with find
        -FHhashQP
            -Original Sample Quadratic probing without find
        -FHhashQPwFind
            -Quadratic probing Hash table with find
        -HashEntry
            -Basic Element of Hash table
        -MillionSongDataSubset
            -One object of class MillionSongDataSubset parses a JSON data set and stores each entry in an array.
        -SongEntry
            - One object of class SongEntry stores a simplified version of the genre data set from
              the Million Song Dataset.
        -TimeConverter
            -Converts duration into a string representation.
    -hashTables
        -MyTunes
            -  Tests the functionality of FHhashQPwFind.java.
               Specifically checks for implementation of find() function to return an object associated with a given key input.
            -test case
                - run with sample case
                - run with one repeat case
                - run with both repeat case
                - run with one empty case
                - run with both empty case
                - run with both reverse case
        -SongCompInt
            -Song componet based on the Id modified
        -SongsCompGenre
            -Song componet based on the genre name modified
        -TableGenerator
            - Create and populate two hash tables of type FHhashQPwFind class, one for each wrapper class
