queues
        Queue
        	- Use to create/control queue by generic linked list to simulate queue<E>
        	-Functions
        		- A collection of generic Node objects.
        		- A constructor that creates an empty StackList object.
        		- A method push() that takes a generic object as parameter and adds that new object to the end of the list.
        		- A method called peek() which looks at the top of the stack and returns a generic type for the data seen at the top of the stack. The item should not be removed from the top of the stack.
                - A method called clear() which discards all object references from the linked-list to "empty" this StackList instance.
                - The isEmpty() method, which checks if the top of the stack is pointing to anything.
        		- A method A method called pop() which receives no arguments and removes the item from the top of the stack. This method should return the generic item popped.
        		- A method contains that takes a generic object as parameter and checks if the object can be found in the linked list.
        		- A method toString() which returns a string containing information about every country in the list.
        		- A method iterator() that returns object of type StackIterator.
        		- A constructor that takes in a generic object as a parameter.
        		- A constructor that takes in two parameters, a generic object and an object of parametrized Node type.
        		- Getter methods for all attributes.
        		- A setter method for the attribute next.
        		- A toString method that returns the string representation of data.
        Jukebox
            -Store the data to selected list
            -Funtions
                - A method fillPlaylists() that takes in the data and apply to selected list
                - A method figureWhichtype() that selected the queue the data go
        MyTunes
            - Main method which direct the data.
        projRequi
            - Use to store the project requirement.

Resources
    RUN.txt
        - Store the run result of the project
            tunes.txt
                (16 in total)
                    -in boundary case
                    -exceed boundary case
            tunes_empty.txt
                (00 in total)
                    -zero boundary case
                    -exceed boundary case
            tunes_tuncated.txt
                (03 in total)
                    -in boundary case
                    -exceed boundary case
            tunes_largeMemoryCase.txt
                (16000 in total)
                    - test for repeat input
                    -in boundary case
                    -exceed boundary case

