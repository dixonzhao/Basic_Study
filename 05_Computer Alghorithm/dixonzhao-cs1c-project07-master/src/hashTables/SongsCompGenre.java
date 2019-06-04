package hashTables;

import cs1c.SongEntry;

import java.util.ArrayList;
/**
 * Song componet based on the genre name modified
 *
 * @author Foothill College, Zhili Zhao
 */
public class SongsCompGenre implements Comparable<String> {
    /**
     * getter of the Name of genre
     * @return
     */
    public String getGenreName() {
        return genreName;
    }

    //attriutes
    String genreName;
    int count;
    ArrayList<SongEntry> Data=new ArrayList<SongEntry>(10);

    /**
     * add SongEntry to the same type of genre inside its array
     * @param e
     */
    public void addSong(SongEntry e){

        if(genreName ==null)
            genreName=e.getGenre();

        Data.add(e);
        count++;
    }

    /**
     * initial constructor
     * @param e
     */
    SongsCompGenre(SongEntry e){
        addSong(e);
    }

    /**
     * default constructor
     */
    SongsCompGenre(){

    }

    /**
     * return name
     * @return
     */
    public String getName() {
        return genreName;
    }

    /**
     * return count of songs
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * get data list of songentry
     * @return
     */
    public ArrayList<SongEntry> getData() {
        return Data;
    }




    /**
     * Override compareTomethod, use minus to return
     * @param obj
     * @return
     */
    @Override
    public int compareTo(String obj){

        return obj.compareTo(genreName);
    }

    /**
     * override euqals, test to the ID only and ready for two type of input
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        boolean result=false;
        if(obj instanceof String) {
            result = genreName.equals((String)obj);
        }
        if(obj instanceof SongsCompGenre){
            result = genreName.equals(((SongsCompGenre) obj).getGenreName());
        }

        return result;
    }

    /**
     * modified hashCode return genre bane as hashcode for probing
     * @return
     */
    @Override
    public int hashCode(){

        return genreName.hashCode();
    }

    /**
     * public to String
     * @return
     */
    @Override
    public String toString(){
        return toStringInside();

    }

    /**
     * protected toString method output genre name first and all information
     * @return
     */
    protected String toStringInside(){
        String output="Genre name is "+genreName+"\n" +
                "while the contains are"+Data;
        return output;



    }

    //End Override part



}
