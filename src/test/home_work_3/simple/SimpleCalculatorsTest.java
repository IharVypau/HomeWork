package test.home_work_3.simple;

import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleCalculatorsTest {
    private CalculatorWithMathExtends calc1 = new CalculatorWithMathExtends();
    private CalculatorWithOperator calc2 = new CalculatorWithOperator();
    private CalculatorWithMathCopy calc3 = new CalculatorWithMathCopy();

    @DisplayName("CalculatorWithMathExtends")
    @Test
    public void calculate1(){
        Assertions.assertEquals(140.45999999999998, calc1.addition(
                calc1.addition(4.1, calc1.multiplication(15, 7)),
                calc1.pow(calc1.division(28, 5), 2)), 0.0);
    }

    @DisplayName("CalculatorWithOperator")
    @Test
    public void calculate2(){
        Assertions.assertEquals(140.45999999999998, calc2.addition(
                calc2.addition(4.1, calc2.multiplication(15, 7)),
                calc2.pow(calc2.division(28, 5), 2)), 0.0);
    }

    @DisplayName("CalculatorWithMathCopy")
    @Test
    public void calculate3(){
        Assertions.assertEquals(140.45999999999998, calc3.addition(
                calc3.addition(4.1, calc3.multiplication(15, 7)),
                calc3.pow(calc3.division(28, 5), 2)), 0.0);
    }
}
