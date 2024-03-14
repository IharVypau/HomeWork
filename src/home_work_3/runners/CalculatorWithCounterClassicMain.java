package home_work_3.runners;

import home_work_3.additional.CalculatorWithCounterClassic;

public class CalculatorWithCounterClassicMain {
    public static void main(String[] args) {
        CalculatorWithCounterClassic calc = new CalculatorWithCounterClassic();
        double x1 = calc.division(28, 5);
        calc.incrementCountOperation();
        double x2 = calc.pow(x1,2);
        calc.incrementCountOperation();
        double x3 = calc.multiplication(15, 7);
        calc.incrementCountOperation();
        double x4 = calc.addition( 4.1, x3);
        calc.incrementCountOperation();
        double result = calc.addition(x4, x2);
        calc.incrementCountOperation();
        System.out.print("Result = "+ result + ", count of operations = "+ calc.getCountOperation());
    }
}
