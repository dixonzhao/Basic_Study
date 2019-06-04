resources
    -inventory
        -empty
        -except_testing for lazy deletion based on discussion
        -invalid_removal_remove things out of count
        -log_ sample long run
        -short_ sample short run
        -sample-testing data
    -songs
        -one for testing the adding, remove songs from list and searching based on title
Src
    -lazyTrees
        -FoothillTunesStore
            -Class Simulates the market scenario of buying and adding items to a store's inventory.
            -Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted)
             and current inventory (non deleted only).
        -Item
            - One object of Item class represents one item in the inventory, with two class members.
        -LazySearchTree
            -Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted)
            -and current inventory (non deleted only).
        -LazySTNode
            -Class that used to store the basic verson of LazySTNode
        -millionSongDataSubset
            -One object of class MillionSongDataSubset parses a JSON data set and stores each entry in an array.
        -PrintObject
            -A class use to print the object
        -song
            -One object of song class represents one song in the inventory, with SongEntry and counts
        -SongEntry
            - One object of class SongEntry stores a simplified version of the genre data set from
              the Million Song Dataset.
        -SuperMarket
            - Simulates the market scenario of buying and adding items to a store's inventory.
              Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted)
               and current inventory (non deleted only).
        -TestingFoothillTunesStore
            -  Simulates the music scenario of adding, removal songs to store and find song by title<p>
            -  Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted)
               and current inventory (non deleted only).
        -TimeConverter
            - Converts duration into a string representation.
        -A interface use to traserse the list
