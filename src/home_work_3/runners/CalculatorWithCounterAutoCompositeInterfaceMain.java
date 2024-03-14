package home_work_3.runners;

import home_work_3.additional.CalculatorWithCounterAutoAgregationInterface;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathCopy;

public class CalculatorWithCounterAutoCompositeInterfaceMain {
    public static void main(String[] args) {
        CalculatorWithCounterAutoAgregationInterface calc =
                new CalculatorWithCounterAutoAgregationInterface(new CalculatorWithMathCopy());
        double result = calc.addition((calc.addition(4.1, calc.multiplication(15, 7))), calc.pow(calc.division(28, 5), 2));
        System.out.printf("Result =  %.2f, count of operations = %d%n", result, calc.getCountOperation());
    }
}
