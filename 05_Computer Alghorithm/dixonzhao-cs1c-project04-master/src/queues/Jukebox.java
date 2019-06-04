package queues;

import cs1c.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 *reads the file and then adds songs to one of the three queues
 *
 * @author Foothill College, Zhili Zhao
 */
public class Jukebox<T> {
    Queue<SongEntry> favoritePL =new Queue<SongEntry>("favorite"); //store the favorite files from input
    Queue<SongEntry> roadTripPL=new Queue<SongEntry>("road trip"); //store the road trip files from input
    Queue<SongEntry> loungePL=new Queue<SongEntry>("lounge"); //Store the lounge files from input
    String requestFile;
    SongEntry[] allSongs;
    String [] tokens;
    String linkName;
    String originalName;
    SongEntry requestSong;

    int whichType;

    /**
     * default constructor
     * <p>show initialize the class <br>
     *
     */
    Jukebox(){
    }


    /**
     * primary method to take in data and assign to select queue
     * <p>reads the file and then adds songs to one of the three queues <br>
     *
     */
    public void fillPlaylists(String requestFile, SongEntry[] allSongs){

        this.requestFile=requestFile;
        this.allSongs=allSongs;

        File infile = new File(requestFile);
        try
        {
            Scanner input = new Scanner(infile);

            String line = "";
            int lineNum = 0;
            while (input.hasNextLine())
            {
                requestSong=null;
                originalName=null;

                lineNum++;
                line = input.nextLine();
                originalName=line;
                tokens = line.split(",");
                linkName=tokens[1];



                for(SongEntry songs:allSongs)
                    if(songs.getTitle().equals(linkName))
                        requestSong = songs;

                    if(requestSong==null) {
                        System.out.println("No request song, consider another one, thank you");
                    }



                if(requestSong!=null)
                    switch(figureWhichtype()){
                        case 1:
                            favoritePL.enqueue(requestSong);
                            break;
                        case 2:
                            roadTripPL.enqueue(requestSong);
                            break;
                        case 3:
                            loungePL.enqueue(requestSong);
                            break;
                        default:
                            System.out.println("No such type of song list, please consider another type, thank you.");
                            break;
                    }

            }

            // closing the input file resource
            input.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }




    }

    /**
     * Select method
     * <p>select the data to given queue<br>
     *
     */
    private int figureWhichtype(){
        if(originalName.contains("favorites"))
            return 1;
        if(originalName.contains("road trip"))
            return 2;
        if (originalName.contains("lounge"))
            return 3;

        return -1;
    }


    /**
     * show getter of  queue
     * <p>
     *    return the queue
     * </p>
     *
     */
    public Queue<SongEntry> getFavoritePL(){
        if(favoritePL==null)
            throw new NoSuchElementException();


        return favoritePL;
    };

    /**
     * show getter of  queue
     * <p>
     *    return the queue
     * </p>
     *
     */
    public Queue<SongEntry> getRoadTripPL(){
        if(roadTripPL==null)
            throw new NoSuchElementException();

        return roadTripPL;
    };

    /**
     * show getter of  queue
     * <p>
     *    return the queue
     * </p>
     *
     */
    public Queue<SongEntry> getLoungePL(){
        if(loungePL==null)
            throw new NoSuchElementException();
        return loungePL;
    };
}
