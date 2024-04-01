package home_work_4;

import home_work_4.utils.SortUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class DataContainer<T> implements Iterable<T> {
    private static final String ERROR_INSERT_NULL_MSG = "Данный элемент == null, в наш контейнер вставлять нельзя";
    private static final int MIN_STRING_ARRAY_LENGTH = 3;
    private T[] data;
    private int numOfElements = 0;
    private int cursor = 0;

    public DataContainer(T[] data) {
        this.data = data;
        numOfElements = data.length;
    }

    public int add(T item) {
        if (item == null) {
            System.out.println(ERROR_INSERT_NULL_MSG);
            return -1;
        }
        for (T value : this) {
            if (value == null) {
                break;
            }
            cursor++;
        }
        if (cursor == data.length) {
            data = Arrays.copyOf(data, data.length + 1);
            numOfElements++;
        }
        data[cursor] = item;
        return cursor;
    }

    public T get(int index) {
        if (index >= data.length) {
            return null;
        }
        return data[index];
    }

    public T[] getItems() {
        return data;
    }

    public boolean delete(int index) {
        if (!isEmpty() && numOfElements > index) {
            deleteItemFromData(index);
            numOfElements--;
            return true;
        }
        return false;
    }

    public boolean delete(T item) {
        if (!isEmpty() && item != null) {
            for (int i = 0; i < data.length; i++) {
                if (Objects.equals(data[i], item)) {
                    deleteItemFromData(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void sort(Comparator<T> comparator) {
        SortUtils.mixSort(comparator, data);
    }

    public static <T extends Comparable<T>> void sort(DataContainer<T> container) {
        SortUtils.mixSort(container.getItems());
    }

    public static <T> void sort(DataContainer<T> container, Comparator<T> comparator) {
        SortUtils.mixSort(comparator, container.getItems());
    }

    private void deleteItemFromData(int deleteIndex) {
        for (int i = deleteIndex; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data = Arrays.copyOf(data, data.length - 1);
    }

    private boolean isEmpty() {
        return numOfElements == 0;
    }

    public String toString() {
        Iterator<T> it = this.iterator();
        String output = "[";
        while (it.hasNext()) {
            T item = it.next();
            if (item != null) {
                output += item + ", ";
            }
        }
        if (output.length() > MIN_STRING_ARRAY_LENGTH) {
            output = output.substring(0, (output.length() - 2));
        }
        output += "]";
        return output;
    }

    public Iterator<T> iterator() {
        return new DataContainerIterator<>(data);
    }
}
