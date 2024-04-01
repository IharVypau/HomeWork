package home_work_4.utils.comparators;

import java.util.Comparator;

public class StringLenghtComparator implements Comparator<String> {
    public int compare(String str1, String str2) {
        return str1.length() - str2.length();
    }
}
