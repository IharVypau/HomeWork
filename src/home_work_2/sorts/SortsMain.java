package home_work_2.sorts;

import home_work_2.utils.ArraysUtils;
import home_work_2.utils.SortsUtils;

public class SortsMain {
    static final int MAX_VALUE_EXCLUSION = 100;
    static final int ARRAY_SIZE = 10;
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int[] array2 = {1,1,1,1};
        int[] array3 = {9,1,5,99,9,9};
        int[] array4 = {};
        int[] array5 = {6,5,4,3,2,1};
        SortsUtils.sort(array1);
        SortsUtils.shake(array1);
        SortsUtils.sort(array2);
        SortsUtils.shake(array2);
        SortsUtils.sort(array3);
        SortsUtils.shake(array3);
        SortsUtils.sort(array4);
        SortsUtils.shake(array5);
        SortsUtils.sort(array5);
        SortsUtils.shake(array5);
        SortsUtils.sort(ArraysUtils.arrayRandom(ARRAY_SIZE, MAX_VALUE_EXCLUSION));
        SortsUtils.shake(ArraysUtils.arrayRandom(ARRAY_SIZE, MAX_VALUE_EXCLUSION));
        SortsUtils.sort(ArraysUtils.arrayFromConsole());
        SortsUtils.shake(ArraysUtils.arrayFromConsole());
    }
}
