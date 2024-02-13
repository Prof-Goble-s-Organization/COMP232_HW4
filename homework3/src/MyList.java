/**
 * Generic List interface that defines the operations supported by all of the 
 * implementations of the List ADT
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 6, 2024
 */
public interface MyList<E> {
    /*
     * Get the current size of the list
     * 
     * @return the size
     */
    public int size();

    /*
     * Append the specified element to the end of the list. 
     * This size of the list is increased by 1.
     * 
     * @param element
     *          The element to append to the list
     */
    public void add(E element);

    /*
     * Get the data element stored at the specified index of the list.
     * 
     * @param index
     *          The index from which to get the element.
     * @return the data element at the index
     * @throws IndexOutOfBoundsException
     *          if index < 0 or index >= size()
     */
    public E get(int index) throws IndexOutOfBoundsException;
    
    /*
     * Replace the data element at the specified index with th especified Object
     * 
     * @param index
     *          The index of the element to be replaced
     * @param element
     *          The new data element to store at the specified index
     * @throws IndexOutOfBoundsException
     *          if index < 0 or index >= size()
     */
    public void set(int index, E element) throws IndexOutOfBoundsException;
    
    /*
     * Insert the specified data element before the one found at index. The 
     * newly inserted data element will not be found at the specified index. 
     * All elements at index index and higher have their index increased by one. 
     * 
     * N.B: It is possible to insert at the end of a list by giving the index 
     * equal to size()
     * 
     * @param index
     *          The index at which to insert the new element
     * @param element
     *          The new data element to be inserted
     * @throws IndexOutOfBoundsException
     *          if index < 0 or index >= size()
     */
    public void insert(int index, E element) throws IndexOutOfBoundsException;
    
    /*
     * Remove and return the data element at the specified index. All elements 
     * at index and higher have their index decreased by one.
     * 
     * @param index
     *          The index from which to remove the data
     * @return the element found at index
     * @throws IndexOutOfBoundsException
     *          if index < 0 or index >= size()
     */         
    public E remove(int index) throws IndexOutOfBoundsException;
}
