package home_work_5.utils;

import java.util.Comparator;
import java.util.List;

public class SortUtil {
    public static <T> void insertionSort(List<T> list, Comparator<T> comp) {
        int idx;
        T min;
        for (int i = 1; i < list.size(); i++) {
            idx = i;
            min = list.get(i);
            while (idx > 0 && comp.compare(list.get(idx - 1), min) > 0) {
                list.set(idx, list.get(idx - 1));
                idx--;
            }
            list.set(idx, min);
        }
    }
}
