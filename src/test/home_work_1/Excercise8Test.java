package test.home_work_1;

import home_work_1.Excercise8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Excercise8Test {
    @Test
    public void intToBinaryString() {
        Assertions.assertEquals("11001011", Excercise8.toBinaryString(203));
        Assertions.assertEquals("1", Excercise8.toBinaryString(1));
        Assertions.assertEquals("11111111", Excercise8.toBinaryString(255));
    }

}
