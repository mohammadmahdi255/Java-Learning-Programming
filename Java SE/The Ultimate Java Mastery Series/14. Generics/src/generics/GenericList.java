package generics;

import java.util.Arrays;
import java.util.Iterator;

public class GenericList<T extends Comparable> implements Iterable<T> {
    private final T[] items;
    private int count;
    public GenericList(int size) {
        items = (T[]) new Comparable[size];
    }

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }

    @Override
    public String toString() {
        return "items=" + Arrays.toString(items);
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T> {
        private final GenericList<T> list;
        private int index;

        public ListIterator(GenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
