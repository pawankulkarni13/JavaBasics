package programs;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * "Flattens" nested sub-iterators into an iterator in a depth-first manner.
 *
 * Requirements:
 *  - Limit the amount of additional consumed memory to O(1).
 *
 * Example: an iterator {{1,2},{3},{4,5}} which has three sub-iterators with
 * 2, 1 and 2 elements correspondingly, presents values in this order:
 * {1, 2, 3, 4, 5}
 */

/**
 * Approach :
 *
 * @param <E>
 */
public class IteratorFlattener<E> implements Iterator<E> {

    private Iterator<Iterator<E>> iterator;
    private Iterator<E> eIterator;

    public IteratorFlattener(Iterator<Iterator<E>> root) {
        if(null==root){
            throw new NullPointerException();
        }
        this.iterator = root;
        eIterator = null;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     *
     * @return {@code true} if the iteration has more elements
     */
    public boolean hasNext() {
        if(eIterator == null){
            if(!iterator.hasNext())
                return false;
            else
                eIterator = iterator.next();
        }
        while(iterator.hasNext() && !eIterator.hasNext())
            eIterator = iterator.next();

        return eIterator.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    public E next() {
        return eIterator.next();
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation). This method can be called
     * only once per call to {@link #next}.
     *
     * @throws IllegalStateException if the {@code next} method has not
     *         yet been called, or the {@code remove} method has already
     *         been called after the last call to the {@code next}
     *         method
     */
    public void remove() {
        iterator.remove();
    }
}

