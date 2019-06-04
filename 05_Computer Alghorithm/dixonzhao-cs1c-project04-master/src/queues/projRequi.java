package queues;

import cs1c.SongEntry;
import queues.MyTunes;

import queues.Queue;

import java.security.PublicKey;

public interface projRequi<E> {

    /**
     * to create three queue object which comes to three types of requirement
     */
    final MyTunes mytune=null;

    // TODO: define the class Jukebox such that the constructor reads the file with user's request for

    // TODO: Define the constructor of class Jukebox such that initializes the playlists.

    // TODO: Define the class Jukebox fillPlaylists() method such that it reads the test file

    // TODO:  Provide additional test input cases. That means your own tunes_CASE.txt input test file.




    //JukeBox------------------------------------------------------------------------------
    Queue<SongEntry> favouritePL = null; //store the favourite files from input
    Queue<SongEntry> roadTripPL = null; //store the road trip files from input
    Queue<SongEntry> loungePL = null; //Store the lounge files from input

    /**
     * reads the test file and then adds songs to one of the three queues
     */
    public void fillPlaylists();

    /**
     * getter of three queue objects
     * @return
     */
    public Queue<SongEntry> getFavouritePL();
    public Queue<SongEntry> getRoadTripPL();
    public Queue<SongEntry> getLoungePL();



    //Queue<Type> first in first out------------------------------------------------
    String name=null;
    Queue head=null;
    Queue tail=null;

    /**
     * takes in a user assigned name
     * initializes the class attributes.
     */
    public void Queue();

    /**
     *
     * add to end of queue
     */
    public void enqueue(Queue queue);

    /**
     * 1. output first of queue and delete it
     * 2. Throw NoSuchElementException Only queue is empty
     *
     */
    public Queue dequeue();

    /**
     * 1. output front of the queue while not remove it
     * 2. if queue is empty, return null
     */
    public Queue peek();



    /**
     * check if the que is empty
     */
    public Boolean isEmpty();

    /**
     * check the current size of queue
     */
    public int size();

    /**
     * output the
     * 1. number of size
     * 2. full queue data
     */
    public String toString();




    //Test Case----------------------------------------------------------------------------
    /**
     *
     */
    String testcase1="one run where you are trying to remove items from an empty queue.";

    String testcaseN=" enough runs to prove your data structures work";
}
