package home_work_3.calcs.simple;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMathCopy extends CalculatorWithOperator  {
    public double addition(double a, double b){
        return a + b;
    }
    public double subtraction(double a, double b){
        return a - b;
    }
    public double division(double a, double b){
        return (double) (a / b);
    }
    public double multiplication(double a, double b){
        return  (a * b);
    }
    public double pow(double a, int b){ return Math.pow(a, b); }
    public double abs(double a){
        return Math.abs(a);
    }
    public double sqrt(double a){
        return Math.sqrt(a);
    }
}
