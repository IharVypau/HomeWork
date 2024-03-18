package home_work_3.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMemory {
    private static final int SIZE_OF_MEMORY = 1;
    private ICalculator calc;
    private double lastResult;
    private double[] memory;
    private int currMemoryIdx = -1;
    public CalculatorWithMemory(ICalculator calc){
        this.calc = calc;
        memory = new double[SIZE_OF_MEMORY];
    }
    public double addition(double a, double b){
        lastResult = calc.addition(a, b);
        return lastResult;
    }
    public double subtraction(double a, double b){
        lastResult = calc.subtraction(a, b);
        return lastResult;
    }
    public double division(double a, double b){
        lastResult = calc.division(a, b);
        return lastResult;
    }
    public double multiplication(double a, double b){
        lastResult = calc.multiplication(a, b);
        return lastResult;
    }
    public double pow(double a, int b){
        lastResult = calc.pow(a, b);
        return lastResult;
    }
    public double abs(double a){
        lastResult = calc.abs(a);
        return lastResult;
    }
    public double sqrt(double a){
        lastResult = calc.sqrt(a);
        return lastResult;
    }
    public void save(){
        if(currMemoryIdx < SIZE_OF_MEMORY){
            memory[++currMemoryIdx] = lastResult;
        }else{
            memory[currMemoryIdx] = lastResult;
        }
    }
    public double load(){
        if(currMemoryIdx > -1){
           return memory[currMemoryIdx--];
        }else{
            System.out.println("Ошибка операции: память пуста");
        }
        return 0;
    }

}
