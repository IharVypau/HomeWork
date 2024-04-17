package home_work_4;

import home_work_4.utils.SortUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataContainer<T> implements Iterable<T> {
    private static final String ERROR_INSERT_NULL_MSG = "Данный элемент == null, в наш контейнер вставлять нельзя";
    private static final String ARR_DELIMITER = ", ";
    private static final int MIN_STRING_ARRAY_LENGTH = 2;
    private T[] data;
    private int numOfElements = 0;

    public DataContainer(T[] data) {
        this.data = data;
        numOfElements = data.length;
    }

    public int add(T item) {
        int cursor = 0;
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
        if (cursor == numOfElements) {
            data = Arrays.copyOf(data, ++numOfElements);
        }
        data[cursor] = item;
        return cursor;
    }

    public T get(int index) {
        if (index < 0 || index >= data.length) {
            return null;
        }
        return data[index];
    }

    public T[] getItems() {
        return data;
    }

    public boolean delete(int idx) {
        if (isNotEmpty() && idx > 0 && idx < numOfElements) {
            remove(idx);
            return true;
        }
        return false;
    }

    public boolean delete(T item) {
        if (isNotEmpty() && item != null) {
            for (int idx = 0; idx < numOfElements; idx++) {
                if (Objects.equals(data[idx], item)) {
                    remove(idx);
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

    private void remove(int idx) {
        for (int i = idx; i < numOfElements - 1; i++) {
            data[i] = data[i + 1];
        }
        data = Arrays.copyOf(data, --numOfElements);
    }

    private boolean isNotEmpty() {
        return numOfElements > 0;
    }

    public Iterator<T> iterator() {
        return new DataContainerIterator<>(data);
    }

    public String toString() {
        Iterator<T> it = this.iterator();
        String output = "[";
        for (T value : this) {
            if (value != null) {
                output += value + ARR_DELIMITER;
            }
        }
        if (output.length() > MIN_STRING_ARRAY_LENGTH) {
            output = output.substring(0, (output.length() - MIN_STRING_ARRAY_LENGTH));
        }
        output += "]";
        return output;
    }
}