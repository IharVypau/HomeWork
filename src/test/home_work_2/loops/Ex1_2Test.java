package test.home_work_2.loops;

import home_work_2.loops.Ex1_2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ex1_2Test {
    @Test
    public void multiplyStringOfDigits(){
        Assertions.assertEquals(120, Ex1_2.multiplyStringOfDigits("12345"));
    }
}
