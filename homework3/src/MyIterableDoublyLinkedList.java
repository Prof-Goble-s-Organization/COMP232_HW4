import java.util.NoSuchElementException;

public class MyIterableDoublyLinkedList<E> implements MyList<E>, MyIterable<E> {
    private DLLNode head;
    private DLLNode tail;
    private int size;

    public MyIterableDoublyLinkedList() {
        head = new DLLNode(null, null, null);
        tail = new DLLNode(null, head, null);
        size = 0;
        head.next = tail;
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return size();
    }

    /**
     * {@inheritDoc}
     */
    public void add(E element) {
        DLLNode pred = tail.prev;
        DLLNode node = new DLLNode(element, pred, tail);
        pred.next = node;
        tail.prev = node;

        size++;
    }

    private DLLNode getNode(int index) {
        checkBounds(index);
        DLLNode curr = head.next;
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    /**
     * Helper method that throws an excpetion if the index is not valid
     * 
     * @param index
     */
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index 
                        + " on List of size " + size + ".");
        }
    }

    public E get(int index) throws IndexOutOfBoundsException {
        DLLNode node = getNode(index);
        if (node != null) {
            return node.element;
        }  else {
            return null;
        }
    }

    public void set(int index, E element) throws IndexOutOfBoundsException {
        DLLNode node = getNode(index);
        node.element = element;
    }

    public void insert(int index, E element) throws IndexOutOfBoundsException {
        DLLNode succ = tail;
        if(index != size) {
            succ = getNode(index);
        }

        DLLNode node = new DLLNode(element, succ.prev, succ);
        succ.prev.next = node;
        succ.prev = node;

        size++;
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        // Intentionally not implemented, see HW assignment
        return null;
    }

    private class DLLNode {
        public E element;
        public DLLNode prev;
        public DLLNode next;

        public DLLNode(E element, DLLNode prev, DLLNode next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * {@inheritDoc}
     */
    public MyIterator<E> getIterator() {
        return new DLLIterator();
    }

    private class DLLIterator implements MyIterator<E> {
        private DLLNode cursor;

        public DLLIterator() {
            cursor = head;
        }

        public boolean hasNext() {
            return cursor.next != tail;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no next element!");
            } else {
                cursor = cursor.next;
                return cursor.element;
            }
        }

        public boolean hasPrevious() {
            // Intentionally not implemented, see homework assignment
            throw new UnsupportedOperationException("Not implemented");
        }

        public E previous() {
            // Intentionally not implemented, see homework assignment
            throw new UnsupportedOperationException("Not implemented");
        }

        public void insert(E element) {
            DLLNode node = new DLLNode(element, cursor, cursor.next);
            cursor.next.prev = node;
            cursor.next = node;
            cursor = node;
            size++;
        }

        public E remove() {
            // Intentionally not implemented, see homework assignment
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /**
     * Helper method for testing that checks that all of the links are symmetric
     * 
     * @return
     *          true is all of the links are correct, false otherwise
     */
    public boolean checkListIntegrity() {
        if(size == 0) {
            return head.next == tail && tail.prev == head;
        } else {
            DLLNode curr = head.next;

            while(curr.next != tail) {
                DLLNode previous = curr.prev;
                DLLNode next = curr.next;

                if (previous.next != curr || next.prev != curr) {
                    return false;
                }

                curr = curr.next;
            }
        }
        return true;
    }
}
