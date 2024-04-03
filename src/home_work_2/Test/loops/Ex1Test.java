package home_work_2.Test.loops;


import home_work_2.arrays.*;
        import home_work_2.loops.*;
        import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ex1Test {

    @Test
    public void checkResultCalculatingFactorial(){
        assertEquals(479001600, Ex1_1.calculateUsingLoop(12L));
        assertEquals(2432902008176640000L, Ex1_1.calculateUsingLoop(20L));
        assertEquals("1 * 2 * 3 * 4 * 5 = 120", Ex1_1.getStringExpression(5, 120));
        assertEquals(120, Ex1_1.calculateUsingRecursion(5));
        assertEquals(Ex1_1.calculateUsingLoop(5L), Ex1_1.calculateUsingRecursion(5L));
    }

    @Test
    public void multiplyStringOfDigits(){
        assertEquals(24, Ex1_2.multiplyStringOfDigits("1234"));
        assertEquals(1, Ex1_2.multiplyStringOfDigits("11111"));
    }
    @Test
    public void calculatePow(){
        assertEquals(144.0, Ex1_3.calculatePow(12.0,2), 0.0);
        assertEquals(81.0, Ex1_3.calculatePow(-3,4), 0.0);
    }
    @Test
    public void calculateLastNumberBeforeOverflow(){
        assertEquals(8176589207175692288L, Ex1_4.calculateLastNumberBeforeOverflow(12L));
        assertEquals(5664657711886524163L, Ex1_4.calculateLastNumberBeforeOverflow(-21L));
    }
    @Test
    public void getNaturalNumber(){
        assertEquals(3, Ex1_5.getMaxNaturalDigit(1232));
        assertEquals(9, Ex1_5.getMaxNaturalDigit(197));
    }

    @Test
    public void getStatisticsOfEvenNumbers(){
        assertEquals(0.0, Ex1_5.getStatisticsOfEvenNumbers(),100.0);
    }

    @Test
    public void countEvenOrOddNums(){
        assertEquals(2, Ex1_5.countEvenOrOddNums(3223,true));
        assertEquals(1, Ex1_5.countEvenOrOddNums(200,false));
        assertEquals(0, Ex1_5.countEvenOrOddNums(200,true));
    }
    @Test
    public void countFibonacci(){
        assertEquals("1 2 3 5 8 13 21 34", Ex1_5.countFibonacci(123,8));
        assertEquals("1 2", Ex1_5.countFibonacci(123,2));
    }


    @Test
    public void showRowOfNumsWithStep(){
        assertEquals("3 5 7 9 11 13", Ex1_5.showRowOfNumsWithStep(3,15,2));
        assertEquals("-23 -20 -17 -14 -11 -8 -5 -2 1", Ex1_5.showRowOfNumsWithStep(-23,2, 3));
    }
    @Test
    public void showReverseNumber(){
        assertEquals("987654321", Ex1_5.showReverseNumber(123456789));
        assertEquals("123456789", Ex1_5.showReverseNumber(987654321));
    }

}

