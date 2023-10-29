package int103w07t;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImIterable<E> implements Iterable<E> {
    private final E[] array; // unmodifiable collection

    public ImIterable(E[] array) { this.array = Arrays.copyOf(array, array.length); }
   
    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            private int cursor;

            @Override public boolean hasNext() { return cursor < array.length; }

            @Override public Object next() { 
                if (cursor < array.length) return array[cursor++];
                throw new NoSuchElementException();
            }
        };
    }
    
}
