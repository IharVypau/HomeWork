package home_work_3.runners;

import home_work_3.additional.CalculatorWithCounterAutoAgregation;
import home_work_3.calcs.simple.CalculatorWithMathCopy;

public class CalculatorWithCounterDelegateAgregationMain {
    public static void main(String[] args) {
        CalculatorWithCounterAutoAgregation calc = new CalculatorWithCounterAutoAgregation(new CalculatorWithMathCopy());
        double result = calc.addition((calc.addition(4.1, calc.multiplication(15, 7))), calc.pow(calc.division(28, 5), 2));
        System.out.print("Result = " + result + ", count of operations = " + calc.getCountOperation());
    }
}
