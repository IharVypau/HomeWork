package home_work_3.test.additional;

import home_work_3.additional.CalculatorStringExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorStringExpressionTest {
    private CalculatorStringExpression calculator = new CalculatorStringExpression();

    @DisplayName("CalculatorStringExpressionTest")
    @Test
    public void calculate(){
        assertTrue(calculator.isCorrect("4.1 + 15 * 7 + (28 / 5) ^ 2"));
        assertEquals(140.45999999999998, calculator.calculate("4.1 + 15 * 7 + (28 / 5) ^ 2"),0.0);
        assertEquals(107.57636, calculator.calculate("4 + (5 * 7 + (4 / 2)) * E +3"),0.0);
        assertEquals(165.06, calculator.calculate("((4.1 + 15) * 7) + (28 / 5) ^ 2"),0.0);
        assertEquals(23.3, calculator.calculate("((4 + 1) * PI) + ((28 / 5)+2)"), 0.0);
    }

}
