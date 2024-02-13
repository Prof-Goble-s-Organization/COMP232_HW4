/**
 * Interface used by an ADT to indicate that a MyIterator can be obtained 
 * for the data structure
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 6, 2024
 */
public interface MyIterable<E> {

    /**
     * Get MyIterator for the elements of this data structure
     * 
     * @return
     *          a MyIterator for the data structure
     */
    public MyIterator<E> getIterator();
}
