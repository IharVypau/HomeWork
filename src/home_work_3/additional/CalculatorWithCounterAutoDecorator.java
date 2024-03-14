package home_work_3.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoDecorator implements ICalculator {

    private ICalculator calc;
    private int counter = 0;
    public CalculatorWithCounterAutoDecorator(ICalculator calc){
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
    public ICalculator getCalculator(){
        return calc;
    }
}
