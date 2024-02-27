package HomeWork_2.sorts;

import HomeWork_2.utils.ArraysUtils;
import HomeWork_2.utils.SortsUtils;

import java.util.Random;

public class SortsMain {
    static final int MAX_VALUE_EXCLUSION = 100;
    static final int ARRAY_SIZE = 10;
    public static void main(String[] args) {
        SortsUtils.sort(new int[]{1,2,3,4,5,6});
        SortsUtils.shake(new int[]{1,2,3,4,5,6});
        SortsUtils.sort(new int[]{1,1,1,1});
        SortsUtils.shake(new int[]{1,1,1,1});
        SortsUtils.sort(new int[]{9,1,5,99,9,9});
        SortsUtils.shake(new int[]{9,1,5,99,9,9});
        SortsUtils.sort(new int[]{});
        SortsUtils.shake(new int[]{});
        SortsUtils.sort(new int[]{6,5,4,3,2,1});
        SortsUtils.shake(new int[]{6,5,4,3,2,1});
        SortsUtils.sort(ArraysUtils.arrayRandom(ARRAY_SIZE, MAX_VALUE_EXCLUSION));
        SortsUtils.shake(ArraysUtils.arrayRandom(ARRAY_SIZE, MAX_VALUE_EXCLUSION));
        SortsUtils.sort(ArraysUtils.arrayFromConsole());
        SortsUtils.shake(ArraysUtils.arrayFromConsole());
    }
}
