package hashTables;

import cs1c.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * Create and populate two hash tables of type FHhashQPwFind class, one for each wrapper class
 *
 * @author Foothill College, Zhili Zhao
 */
public class TableGenerator {
    private FHhashQPwFind<Integer, SongCompInt>  tableOfSongIDs;
    private FHhashQPwFind<String, SongsCompGenre> tableOfSongGenres;
//    private FHhashLPwFind<Integer, SongCompInt>  tableOfSongIDs;
//    private FHhashLPwFind<String, SongsCompGenre> tableOfSongGenres;
    /**
     * geter of Genrenames
     * @return
     */
    public ArrayList<String> getGenreNames() {
        return genreNames;
    }


    private ArrayList<String> genreNames=new ArrayList<>(1);
    int count;
    int limitSize;

    /**
     * default constructor of class,initialize the two tables with default size 97
     */
    public TableGenerator(){
        count =0;
        limitSize=97;
        tableOfSongGenres = new FHhashQPwFind<String, SongsCompGenre>(97);
        tableOfSongIDs = new FHhashQPwFind<Integer, SongCompInt>(97);
//        tableOfSongGenres = new FHhashLPwFind<String, SongsCompGenre>(97);
//        tableOfSongIDs = new FHhashLPwFind<Integer, SongCompInt>(97);
    }

    /**
     * constructor initalize the table with input size
     * @param size
     */
    public TableGenerator(int size){
        count = 0;
        limitSize = size;
        tableOfSongGenres = new FHhashQPwFind<String, SongsCompGenre>(limitSize);
        tableOfSongIDs = new FHhashQPwFind<Integer, SongCompInt>(limitSize);
//        tableOfSongGenres = new FHhashLPwFind<String, SongsCompGenre>(limitSize);
//        tableOfSongIDs = new FHhashLPwFind<Integer, SongCompInt>(limitSize);
    }

    //按照ID存，直接Insert，比对时SongCompInt会用内置的compareTo看ID

    /**
     * Store based on the ID, capture the nosuchelementexception for insert
     * @param allSongs
     * @return
     */
    public FHhashQPwFind populateIDtable(SongEntry[] allSongs){
        tableOfSongGenres = new FHhashQPwFind<String, SongsCompGenre>(allSongs.length);
        tableOfSongIDs = new FHhashQPwFind<Integer, SongCompInt>(allSongs.length);


        for (SongEntry song:allSongs
             ) {
            try{

            tableOfSongIDs.insertKey(song.getID(),new SongCompInt(song));
            }catch (NoSuchElementException e){
                continue;
            }

        }




        return tableOfSongIDs;
    }


    /**
     * First check if genre name exist, if yes, add song into the exist store list, if not create new genre into total table
     * @param allSongs
     * @return
     */
    public FHhashQPwFind populateGenreTable(SongEntry[] allSongs){
        tableOfSongGenres = new FHhashQPwFind<String, SongsCompGenre>(allSongs.length);
        tableOfSongIDs = new FHhashQPwFind<Integer, SongCompInt>(allSongs.length);
        for (SongEntry song:allSongs
        ) {
            try{
            tableOfSongGenres.find(song.getGenre());
            tableOfSongGenres.find(song.getGenre()).addSong(song);



            }catch (NoSuchElementException e){
                tableOfSongGenres.insertKey(song.getGenre(),new SongsCompGenre(song));
                genreNames.add(song.getGenre());
                continue;
            }

        }

        return tableOfSongGenres;
    }

//
//
//    public FHhashLPwFind populateIDtable(SongEntry[] allSongs){
//;
//        tableOfSongGenres = new FHhashLPwFind<String, SongsCompGenre>(allSongs.length);
//        tableOfSongIDs = new FHhashLPwFind<Integer, SongCompInt>(allSongs.length);
//
//        for (SongEntry song:allSongs
//        ) {
//            try{
//
//                tableOfSongIDs.insertKey(song.getID(),new SongCompInt(song));
//            }catch (NoSuchElementException e){
//                continue;
//            }
//
//        }
//
//
//
//
//        return tableOfSongIDs;
//    }
//
//
//    /**
//     * First check if genre name exist, if yes, add song into the exist store list, if not create new genre into total table
//     * @param allSongs
//     * @return
//     */
//    public FHhashLPwFind populateGenreTable(SongEntry[] allSongs){
//        tableOfSongGenres = new FHhashLPwFind<String, SongsCompGenre>(allSongs.length);
//        tableOfSongIDs = new FHhashLPwFind<Integer, SongCompInt>(allSongs.length);
//        for (SongEntry song:allSongs
//        ) {
//            try{
//                tableOfSongGenres.find(song.getGenre());
//                tableOfSongGenres.find(song.getGenre()).addSong(song);
//
//
//
//            }catch (NoSuchElementException e){
//                tableOfSongGenres.insertKey(song.getGenre(),new SongsCompGenre(song));
//                genreNames.add(song.getGenre());
//                continue;
//            }
//
//        }
//
//        return tableOfSongGenres;
//    }
//
//


}
