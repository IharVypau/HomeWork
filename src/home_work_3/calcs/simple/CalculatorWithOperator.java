package home_work_3.calcs.simple;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithOperator implements ICalculator {
    public double addition(double a, double b) {
        return a + b;
    }

    public double subtraction(double a, double b) {
        return a - b;
    }

    public double division(double a, double b) {
        return (double) (a / b);
    }

    public double multiplication(double a, double b) {
        return (a * b);
    }

    public double pow(double a, int b) {
        if (b == 0) return 1;
        return a * pow(a, --b);
    }

    public double abs(double a) {
        return (a > 0) ? a : multiplication(a, -1);
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }
}
