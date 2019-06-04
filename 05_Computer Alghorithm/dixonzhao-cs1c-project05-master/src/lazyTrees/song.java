package lazyTrees;


/**
 * One object of song class represents one song in the inventory, with SongEntry and counts
 *
 * @author Foothill College, Zhili Zhao
 */
public class song implements Comparable<song>
{

    // the name of the item
    private SongEntry song;


    // the count of this item
    private int count;

    /**
     * Constructor takes name for item. Instantiates count to 1.
     * @param song	name of the item to add created.
     */
    public song(SongEntry song)
    {
        this.song = song;
        this.count = 1;
    }

    /**
     * Increase the count by 1 each call.
     */
    public void incrementCount()
    {	count++;	};

    /**
     * Reduce the count by 1 each call and return false when count is less than 1.
     * @return Whether the count of the item was successfully decreased by 1.
     */
    public boolean decrementCount()
    {
        if (count < 1)
            return false;

        count--;
        return true;
    };

    /**
     * Get current number of items
     * @return	int value of current number of items.
     */
    public int getCount()
    {	return count;	}

    /**
     * Use item name for comparing.
     */
    @Override
    public int compareTo(song other)
    {

        return song.getTitle().compareToIgnoreCase(other.song.getTitle());
    };

    /**
     * Returns a string representation with the item name and count.
     */
    public String toString()
    {
        return song.getTitle() + ":" + count + " ";
    }
}

