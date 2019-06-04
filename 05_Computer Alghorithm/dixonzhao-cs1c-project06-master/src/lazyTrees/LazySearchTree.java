package lazyTrees;

import java.util.*;

/**
 * Implements BST with lazy deletion to keep track of total inventory ("deleted" + non deleted)
 * and current inventory (non deleted only).
 *
 * @update Enabling garbage collection on lazily deleted nodes
 * @author Foothill College, Zhili Zhao
 * @version 1.01
 *
 */
public class LazySearchTree<E extends Comparable< ? super E > >
        implements Cloneable
{
   protected int mSize;
   protected int mSizeHard;
   protected LazySTNode mRoot;
   protected LazySTNode mRootHard;
   protected LazySTNode previousNode = null;
   boolean checkExist;

   /**
    * The constructor of BST which initialize the tree
    */
   public LazySearchTree() { clear(); }
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
   /**
    * Check the size of tree with every nodes
    * @return
    */
   public int sizeHard(){return mSizeHard;};
   /**
    * clear all data and tree
    */
   public void clear() { mSize = 0; mRoot = null; }
   /** unused method which prepare for AVL tree
    *
    * @return
    */

   /**
    * Truly remove all deleted (stale) nodes from the tree
    * @return
    * @version 1.00
    */
   public boolean collectGarbage(){
      while(mSize<mSizeHard){
         collectGarbage(this.mRoot);
      }

      return true;
   }

   public int showHeight() { return findHeight(mRoot, -1); }
   /**
    * method which find minium object based on count
    * @return
    */
   public E findMin()
   {
      if (mRoot == null)
         throw new NoSuchElementException();
      return findMin(mRoot).data;
   }
   /**
    * method which find maxium object based on count
    * @return
    */
   public E findMax() {

      if (mRoot == null)
         throw new NoSuchElementException();
      return findMax(mRoot).data;
   }
   /**
    * method which takes in object and search for same name
    * @param x
    * @return
    */
   public E find( E x )
   {
      LazySTNode resultNode;
      resultNode = find(mRoot, x);
      if (resultNode == null)
         throw new NoSuchElementException();
      return resultNode.data;
   }
   /**
    * method which check if specific object is in list
    * @param x
    * @return
    */
   public boolean contains(E x)  { return find(mRoot, x) != null; }

   /**
    * method which call insert method in helping method
    * @param x
    * @return
    */
   public boolean insert( E x )
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
   public boolean remove( E x )
   {
      int oldSize = mSize;
      remove(mRoot, x);
      return (mSize != oldSize);
   }



   /**
    * method which call traverse method in helping method for every object
    * @return
    */
   public < F extends Traverser<? super E > >
   void traverseHard(F func)
   {
      traverseHard(func, mRoot);
   }
   /**
    * method which call traverse method in helping method for only exist object
    * @return
    */
   public < F extends Traverser<? super E > >
   void traverseSoft(F func)
   {
      traverseSoft(func, mRoot);
   }
   /*
    method which gives a hard copy of list
     */
   public Object clone() throws CloneNotSupportedException
   {
      LazySearchTree<E> newObject = (LazySearchTree<E>)super.clone();
      newObject.clear();  // can't point to other's data

      newObject.mRoot = cloneSubtree(mRoot);
      newObject.mSize = mSize;

      return newObject;
   }

   // private helper methods ----------------------------------------
   /**
    * method which find minium object in list(only for item class)
    * @param root
    * @return
    */
   protected LazySTNode findMin(LazySTNode root )
   {
      LazySTNode minNode=root;
      LazySTNode backUp=root;
      boolean checkFirst=false;

      if(root.deleted==true) {
         for (int i=0; i < 500; i++)
            ((Item) root.data).incrementCount();
         checkFirst=true;
      }

      if (root == null){
         return null;
      }


      if(root.data instanceof Item) {

         // for item class only
         if (checkLeft(root) == true) {
            if(root.lftChild!=null)
               if(((Item) root.data).getCount()> ((Item) findMin(root.lftChild).data).getCount())
                  minNode = findMin(root.lftChild);

         }
         if (checkRight(root) == true) {
            if(root.rtChild!=null)
               if(((Item) root.data).getCount()> ((Item) findMin(root.rtChild).data).getCount())
                  minNode = findMin(root.rtChild);

         }
      }


      if(checkFirst){
         for (int i=0; i < 500; i++)
            ((Item) root.data).decrementCount();
         checkFirst=false;
      }


      return minNode;


   }
   /**
    * method which find maxium object in list(only for item class)
    * @param root
    * @return
    */
   protected LazySTNode findMax(LazySTNode root )
   {
      LazySTNode maxNode=root;

      if (root == null){
         return null;
      }

      // for item class only
      if (checkRight(root) == true) {
         if(root.rtChild!=null)
            if(((Item) maxNode.data).getCount()< ((Item) findMax(root.rtChild).data).getCount())
               maxNode = findMax(root.rtChild);

      }

      if (checkLeft(root) == true) {
         if(root.lftChild!=null)
            if(((Item) maxNode.data).getCount()< ((Item) findMax(root.lftChild).data).getCount())
               maxNode = findMax(root.lftChild);

      }



      return maxNode;

   }
   /**
    * method which insert object to specific point based on BST rule
    * @param root
    * @param x
    * @return
    */
   protected LazySTNode insert(LazySTNode root, E x )
   {

      int compareResult;  // avoid multiple calls to compareTo()



      if (root == null)
      {
         mSize++;
         mSizeHard++;

         return new LazySTNode(x, null, null);
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
         ((Item) root.data).incrementCount();
      }




      return root;
   }

   /**
    * method which remove object with lazy deletion which only mark
    * @param root
    * @param x
    */
   protected void remove(LazySTNode root, E x  )
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
      if(root.data instanceof Item){
         if(compareResult==0)
            if(((Item) root.data).getCount()>1){
               ((Item) root.data).decrementCount();
//               root.deleted=true;
               return;
            } else{
               if(((Item) root.data).getCount()==1){
                  ((Item) root.data).decrementCount();
                  mSize--;
               }
               mSize--;
               root.deleted=true;
            }
      }




      return;
   }


   /**
    * Remove node from the tree while proceed data only for exchange data(and delete it)<p>
    *     1.if one side is null, move up other side
    *     2.if both sides null, return null
    *     3.if both sides have things
    *       3-1.find right side small replace data up
    *       3-2.delete origin replace node
    * </p>
    * @param root
    * @param x
    * @return
    * @version 1.01
    * @update correct the bug of replace node is deleted cause the program ignore it
    *
    */
   public LazySTNode removeHard(LazySTNode root, E x){
      int compareResult;
      LazySTNode replaceNode;
      LazySTNode copyNode=root;

      compareResult = x.compareTo(root.data);

      if(root==null)
         return null;

      if (compareResult < 0)
         root.lftChild=removeHard(root.lftChild, x);

      if (compareResult > 0)
         root.rtChild=removeHard(root.rtChild, x);

      if(compareResult==0) {
         copyNode.data=root.data;
         copyNode.lftChild=root.lftChild;
         copyNode.rtChild=root.rtChild;

         if (root.rtChild == null && root.lftChild == null)
            return null;
         if (root.rtChild == null)
            return root.lftChild;
         if (root.lftChild == null)
            return root.rtChild;


         replaceNode = findMinHard(root.rtChild);
         root.data = replaceNode.data;
         root.deleted=false;
         if(replaceNode.deleted==true)
            root.deleted=true;
//         root.rtChild =

         root.rtChild=removeHard(root.rtChild, replaceNode.data);

         return copyNode;
      }



      return root;
   }

   /**
    * method which find minium object in list by recursion
    * @param root
    * @return
    * @version 1.00
    */
   private LazySTNode findMinHard(LazySTNode root){

      LazySTNode minNodeOne=root;
      LazySTNode minNodeTwo=root;
      int compareResult;

      if(root.lftChild!=null)
         minNodeOne=findMinHard(root.lftChild);

      if(root.rtChild!=null)
         minNodeTwo=findMinHard(root.rtChild);

      compareResult=minNodeOne.data.compareTo(minNodeTwo.data);

      if (compareResult < 0)
         return minNodeOne;

      if (compareResult > 0)
         return minNodeTwo;

      return minNodeOne;

   }

   /**
    * method which find max object in list
    * @param root
    * @return
    * @version 1.00
    */
   private LazySTNode findMaxHard(LazySTNode root){
      LazySTNode maxNodeOne=root;
      LazySTNode maxNodeTwo=root;
      int compareResult;

      if(root.lftChild!=null)
         maxNodeOne=findMaxHard(root.lftChild);
      if(root.rtChild!=null)
         maxNodeTwo=findMaxHard(root.rtChild);

      compareResult=maxNodeOne.data.compareTo(maxNodeTwo.data);

      if (compareResult < 0)
         return maxNodeTwo;

      if (compareResult > 0)
         return maxNodeOne;

      return maxNodeOne;


   }

   /**
    * method which check the close left three point of one node if there is data
    * @param nodeT
    * @return
    */
   private boolean checkLeft(LazySTNode nodeT){
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
   private boolean checkRight(LazySTNode nodeT){
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
    * @version 1.00
    */
   private LazySTNode collectGarbage(LazySTNode root){

      if(root== null){
         return null;
      }

      if(root.deleted==false){
         collectGarbage(root.lftChild);
         collectGarbage(root.rtChild);
      } else if(root.deleted == true) {
         root=removeHard(mRoot,root.data);
         mSizeHard--;
         return root;
      }

      return null;
   }



   /**
    * method which traverse every object to print out
    * @param func
    * @param treeNode
    * @param <F>
    */
   protected <F extends Traverser<? super E>>
   void traverseHard(F func, LazySTNode treeNode)
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
   protected <F extends Traverser<? super E>>
   void traverseSoft(F func, LazySTNode treeNode)
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
   protected LazySTNode find(LazySTNode root, E x )
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
   protected LazySTNode cloneSubtree(LazySTNode root)
   {
      LazySTNode newNode;
      if (root == null)
         return null;

      // does not set myRoot which must be done by caller
      newNode = new LazySTNode
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
   protected int findHeight(LazySTNode treeNode, int height )
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
   private class LazySTNode
   {
      // use public access so the tree or other classes can access members
      public LazySTNode lftChild, rtChild;
      public E data;
      public boolean deleted = false;
      public LazySTNode myRoot;  // needed to test for certain error

      public LazySTNode(E d, LazySTNode lft, LazySTNode rt )
      {
         lftChild = lft;
         rtChild = rt;
         data = d;
      }

      public LazySTNode()
      {
         this(null, null, null);
      }



      // function stubs -- for use only with AVL Trees when we extend
      public int getHeight() { return 0; }
      boolean setHeight(int height) { return true; }
   }

}
