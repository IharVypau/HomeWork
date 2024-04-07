package test.home_work_2.arrays;

import home_work_2.arrays.Ex2_4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Ex2_4Test {
    private Ex2_4 exe = new Ex2_4();

    @Test
    public void getSumEvenPositiveElements() {
        Assertions.assertEquals(17, exe.getSumEvenPositiveElements(new int[]{4, 17, 32}));
        Assertions.assertEquals(6, exe.getSumEvenPositiveElements(new int[]{1, 2, 3, 4}));
        Assertions.assertEquals(0, exe.getSumEvenPositiveElements(new int[]{1, -2, 3, -4}));
    }

    @Test
    public void getMaxEvenElementFromArray() {
        assertEquals(32, exe.getMaxEvenElementFromArray(new int[]{4, 17, 32}));
        assertEquals(3, exe.getMaxEvenElementFromArray(new int[]{1, 2, 3, 4}));
        assertEquals(-1, exe.getMaxEvenElementFromArray(new int[]{-1, -2, -4, -4}));
    }

    @Test
    public void getElementsLessAverage() {
        assertEquals("4, 17", exe.getElementsLessAverage(new int[]{4, 17, 32}));
        assertEquals("1, 2", exe.getElementsLessAverage(new int[]{1, 2, 3, 4}));
        assertEquals("-1, -2, -4", exe.getElementsLessAverage(new int[]{-1, -2, -4, 5}));
    }

    @Test
    public void getTwoMinElementsFromArray() {
        assertEquals("4, 17", exe.getTwoMinElementsFromArray(new int[]{4, 17, 32}));
        assertEquals("1, 2", exe.getTwoMinElementsFromArray(new int[]{1, 2, 3, 4}));
        assertEquals("-4, -2", exe.getTwoMinElementsFromArray(new int[]{-1, -2, -4, 5}));
    }

    @Test
    public void removeElementsInInterval() {
        assertEquals("[4, 17, 32]", exe.removeElementsInInterval(new int[]{4, 17, 32}, 1, 2));
        assertEquals("[3, 4, 0, 0]", exe.removeElementsInInterval(new int[]{1, 2, 3, 4}, 0, 2));
        assertEquals("[-4, 4, 0, 0]", exe.removeElementsInInterval(new int[]{-1, -2, -4, 4}, -2, 2));
    }


}
