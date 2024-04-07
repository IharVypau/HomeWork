package test.home_work_2.loops;

import home_work_2.loops.Ex1_4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ex1_4Test {
    @Test
    public void calculateLastNumberBeforeOverflow(){
        Assertions.assertEquals(1.0E18, Ex1_4.calculateLastNumberBeforeOverflow(10), 0.0);
    }
}
