package home_work_1.test;

import home_work_1.Excercise4;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Excercise4Test {
    private final Excercise4 ex4 = new Excercise4();

    @Test
    public void getOddNumber() {
        assertEquals(-3, ex4.getOddNumber(-2, -3));
        assertEquals(5, ex4.getOddNumber(2, 5));
        assertEquals(1, ex4.getOddNumber(0, 1));
    }
    @Test
    public void getAverage(){
        assertEquals(-1, ex4.getAverage(-1, -4, 4));
        assertEquals(0, ex4.getAverage(-1, 0, 1));
        assertEquals(1, ex4.getAverage(-1, 3, 1));
    }
    @Test
    public void checkDivisionOfTwoNumbers() {
        assertTrue(ex4.checkDivisionOfTwoNumbers(2, 2));
        assertTrue(ex4.checkDivisionOfTwoNumbers(0, 2));
        assertTrue(ex4.checkDivisionOfTwoNumbers(-2, 2));
    }
    @Test
    public void convertByteToKBytes() {
        assertEquals(2.0, ex4.convertByteToKBytes(2048), 0.0);
    }

    @Test
    public void isLetter() {
        assertTrue(ex4.isLetter('a'));
        assertTrue(ex4.isLetter('Z'));
    }
    @Test
    public void isLeapYear() {
        assertTrue(ex4.isLeapYear(1700));
        assertTrue(ex4.isLeapYear(2024));
    }

}
