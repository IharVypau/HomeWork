package test.home_work_2.loops;

import home_work_2.loops.Ex1_3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ex1_3Test {
    @Test
    public void calculatePow(){
        Assertions.assertEquals(144.0, Ex1_3.calculatePow(12.0, 2), 0.0);
    }
}
