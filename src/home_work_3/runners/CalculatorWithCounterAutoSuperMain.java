package home_work_3.runners;

import home_work_3.additional.CalculatorWithCounterAutoSuper;
import home_work_3.additional.CalculatorWithCounterClassic;

public class CalculatorWithCounterAutoSuperMain {
    public static void main(String[] args) {
        CalculatorWithCounterAutoSuper calc = new CalculatorWithCounterAutoSuper();
        double result =   calc.addition((calc.addition( 4.1, calc.multiplication(15, 7))), calc.pow(calc.division(28, 5),2));
        System.out.printf("Result =  %.2f, count of operations = %d%n", result, calc.getCountOperation());
    }
}
