package home_work_3.additional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithCounterAutoSuper extends CalculatorWithMathExtends {
    private int counter = 0;
    public double addition(double a, double b){
        counter++;
        return super.addition(a, b);
    }
    public double subtraction(double a, double b){
        counter++;
        return super.subtraction(a, b);
    }
    public double division(double a, double b){
        counter++;
        return super.division(a, b);
    }
    public double multiplication(double a, double b){
        counter++;
        return super.multiplication(a, b);
    }
    public double pow(double a, int b){
        counter++;
        return super.pow(a, b);
    }
    public double abs(double a){
        counter++;
        return super.abs(a);
    }
    public double sqrt(double a){
        counter++;
        return super.sqrt(a);
    }
    public long getCountOperation(){
        return counter;
    }

}
