package exam.base;

public class Group {

    private final Object[] objects;
    private int size;

    public Group(int capacity) {
        objects = new Object[size < 2 ? 2 : size];
    }

    public int getSize() {
        return size;
    }

    public boolean append(Object o) {
        if (o == null || size == objects.length) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (objects[i] == o) {
                return false;
            }
        }
        objects[size++] = o;
        return true;
    }

    public int find(Object o) {
        for (int i = 0; i < size; i++) {
            if (objects[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Object o) {
        int x = find(o);
        if (x == -1) {
            return false;
        }
        size--;
        if (x < size) {
            objects[x] = objects[size];
        }
        objects[size] = null;
        return true;
    }

    public Object get(int i) {
        if (i > -1 && i < size) {
            return objects[i];
        }
        return null;
    }
}
