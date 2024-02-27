package hw4;

/**
 * Interface to be implemented by Visitors that act on the key, value pairs 
 * stored in nodes in our binary trees
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 19, 2024
 */
public interface COMP232Visitor<K, V> {
    /**
     * The visit method will be invoked in a tree. The order in which the nodes 
     * are visited is determined by the method that is used. 
     * meaning visitPreOrder, visitInOrder, visitPostOrder, visitLevelOrder
     * 
     * @param key
     *          the key stored at the node
     * @param value
     *          the value stored at the node
     */
    public void visit(K key, V value);
}
