package home_work_3.runners;

import home_work_3.additional.CalculatorWithCounterAutoComposite;

public class CalculatorWithCounterDelegateCompositeMain {
    public static void main(String[] args) {
        CalculatorWithCounterAutoComposite calc = new CalculatorWithCounterAutoComposite();
        double result =   calc.addition((calc.addition( 4.1, calc.multiplication(15, 7))), calc.pow(calc.division(28, 5),2));
        System.out.print("Result = "+ result + ", count of operations = "+ calc.getCountOperation());
    }
}

