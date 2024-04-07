package test.home_work_1;

import home_work_1.Excercise7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Excercise7Test {
    @Test
    public void checkDivisionOfTwoNumbers() {
        Assertions.assertEquals("(123) 456-7890", Excercise7.createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

}
