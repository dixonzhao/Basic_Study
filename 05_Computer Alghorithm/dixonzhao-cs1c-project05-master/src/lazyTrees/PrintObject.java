package lazyTrees;


/**
 * A class use to print the object
 *
 * @author CS1C, Foothill College, Zhili Zhao
 * @version 1.0
 */
class PrintObject<E> implements Traverser<E>
{
    public void visit(E x)
    {
        System.out.print( x + " ");
    }
};