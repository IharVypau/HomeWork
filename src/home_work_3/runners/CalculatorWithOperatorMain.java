package home_work_3.runners;

import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithOperatorMain {
    CalculatorWithOperator calc = new CalculatorWithOperator();
    public static void main(String[] args) {
        CalculatorWithOperatorMain calc =new CalculatorWithOperatorMain();  ;
        System.out.printf("%.2f%n", calc.calculate());
    }
    public double calculate(){
        return calc.addition((calc.addition( 4.1, calc.multiplication(15, 7))), calc.pow(calc.division(28, 5),2));
    }

}
