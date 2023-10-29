package containment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container<T> implements Iterable<T> {
    private static final int SIZE = 5;
    private final T[] box = (T[]) new Object[SIZE];
    private int count;
    private int modCount;

    @Override public Iterator<T> iterator() { 
        return new Iterator() {
            private int cur;
            private final int modCount = Container.this.modCount;
            @Override public boolean hasNext() { 
                if (modCount != Container.this.modCount) throw new ConcurrentModificationException();
                return cur != count; 
            }
            @Override public T next() { 
                if (modCount != Container.this.modCount) throw new ConcurrentModificationException();
                if (cur >= count) throw new NoSuchElementException();
                return box[cur++]; 
            }
        };
    }
    
    public boolean add(T t) {
        if (t == null || count == SIZE) return false;
        box[count++] = t;
        modCount++;
        return true;
    }
    
    public T delete(T t) {
        int i = locate(t);
        if (i == -1) return null;
        T x = box[i];
        box[i] = box[--count];
        box[count] = null;
        modCount++;
        return x;
    }
    
    public T find(T t) {
        int i = locate(t);
        return i == -1 ? null : box[i];
    }    
    
    private int locate(T t) {
        if (t == null) return -1;
        for (int i = 0; i < count; i++) {
            if (box[i].equals(t)) return i;
        }
        return -1;
    }
    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("Container[");
        for (int i = 0; i < count; i++) {
            sb.append("\n  ").append(box[i]);
        }
        sb.append("]");
        return sb.toString();
    }
    
    public Container sort() {
        if (count < 2) return this;
        Arrays.sort(box,0,count);
        modCount++;
        return this;
    }
    
    public Container sort(Comparator<T> comp) {
        if (count >= 2) {
            Arrays.sort(box,0,count, comp);
            modCount++;
        }
        return this;
    }
}
