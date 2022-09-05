package generics;

import java.util.Arrays;

public class List {
    private final Object[] items = new Object[10];
    private int count;

    public void add(Object item) {
        items[count++] = item;
    }

    public Object get(int index) {
        return items[index];
    }

    @Override
    public String toString() {
        return "items=" + Arrays.toString(items);
    }
}
