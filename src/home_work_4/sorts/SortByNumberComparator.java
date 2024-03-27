package home_work_4.sorts;

import java.util.Comparator;

public class SortByNumberComparator implements Comparator<Integer> {

    public int compare(Integer num1, Integer num2) {
        return num1 - num2;
    }
}
