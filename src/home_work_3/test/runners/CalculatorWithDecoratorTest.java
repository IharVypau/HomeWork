package home_work_3.test.runners;

import home_work_3.additional.CalculatorWithCounterAutoDecorator;
import home_work_3.additional.CalculatorWithMemoryDecorator;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorWithDecoratorTest {
    private ICalculator calc = new CalculatorWithCounterAutoDecorator(
            new CalculatorWithMemoryDecorator(new CalculatorWithMathExtends()));

    /**
     * 4.1 + 15 * 7 + (28 / 5) ^ 2
     */
    @Test
    public void calculate(){
        assertEquals(140.45999999999998, calc.addition(
                calc.addition(4.1, calc.multiplication(15, 7)),
                calc.pow(calc.division(28, 5), 2)), 0.0);


        CalculatorWithCounterAutoDecorator calcCounter = (CalculatorWithCounterAutoDecorator) calc;
        assertEquals(5, calcCounter.getCountOperation());
        CalculatorWithMemoryDecorator calcMemory = (CalculatorWithMemoryDecorator) calcCounter.getCalculator();
        calcMemory.save();
        assertEquals(140.45999999999998, calcMemory.load(),0.0);


    }
}
