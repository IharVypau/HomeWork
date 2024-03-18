package home_work_3.runners;

import home_work_3.additional.CalculatorWithCounterAutoDecorator;
import home_work_3.additional.CalculatorWithCounterClassic;
import home_work_3.additional.CalculatorWithMemoryDecorator;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorDecoratorMain {
    public static void main(String[] args) {
        ICalculator calc = new CalculatorWithCounterAutoDecorator(
                new CalculatorWithMemoryDecorator(
                        new CalculatorWithMathExtends()));

        double result = calc.addition(calc.addition(4.1, calc.multiplication(15, 7)), calc.pow(calc.division(28, 5), 2));
        System.out.printf("Result =  %.2f%n", result);

        CalculatorWithCounterAutoDecorator calcCounter = (CalculatorWithCounterAutoDecorator) calc;
        System.out.printf("Count of operations = %d%n", calcCounter.getCountOperation());
        /*
         * В данном случае instanceof проверяет, был ли объект на который ссылается переменная calc
         * (возвращается после вызова calcCounter.getCalculator())
         * создан на основе класса CalculatorWithMemoryDecorator
         * */
        if (calcCounter.getCalculator() instanceof CalculatorWithMemoryDecorator calcMemory) {
            calcMemory.save();
            System.out.printf("Last operation result =  %.2f%n", calcMemory.load());
            /*
             * В данном случае instanceof проверяет, был ли объект на который ссылается переменная calc
             * (возвращается после вызова calcCounter.getCalculator())
             * создан на основе класса CalculatorWithMathExtends
             * */
            if (calcMemory.getCalculator() instanceof CalculatorWithMathExtends) {
                calc = new CalculatorWithCounterClassic();
            }
        }
    }
}
