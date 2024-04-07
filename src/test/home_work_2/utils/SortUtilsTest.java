package test.home_work_2.utils;

import home_work_2.utils.SortsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortUtilsTest {

    @Test
    public void bubbleSort2() {
        Assertions.assertEquals(Arrays.toString(new int[]{0, 1, 2, 3, 6, 23}), Arrays.toString(SortsUtils.sort(new int[]{23, 1, 3, 6, 2, 0})));
        Assertions.assertEquals(Arrays.toString(new int[]{-10, -1, 0, 1, 2, 3, 6, 23}), Arrays.toString(SortsUtils.sort(new int[]{23, 1, 3, -10,-1, 6, 2, 0})));
    }

    @Test
    public void shakerSort() {
        assertEquals(Arrays.toString(new int[]{0, 1, 2, 3, 6, 23}), Arrays.toString(SortsUtils.shake(new int[]{23, 1, 3, 6, 2, 0})));
        assertEquals(Arrays.toString(new int[]{-10, -1, 0, 1, 2, 3, 6, 23}), Arrays.toString(SortsUtils.shake(new int[]{23, 1, 3, -10,-1, 6, 2, 0})));
    }

}
