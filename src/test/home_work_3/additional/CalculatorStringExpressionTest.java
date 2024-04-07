package test.home_work_3.additional;

import home_work_3.additional.CalculatorStringExpression;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorStringExpressionTest {
    private CalculatorStringExpression calculator = new CalculatorStringExpression(new CalculatorWithMathCopy());

    @DisplayName("CalculatorStringExpressionTest")
    @Test
    public void calculate(){
        Assertions.assertTrue(calculator.isCorrect("4.1 + 15 * 7 + (28 / 5) ^ 2"));
        Assertions.assertEquals(140.45999999999998, calculator.calculate("4.1 + 15 * 7 + (28 / 5) ^ 2"),0.0);
        Assertions.assertEquals(107.57636, calculator.calculate("4 + (5 * 7 + (4 / 2)) * E +3"),0.0);
        Assertions.assertEquals(165.06, calculator.calculate("((4.1 + 15) * 7) + (28 / 5) ^ 2"),0.0);
        Assertions.assertEquals(23.3, calculator.calculate("((4 + 1) * PI) + ((28 / 5)+2)"), 0.0);
    }

}
