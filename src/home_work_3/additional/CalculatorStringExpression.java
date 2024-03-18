package home_work_3.additional;

import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathCopy;

public class CalculatorStringExpression implements ICalculator {
    private StackNumbers stackNumbers;
    private InfixToPostfixParser parser;
    private CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
    private String[] output;
    public CalculatorStringExpression(String input) {
        parser = new InfixToPostfixParser(input);
    }
    public boolean isCorrect(){
        return parser.checkExpression();
    }
    public double parseAndCalculate() {
        double num1, num2;
        output = parser.convert();
        stackNumbers = new StackNumbers(output.length);
        for (int i = 0; i < output.length && output[i] != null; i++){
            if (output[i].matches("\\d+([.]\\d+)?")){
                stackNumbers.push(Double.parseDouble(output[i]));
            } else {
                char operator = output[i].charAt(0);
                if (stackNumbers.size() > 1) {
                    num2 = stackNumbers.pop();
                    num1 = stackNumbers.pop();
                    stackNumbers.push(calculate(operator, num1, num2));
                }
            }
        }

        return stackNumbers.pop();
    }

    private double calculate(char operator, double number1, double number2) {
        switch (operator) {
            case '+':
                return addition(number1, number2);
            case '-':
                return subtraction(number1, number2);
            case '*':
                return multiplication(number1, number2);
            case '/':
                return division(number1, number2);
            case '^':
                return pow(number1, (int) number2);
            default:
                return 0;
        }
    }

    public double addition(double a, double b) {
        return calc.addition(a, b);
    }
    public double subtraction(double a, double b) {
        return calc.subtraction(a, b);
    }
    public double division(double a, double b) {
        return calc.division(a, b);
    }
    public double multiplication(double a, double b) {
        return calc.multiplication(a, b);
    }
    public double pow(double a, int b) {
        return calc.pow(a, b);
    }
    public double abs(double a) {
        return calc.abs(a);
    }
    public double sqrt(double a) {
        return calc.sqrt(a);
    }
}
