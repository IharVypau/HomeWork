package home_work_3.additional;

import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoChoiceAgregation {

    private CalculatorWithOperator calc;
    private int counter = 0;
    public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithOperator calc){
        this.calc = calc;
    }
    public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithMathCopy calc){
        this.calc = calc;
    }
    public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithMathExtends calc){
        this.calc = calc;
    }
    public double addition(double a, double b){
        counter++;
        return calc.addition(a, b);
    }
    public double subtraction(double a, double b){
        counter++;
        return calc.subtraction(a, b);
    }
    public double division(double a, double b){
        counter++;
        return calc.division(a, b);
    }
    public double multiplication(double a, double b){
        counter++;
        return calc.multiplication(a, b);
    }
    public double pow(double a, int b){
        counter++;
        return calc.pow(a, b);
    }
    public double abs(double a){
        counter++;
        return calc.abs(a);
    }
    public double sqrt(double a){
        counter++;
        return calc.sqrt(a);
    }
    public long getCountOperation(){
        return counter;
    }
}
