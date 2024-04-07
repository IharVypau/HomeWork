package test.home_work_1;

import home_work_1.Excercise4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Excercise4Test {
    private final Excercise4 ex4 = new Excercise4();

    @Test
    public void getOddNumber() {
        Assertions.assertEquals(-3, ex4.getOddNumber(-2, -3));
        Assertions.assertEquals(5, ex4.getOddNumber(2, 5));
        Assertions.assertEquals(1, ex4.getOddNumber(0, 1));
    }
    @Test
    public void getAverage(){
        Assertions.assertEquals(-1, ex4.getAverage(-1, -4, 4));
        Assertions.assertEquals(0, ex4.getAverage(-1, 0, 1));
        Assertions.assertEquals(1, ex4.getAverage(-1, 3, 1));
    }
    @Test
    public void checkDivisionOfTwoNumbers() {
        Assertions.assertTrue(ex4.checkDivisionOfTwoNumbers(2, 2));
        Assertions.assertTrue(ex4.checkDivisionOfTwoNumbers(0, 2));
        Assertions.assertTrue(ex4.checkDivisionOfTwoNumbers(-2, 2));
    }
    @Test
    public void convertByteToKBytes() {
        Assertions.assertEquals(2.0, ex4.convertByteToKBytes(2048), 0.0);
    }

    @Test
    public void isLetter() {
        Assertions.assertTrue(ex4.isLetter('a'));
        Assertions.assertTrue(ex4.isLetter('Z'));
    }
    @Test
    public void isLeapYear() {
        Assertions.assertTrue(ex4.isLeapYear(1700));
        Assertions.assertTrue(ex4.isLeapYear(2024));
    }

}
