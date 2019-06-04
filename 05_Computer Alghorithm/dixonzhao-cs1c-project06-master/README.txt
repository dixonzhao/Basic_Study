resources
    -inventory
        -empty
        -except_testing for lazy deletion based on discussion
        -invalid_removal_remove things out of count
        -log_ sample long run
        -short_ sample short run
        -sample-testing data

Src
    -lazyTrees
        -Item
            - One object of Item class represents one item in the inventory, with two class members.
        -LazySearchTree
            -Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted)
            -and current inventory (non deleted only).
            -update Enabling garbage collection on lazily deleted nodes
        -LazySTNode
            -Class that used to store the basic verson of LazySTNode
        -PrintObject
            -A class use to print the object
        -SongEntry
            - One object of class SongEntry stores a simplified version of the genre data set from
              the Million Song Dataset.
        -SuperMarket
            - Simulates the market scenario of buying and adding items to a store's inventory.
              Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted)
               and current inventory (non deleted only).
        -Traverser
            -  A interface use to traserse the list
        -TimeConverter
            - Converts duration into a string representation.

