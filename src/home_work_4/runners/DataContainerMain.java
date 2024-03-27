package home_work_4.runners;

import home_work_4.DataContainer;
import home_work_4.sorts.SortByStringLenghtComparator;
import home_work_4.sorts.SortByNumberComparator;

import java.util.Arrays;
import java.util.Comparator;

public class DataContainerMain {
    public static void main(String[] args) {
        DataContainer<String> container = new DataContainer<>(new String[0]);
        DataContainer<Integer> container2 = new DataContainer<>(new Integer[0]);
        int index1 = container.add("i");
        int index2 = container.add("hello");
        int index3 = container.add("1");
        int index4 = container.add("Как домашка");
        container2.add(2);
        container2.add(4);
        container2.add(1);
        container2.add(3);
        container2.sort(new SortByNumberComparator());
        System.out.println(Arrays.toString(container.getItems()));
        System.out.println(Arrays.toString(container2.getItems()));

    }
}
