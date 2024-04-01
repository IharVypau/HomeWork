package home_work_4;

import java.util.Arrays;
import java.util.Iterator;

public class DataContainerIterator<T> implements Iterator<T> {
    private int currentIdx = 0;
    private T[] data;

    DataContainerIterator(T[] data) {
        this.data = data;
    }

    public boolean hasNext() {
        return currentIdx < data.length;
    }

    public T next() {
        return data[currentIdx++];
    }

}
