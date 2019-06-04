package lazyTrees;

/**
 * Class that used to store the basic verson of LazySTNode
 *
 * @author CS1C, Foothill College, Zhili Zhao
 * @version 1.0
 */
public class LazySTNode<E extends Comparable< ? super E > >
{
   // use public access so the tree or other classes can access members 
   public LazySTNode<E> lftChild, rtChild;
   public E data;
   public LazySTNode<E> myRoot;  // needed to test for certain error

   public LazySTNode(E d, LazySTNode<E> lft, LazySTNode<E> rt )
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
