package test.home_work_2.loops;

import home_work_2.loops.Ex1_1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ex1_1Test {
    @Test
    public void calculateUsingLoop(){
        Assertions.assertEquals(120, Ex1_1.calculateUsingLoop(5L));
    }
    public void calculateUsingRecursion(){
        Assertions.assertEquals(120,Ex1_1.calculateUsingRecursion(5L));
    }
}
