package home_work_3.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMemory {
    private ICalculator calc;
    private double memory, tempMemory;
    public CalculatorWithMemory(ICalculator calc){
        this.calc = calc;
    }
    public double addition(double a, double b){
        tempMemory = calc.addition(a, b);
        return tempMemory;
    }
    public double subtraction(double a, double b){
        tempMemory = calc.subtraction(a, b);
        return tempMemory;
    }
    public double division(double a, double b){
        tempMemory = calc.division(a, b);
        return tempMemory;
    }
    public double multiplication(double a, double b){
        tempMemory = calc.multiplication(a, b);
        return tempMemory;
    }
    public double pow(double a, int b){
        tempMemory = calc.pow(a, b);
        return tempMemory;
    }
    public double abs(double a){
        tempMemory = calc.abs(a);
        return tempMemory;
    }
    public double sqrt(double a){
        tempMemory = calc.sqrt(a);
        return tempMemory;
    }
    public void save(){
        memory = tempMemory;
    }
    public double load(){
        tempMemory = memory;
        memory = 0;
        return tempMemory;
    }

}
