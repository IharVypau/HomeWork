package home_work_3.runners;

import home_work_3.additional.CalculatorWithCounterAutoAgregation;
import home_work_3.additional.CalculatorWithCounterAutoChoiceAgregation;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterDelegateChoiceAgregationMain {
    public static void main(String[] args) {
        CalculatorWithCounterAutoChoiceAgregation calc =
                new CalculatorWithCounterAutoChoiceAgregation(new CalculatorWithOperator());
        CalculatorWithCounterAutoChoiceAgregation calc2 =
                new CalculatorWithCounterAutoChoiceAgregation(new CalculatorWithMathCopy());
        CalculatorWithCounterAutoChoiceAgregation calc3 =
                new CalculatorWithCounterAutoChoiceAgregation(new CalculatorWithMathExtends());
        double result = calc.addition((calc.addition(4.1, calc.multiplication(15, 7))), calc.pow(calc.division(28, 5), 2));
        double result2 = calc2.addition((calc2.addition(4.1, calc2.multiplication(15, 7))), calc2.pow(calc2.division(28, 5), 2));
        double result3 = calc3.addition((calc3.addition(4.1, calc3.multiplication(15, 7))), calc3.pow(calc3.division(28, 5), 2));
        System.out.printf("Result(CalculatorWithOperator) =  %.2f, count of operations = %d%n", result, calc.getCountOperation());
        System.out.printf("Result(CalculatorWithMathCopy) =  %.2f, count of operations = %d%n", result2, calc2.getCountOperation());
        System.out.printf("Result(CalculatorWithMathCopy) =  %.2f, count of operations = %d%n", result3, calc3.getCountOperation());
    }
}
