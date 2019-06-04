package lazyTrees;

import java.util.*;

 /** Simulates the music scenario of adding, removal songs to store and find song by title<p>
 *
         * Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted)
         * and current inventory (non deleted only).
         */
public class FoothillTunesStore {
    protected int mSize;
    protected int mSizeHard;
    protected FoothillTunesStore.tunes mRoot;
    protected FoothillTunesStore.tunes mRootHard;
    boolean checkExist;

     /**
      * The constructor of BST which initialize the tree
      */
    public FoothillTunesStore() { clear(); }

     /**
      * check if the tree is empty
      * @return
      */
    public boolean empty() { return (mSize == 0); }

     /**
      * check the size of tree without lazy deleted object
      * @return
      */
    public int size() { return mSize; }


    public int sizeHard(){return mSizeHard;};

     /**
      * clear all data and tree
      */
    public void clear() { mSize = 0; mRoot = null; }

     /** unused method which prepare for AVL tree
      *
      * @return
      */
    public int showHeight() { return findHeight(mRoot, -1); }

     /**
      * method which find minium song based on title
      * @return
      */
    public song findMin()
    {
        if (mRoot == null)
            throw new NoSuchElementException();
        return findMin(mRoot).data;
    }
     /**
      * method which find maxium song based on title
      * @return
      */
    public song findMax() {

        if (mRoot == null)
            throw new NoSuchElementException();
        return findMax(mRoot).data;
    }

     /**
      * method which takes in song object and search for same title
      * @param x
      * @return
      */
    public song find( song x )
    {
        FoothillTunesStore.tunes resultNode;
        resultNode = find(mRoot, x);
        if (resultNode == null)
            throw new NoSuchElementException();
        return resultNode.data;
    }

     /**
      * method which takes in song name to search for same title
      * @param song
      * @return
      */
    public song find(String song){
        song x= new song(new SongEntry(song,111,null,null));
        FoothillTunesStore.tunes resultNode;
        resultNode = find(mRoot, x);
        if (resultNode == null)
            throw new NoSuchElementException();
        return resultNode.data;
    }

     /**
      * method which check if specific song is in list
      * @param x
      * @return
      */
    public boolean contains(song x)  { return find(mRoot, x) != null; }

     /**
      * method which call insert method in helping method
      * @param x
      * @return
      */
    public boolean insert( song x )
    {
        int oldSize = mSize;
        mRoot = insert(mRoot, x);
        return (mSize != oldSize);
    }



     /**
      * method which call remove method in helping method
      * @param x
      * @return
      */
    public boolean remove( song x )
    {
        int oldSize = mSize;
        remove(mRoot, x);
        return (mSize != oldSize);
    }



     /**
      * method which call traverse method in helping method for every object
      * @return
      */
    public < F extends Traverser>
    void traverseHard(F func)
    {
        traverseHard(func, mRoot);
    }
     /**
      * method which call traverse method in helping method for only exist object
      * @return
      */
    public < F extends Traverser >
    void traverseSoft(F func)
    {
        traverseSoft(func, mRoot);
    }

    /*
    method which gives a hard compy of list
     */
    public Object clone() throws CloneNotSupportedException
    {
        FoothillTunesStore newObject = (FoothillTunesStore)super.clone();
        newObject.clear();  // can't point to other's data

        newObject.mRoot = cloneSubtree(mRoot);
        newObject.mSize = mSize;

        return newObject;
    }

    // private helper methods ----------------------------------------

     /**
      * method which find minium object inlist
      * @param root
      * @return
      */
    protected FoothillTunesStore.tunes findMin(FoothillTunesStore.tunes root )
    {
        FoothillTunesStore.tunes minNode=root;
        FoothillTunesStore.tunes backUp=root;
        boolean checkFirst=false;

        if(root.deleted==true) {
            for (int i=0; i < 500; i++)
                ((song) root.data).incrementCount();
            checkFirst=true;
        }

        if (root == null){
            return null;
        }

        if(root.data instanceof song) {

            // for item class only
            if (checkLeft(root) == true) {
                if(root.lftChild!=null)

//                    if(((song) root.data).getCount()> ((song) findMin(root.lftChild).data).getCount())
                    if(root.data.compareTo(findMin(root.lftChild).data)>0)
                        minNode = findMin(root.lftChild);

            }
            if (checkRight(root) == true) {
                if(root.rtChild!=null)

//                    if(((song) root.data).getCount()> ((song) findMin(root.rtChild).data).getCount())
                    if(root.data.compareTo(findMin(root.rtChild).data)>0)
                        minNode = findMin(root.rtChild);

            }
        }


        if(checkFirst){
            for (int i=0; i < 500; i++)
                ((song) root.data).decrementCount();
            checkFirst=false;
        }


        return minNode;


    }

     /**
      * method which find maxium object in list
      * @param root
      * @return
      */
    protected FoothillTunesStore.tunes findMax(FoothillTunesStore.tunes root )
    {
        FoothillTunesStore.tunes maxNode=root;

        if (root == null){
            return null;
        }

        // for item class only
        if (checkRight(root) == true) {
            if(root.rtChild!=null)
                if(maxNode.data.compareTo(findMax(root.rtChild).data)<0)
                    maxNode = findMax(root.rtChild);
//                if(((song) maxNode.data).getCount()< ((song) findMax(root.rtChild).data).getCount())


        }

        if (checkLeft(root) == true) {
            if(root.lftChild!=null)
                if(maxNode.data.compareTo(findMax(root.lftChild).data)<0)
                    maxNode = findMax(root.lftChild);
//            if(((song) maxNode.data).getCount()< ((song) findMax(root.lftChild).data).getCount())
        }



        return maxNode;










//      if (root == null){
//         return null;
//      }
//
//      if(checkLeft(root)==true){
//         return findMin(root.lftChild);
//      }
//      if(root.deleted!=true){
//         return root;
//      }
//      if(checkRight(root)==true){
//         return findMin(root.rtChild);
//      }
//
//
//      return null;
//





//      if (root == null)
//         return null;
//      else if(root.deleted==true)
//         return findMax(root.rtChild);
//      if (root.rtChild == null)
//         return root;
//      if(root.rtChild.deleted==true && root.rtChild.rtChild==null)
//         return root;
//      return findMax(root.rtChild);
    }

     /**
      * method which insert object to specific point based on BST rule
      * @param root
      * @param x
      * @return
      */
    protected FoothillTunesStore.tunes insert(FoothillTunesStore.tunes root, song x )
    {

        int compareResult;  // avoid multiple calls to compareTo()



        if (root == null)
        {
            mSize++;
            mSizeHard++;

            return new FoothillTunesStore.tunes(x, null, null);
        }

        compareResult = x.compareTo(root.data);
        if ( compareResult < 0 )
            root.lftChild = insert(root.lftChild, x);
        else if ( compareResult > 0 )
            root.rtChild = insert(root.rtChild, x);

        if(compareResult ==0){
            if(root.deleted==true){
                root.deleted=false;
                mSize++;
            }
            ((song) root.data).incrementCount();
        }




        return root;
    }

     /**
      * method which remove object with lazy deletion which only mark
      * @param root
      * @param x
      */
    protected void remove(FoothillTunesStore.tunes root, song x  )
    {
        int compareResult;  // avoid multiple calls to compareTo()

        if (root == null)
            return;

        compareResult = x.compareTo(root.data);
        if ( compareResult < 0 )
            remove(root.lftChild, x);
        else if ( compareResult > 0 )
            remove(root.rtChild, x);

        // found the node, for Item class Only
        if(root.data instanceof song){
            if(compareResult==0)
                if(((song) root.data).getCount()>1){
                    ((song) root.data).decrementCount();
//                    root.deleted=true;
                    return;
                } else{
                    if(((song) root.data).getCount()==1){
                        ((song) root.data).decrementCount();
                        mSize--;
                    }
                    mSize--;
                    root.deleted=true;
                }
        }




        return;
    }

     /**
      * method which check the close left three point of one node if there is data
      * @param nodeT
      * @return
      */
    private boolean checkLeft(FoothillTunesStore.tunes nodeT){
        checkExist=false;
        if(nodeT== null)
            return checkExist;

        if(nodeT.lftChild!=null){
            if(nodeT.lftChild.deleted!=true){
                checkExist =true;
                return checkExist;
            }

            if(checkLeft(nodeT.lftChild)==true){
                checkExist =true;
                return checkExist;
            }

            if(checkRight(nodeT.lftChild)==true){
                checkExist =true;
                return checkExist;
            }

        }

        return checkExist;
    }
     /**
      * method which check the close right three point of one node if there is data
      * @param nodeT
      * @return
      */
    private boolean checkRight(FoothillTunesStore.tunes nodeT){
        checkExist=false;
        if(nodeT== null)
            return checkExist;

        if(nodeT.rtChild!=null){
            if(nodeT.rtChild.deleted!=true){
                checkExist =true;
                return checkExist;
            }

            if(checkLeft(nodeT.rtChild)==true){
                checkExist =true;
                return checkExist;
            }

            if(checkRight(nodeT.rtChild)==true){
                checkExist =true;
                return checkExist;
            }

        }

        return checkExist;
    }

     /**
      * method which serve as backup for if needs hard delete
      * @return
      */
    private FoothillTunesStore.tunes doRemove(FoothillTunesStore.tunes root){
        if(root== null){
            return null;
        }

        if(root.deleted==false){
            root.lftChild=doRemove(root.lftChild);
            root.rtChild=doRemove(root.rtChild);
        } else {
            if (root.lftChild==null||root.rtChild==null){
                root = (root.lftChild!=null) ? root.lftChild : root.rtChild;
                root = doRemove(root);
            } else {
                root.lftChild=null;
                findMin(root.rtChild);
                if(root.lftChild==null){
                    root.rtChild=null;
                    root=doRemove(root);
                } else {
                    root.data= root.lftChild.data;
                    root.deleted=false;
                    root.lftChild.deleted = true;
                    root = doRemove(root);
                }
            }
        }

        return root;
    }


     /**
      * method which traverse every object to print out
      * @param func
      * @param treeNode
      * @param <F>
      */
    protected <F extends Traverser>
    void traverseHard(F func, FoothillTunesStore.tunes treeNode)
    {
        if (treeNode == null)
            return;

        traverseHard(func, treeNode.lftChild);
        func.visit(treeNode.data);
        traverseHard(func, treeNode.rtChild);
    }

     /**
      * method which traverse every undeleted object to print out
      * @param func
      * @param treeNode
      * @param <F>
      */
    protected <F extends Traverser>
    void traverseSoft(F func, FoothillTunesStore.tunes treeNode)
    {
        if (treeNode == null)
            return;

        traverseSoft(func, treeNode.lftChild);
        if(treeNode.deleted!=true)
            func.visit(treeNode.data);
        traverseSoft(func, treeNode.rtChild);
    }

     /**
      * method which find the specific object by traverse the tree
      * @param root
      * @param x
      * @return
      */
    protected FoothillTunesStore.tunes find(FoothillTunesStore.tunes root, song x )
    {
        int compareResult;  // avoid multiple calls to compareTo()

        if (root == null)
            return null;

        compareResult = x.compareTo(root.data);
        if (compareResult < 0)
            return find(root.lftChild, x);
        if (compareResult > 0)
            return find(root.rtChild, x);

        if(root.deleted==true)
            return null;

        return root;   // found
    }

     /**
      * method which gives a hard clone of current tree
      * @param root
      * @return
      */
    protected FoothillTunesStore.tunes cloneSubtree(FoothillTunesStore.tunes root)
    {
        FoothillTunesStore.tunes newNode;
        if (root == null)
            return null;

        // does not set myRoot which must be done by caller
        newNode = new FoothillTunesStore.tunes
                (
                        root.data,
                        cloneSubtree(root.lftChild),
                        cloneSubtree(root.rtChild)
                );
        return newNode;
    }

     /**
      * unused method for AVL Trees
      * @param treeNode
      * @param height
      * @return
      */
    protected int findHeight(FoothillTunesStore.tunes treeNode, int height )
    {
        int leftHeight, rightHeight;
        if (treeNode == null)
            return height;
        if(treeNode.deleted!=true){
            height++;
        }else{
            if(treeNode.lftChild!=null && treeNode.rtChild!=null){
                if(treeNode.rtChild.deleted!=true && treeNode.lftChild.deleted!=true)
                    height++;
            }
        }

        leftHeight = findHeight(treeNode.lftChild, height);
        rightHeight = findHeight(treeNode.rtChild, height);
        return (leftHeight > rightHeight)? leftHeight : rightHeight;
    }

     /**
      * inner class for store the Node with left and right node
      */
    private class tunes
    {
        // use public access so the tree or other classes can access members
        public FoothillTunesStore.tunes lftChild, rtChild;
        public song data;
        public boolean deleted = false;
        public FoothillTunesStore.tunes myRoot;  // needed to test for certain error

        public tunes(song d, FoothillTunesStore.tunes lft, FoothillTunesStore.tunes rt )
        {
            lftChild = lft;
            rtChild = rt;
            data = d;
        }

        public tunes()
        {
            this(null, null, null);
        }



        // function stubs -- for use only with AVL Trees when we extend
        public int getHeight() { return 0; }
        boolean setHeight(int height) { return true; }
    }

}
