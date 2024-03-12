package home_work_3.runners;

import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithOperatorMain {
    public static void main(String[] args) {
        CalculatorWithOperator cl = new CalculatorWithOperator();
        System.out.println(cl.addition(cl.addition(14.1, cl.multiplication(15 , 7)),
                cl.pow(cl.division(28.0, 5), 2)));

    }

}
