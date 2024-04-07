package test.home_work_3.runners;

import home_work_3.additional.CalculatorWithCounterAutoDecorator;
import home_work_3.additional.CalculatorWithMemoryDecorator;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorWithDecoratorTest {
    private ICalculator calc = new CalculatorWithCounterAutoDecorator(
            new CalculatorWithMemoryDecorator(new CalculatorWithMathExtends()));

    /**
     * 4.1 + 15 * 7 + (28 / 5) ^ 2
     */
    @Test
    public void calculate(){
        Assertions.assertEquals(140.45999999999998, calc.addition(
                calc.addition(4.1, calc.multiplication(15, 7)),
                calc.pow(calc.division(28, 5), 2)), 0.0);


        CalculatorWithCounterAutoDecorator calcCounter = (CalculatorWithCounterAutoDecorator) calc;
        Assertions.assertEquals(5, calcCounter.getCountOperation());
        CalculatorWithMemoryDecorator calcMemory = (CalculatorWithMemoryDecorator) calcCounter.getCalculator();
        calcMemory.save();
        Assertions.assertEquals(140.45999999999998, calcMemory.load(),0.0);


    }
}
