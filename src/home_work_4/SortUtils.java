package home_work_4;

import java.util.Comparator;

public class SortUtils<T> {
    public static <T> void mixSort(Comparator<T> comparator, T[] data) {
        int first = 0, last = data.length - 1, lastIndex;
        while (first < last) {
            lastIndex = -1;
            for (int i = first; i < last; i++) {
                if (comparator.compare(data[i], data[i + 1]) > 0) {
                    swap(i, i + 1, data);
                    lastIndex = i;
                }
            }
            last = lastIndex;
            lastIndex = data.length + 1;
            for (int i = last; i > first; i--) {
                if (comparator.compare(data[i - 1], data[i]) > 0) {
                    swap(i, i - 1, data);
                    lastIndex = i;
                }
            }
            first = lastIndex;
        }
    }

    public static <T extends Comparable<T>> void mixSort(T[] data) {
        int first = 0, last = data.length - 1, lastIndex;
        while (first < last) {
            lastIndex = -1;
            for (int i = first; i < last; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(i, i + 1, data);
                    lastIndex = i;
                }
            }
            last = lastIndex;
            lastIndex = data.length + 1;
            for (int i = last; i > first; i--) {
                if (data[i - 1].compareTo(data[i]) > 0) {
                    swap(i, i - 1, data);
                    lastIndex = i;
                }
            }
            first = lastIndex;
        }
    }

    private static <T> void swap(int idx1, int idx2, T[] data) {
        T tmp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = tmp;
    }

}



