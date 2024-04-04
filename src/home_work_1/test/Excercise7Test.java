package home_work_1.test;

import home_work_1.Excercise7;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Excercise7Test {
    @Test
    public void checkDivisionOfTwoNumbers() {
        assertEquals("(123) 456-7890", Excercise7.createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

}
