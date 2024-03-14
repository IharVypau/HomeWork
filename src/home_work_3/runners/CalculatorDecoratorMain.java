package home_work_3.runners;

import home_work_3.additional.CalculatorWithCounterAutoDecorator;
import home_work_3.additional.CalculatorWithCounterClassic;
import home_work_3.additional.CalculatorWithMemoryDecorator;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorDecoratorMain {
    public static void main(String[] args) {
        CalculatorWithMathExtends calcMathExtends = new CalculatorWithMathExtends();
        ICalculator calc = new CalculatorWithCounterAutoDecorator( new CalculatorWithMemoryDecorator(calcMathExtends));
        double result = calc.addition( calc.addition(4.1, calc.multiplication(15, 7)), calc.pow( calc.division(28, 5), 2));
        System.out.printf("Result =  %.2f%n", result);
        System.out.printf("Count of operations = %d%n", ((CalculatorWithCounterAutoDecorator) calc).getCountOperation());
        calc = ((CalculatorWithCounterAutoDecorator) calc).getCalculator();
        /*
        * В данном случае instanceof проверяет, был ли объект на который ссылается переменная calc
        * создан на основе класса CalculatorWithMemoryDecorator
         * */
        if (calc instanceof CalculatorWithMemoryDecorator) {
            ((CalculatorWithMemoryDecorator) calc).save();
            System.out.printf("Last operation result =  %.2f%n", ((CalculatorWithMemoryDecorator) calc).load());
            calc = ((CalculatorWithMemoryDecorator) calc).getCalculator();
        }
        /*
         * instanceof проверяет, был ли объект на который ссылается переменная calc
         * создан на основе класса CalculatorWithMathExtends
         * */
        if (calc instanceof CalculatorWithMathExtends) {
            calc = new CalculatorWithCounterClassic();
        }

    }
}
