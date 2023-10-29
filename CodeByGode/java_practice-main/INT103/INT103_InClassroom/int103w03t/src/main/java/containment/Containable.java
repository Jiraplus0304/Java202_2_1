package containment;

public interface Containable<T> {
    public boolean add(T t);
    public T get(T t);
    public void sort();
}
