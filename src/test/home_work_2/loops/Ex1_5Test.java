package test.home_work_2.loops;

import home_work_2.loops.Ex1_4;
import home_work_2.loops.Ex1_5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ex1_5Test {
    @Test
    public void calculateLastNumberBeforeOverflow(){
        Assertions.assertEquals(2218611106740436992L, Ex1_4.calculateLastNumberBeforeOverflow(12L));
        Assertions.assertEquals(3243919932521508681L, Ex1_4.calculateLastNumberBeforeOverflow(-21L));
    }
    @Test
    public void getNaturalNumber(){
        Assertions.assertEquals(3, Ex1_5.getMaxNaturalDigit(1232));
        Assertions. assertEquals(9, Ex1_5.getMaxNaturalDigit(197));
    }

    @Test
    public void getStatisticsOfEvenNumbers(){
        Assertions.assertEquals(0.0, Ex1_5.getStatisticsOfEvenNumbers(),100.0);
    }

    @Test
    public void countEvenOrOddNums(){
        Assertions.assertEquals(2, Ex1_5.countEvenOrOddNums(3223,true));
        Assertions.assertEquals(1, Ex1_5.countEvenOrOddNums(200,false));
        Assertions.assertEquals(0, Ex1_5.countEvenOrOddNums(200,true));
    }
    @Test
    public void countFibonacci(){
        Assertions.assertEquals("1 2 3 5 8 13 21 34", Ex1_5.countFibonacci(123,8));
        Assertions.assertEquals("1 2", Ex1_5.countFibonacci(123,2));
    }


    @Test
    public void showRowOfNumsWithStep(){
        Assertions.assertEquals("3 5 7 9 11 13", Ex1_5.showRowOfNumsWithStep(3,15,2));
        Assertions.assertEquals("-23 -20 -17 -14 -11 -8 -5 -2 1", Ex1_5.showRowOfNumsWithStep(-23,2, 3));
    }
    @Test
    public void showReverseNumber(){
        Assertions.assertEquals("987654321", Ex1_5.showReverseNumber(123456789));
        Assertions.assertEquals("123456789", Ex1_5.showReverseNumber(987654321));
    }
}
