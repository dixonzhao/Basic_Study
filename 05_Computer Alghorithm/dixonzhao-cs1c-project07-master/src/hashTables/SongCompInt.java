package hashTables;

import cs1c.SongEntry;
/**
 * Song componet based on the Id modified
 *
 * @author Foothill College, Zhili Zhao
 */
public class SongCompInt implements Comparable<Integer> {


    private SongEntry songE;

    /**
     * basic constructor
     * @param e
     */
    SongCompInt(SongEntry e){
        songE=e;
    }

    /**
     * Getter of the SongEntry
     * @return
     */
    public SongEntry getSongE() {
        return songE;
    }

    /**
     * Setter of the song entry(as backup but not been used)
     * @param songE
     */
    public void setSongE(SongEntry songE) {
        this.songE = songE;
    }


    /**
     * Override compareTomethod, use minus to return
     * @param obj
     * @return
     */
    @Override
    public int compareTo(Integer obj){

        return songE.getID()-obj;
    }

    /**
     * override euqals, test to the ID only and ready for two type of input
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        boolean result=false;
        if(obj instanceof Integer) {
            result = songE.getID()==(int)obj;
        }
        if(obj instanceof SongCompInt){
            result = songE.getID()==((SongCompInt) obj).getSongE().getID();
        }


        return result;
    }

    /**
     * modified hashCode return ID as hashcode for probing
     * @return
     */
    @Override
    public int hashCode(){

        return songE.getID();
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
     * protected toString method output Id first and all information
     * @return
     */
    protected String toStringInside(){
        return "the ID of song is"+ songE.getID()+ "\n " +
                "and the specific data is" + songE;
    }

    //End Override part


}
