package cs1c;

import java.util.NoSuchElementException;
/**
 * Quadratic probing Hash table with find
 *
 * @author Foothill College, Zhili Zhao
 */
public class FHhashQPwFind<KeyType, E extends  Comparable<KeyType>> extends FHhashQP {
    protected static final int ACTIVE = 0;
    protected static final int EMPTY = 1;
    protected static final int DELETED = 2;

    static final int INIT_TABLE_SIZE = 97;
    static final double INIT_MAX_LAMBDA = 0.49;

    protected HashEntry<E>[] mArray;
    protected int mSize;
    protected int mLoadSize;
    protected int mTableSize;
    protected double mMaxLambda;

    // public methods ---------------------------------

    /**
     * Constructor with initialize of size and array
     * @param tableSize
     */
    public FHhashQPwFind(int tableSize)
    {
        super();
        mLoadSize = mSize = 0;
        if (tableSize < INIT_TABLE_SIZE)
            mTableSize = INIT_TABLE_SIZE;
        else
            mTableSize = nextPrime(tableSize);

        allocateArray();  // uses mTableSize;
        mMaxLambda = INIT_MAX_LAMBDA;
    }


    /**
     * Redirect to first constructor
     */
    public FHhashQPwFind()
    {
        this(INIT_TABLE_SIZE);
    }

    /**
     * get Hashcode of keytype
     * @param key
     * @return
     */
    private int getHashCode(KeyType key){
        int hashCode = key.hashCode()%mTableSize;
        if(hashCode<0){
            hashCode+=mTableSize;
        }
        return hashCode;
    }

    /**
     * insert based on key's hashcode
     * @param x
     * @param y
     * @return
     */
    public boolean insertKey( KeyType x, E y)
    {
        if (mArray==null){
           allocateArray();
    }
        int bucket = findPosKey(x);

        if ( mArray[bucket].state == ACTIVE )
            return false;

        mArray[bucket].data = y;
        mArray[bucket].state = ACTIVE;
        mSize++;

        // check load factor
        if( ++mLoadSize > mMaxLambda * mTableSize )
            rehash();

        return true;
    }


    /**
     * find the element based on key's square jump information
     * @param key
     * @return
     * @throws NoSuchElementException
     */
    public E find(KeyType key) throws NoSuchElementException {



        int i = myHashKey(key), h = 1;


            h = 1;
            while (mArray[i].state==0) {
                if (mArray[i].data.equals(key)) {
                    return mArray[i].data;
                }
                i = (i + h * h++) % mTableSize;
            }

            throw new java.util.NoSuchElementException();

    }

    /**
     * get the hash key based on the Keytype
     * @param key
     * @return
     */
    public int myHashKey(KeyType key){
        int hashVal;

        hashVal = key.hashCode() % mTableSize;
        if(hashVal < 0)
            hashVal += mTableSize;

        return hashVal;
    }

    /**
     * find position based on the key
     * @param key
     * @return
     */
    public int findPosKey(KeyType key){
        int kthOddNum = 1;
        int index = myHashKey(key);

        while ( mArray[index].state != EMPTY
                && !mArray[index].data.equals(key) )
        {
            index += kthOddNum; // k squared = (k-1) squared + kth odd #
            kthOddNum += 2;     // compute next odd #
            if ( index >= mTableSize )
                index -= mTableSize;
        }
        return index;
    }

    /**
     * reset array for empty.
     */
    void allocateArray()
    {
        int k;

        mArray = new HashEntry[mTableSize];
        for (k = 0; k < mTableSize; k++)
            mArray[k] = new HashEntry<E>();
    }

    /**
     * rebuild a longer array and transfer the old array to new one
     */
    protected void rehash()
    {
        // we save old list and size then we can reallocate freely
        HashEntry<E>[] oldArray = mArray;
        int k, oldTableSize = mTableSize;;

        mTableSize = nextPrime(2*oldTableSize);

        // allocate a larger, empty array
        allocateArray();  // uses mTableSize;

        // use the insert() algorithm to re-enter old data
        mSize = mLoadSize = 0;
        for(k = 0; k < oldTableSize; k++)
            if (oldArray[k].state == ACTIVE)
                insert( oldArray[k].data );
    }

    /**
     * find position based on hascode, h+1^2, h+2^2...
     * @param x
     * @return
     */
    int findPos( E x )
    {
        int kthOddNum = 1;
        int index = myHash(x);

        while ( mArray[index].state != EMPTY
                && !mArray[index].data.equals(x) )
        {
            index += kthOddNum; // k squared = (k-1) squared + kth odd #
            kthOddNum += 2;     // compute next odd #
            if ( index >= mTableSize )
                index -= mTableSize;
        }
        return index;
    }

    /**
     * insert based on Quadratic Probing
     * @param x
     * @return
     */
    public boolean insert( E x)
    {
        int bucket = findPos(x);

        if ( mArray[bucket].state == ACTIVE )
            return false;

        mArray[bucket].data = x;
        mArray[bucket].state = ACTIVE;
        mSize++;

        // check load factor
        if( ++mLoadSize > mMaxLambda * mTableSize )
            rehash();

        return true;
    }
}
