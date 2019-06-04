package cs1c;


// HashEntry class for use by FHhashQP -----------------------
/**
 *Basic Element of Hash table
 *
 * @author Foothill College, Zhili Zhao
 */
public class HashEntry<E>
{
   public E data;
   public int state;

   /**
    * initialize the HashEntry with both element and state
    * @param x
    * @param st
    */
   public HashEntry( E x, int st )
   {
      data = x;
      state = st;
   }

   /**
    * direct to first entry
    */
   public HashEntry()
   {
      this(null, FHhashQP.EMPTY);
   }
}
