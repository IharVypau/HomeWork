package home_work_4.runners;

import home_work_4.DataContainer;
import home_work_4.sorts.SortByStringLenghtComparator;
import home_work_4.sorts.SortByNumberComparator;

import java.util.Arrays;

public class DataContainerMain {
    public static void main(String[] args) {
        DataContainer<String> container1 = new DataContainer<>(new String[]{"i", "hello", "1", "Как домашка"});
        DataContainer<Integer> container2 = new DataContainer<>(new Integer[0]);
        container2.add(2);
        container2.add(4);
        container2.add(1);
        container2.add(3);
        DataContainer.sort(container1, new SortByStringLenghtComparator());
        container2.sort(new SortByNumberComparator());
        //DataContainer.sort(container1);
        DataContainer.sort(container2);
        System.out.println(container1);
        System.out.println(container2);

    }
}
