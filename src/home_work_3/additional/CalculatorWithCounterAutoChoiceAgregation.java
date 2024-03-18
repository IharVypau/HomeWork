package home_work_3.additional;

import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoChoiceAgregation {

    private CalculatorWithOperator calc1;
    private CalculatorWithMathExtends calc2;
    private CalculatorWithMathCopy calc3;
    private int counter = 0;
    public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithOperator calc){
        calc1 = calc;
    }
    public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithMathExtends calc){
        calc2 = calc;
    }
    public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithMathCopy calc){
        calc3 = calc;
    }
    public double addition(double a, double b){
        System.out.println(this);
        counter++;
        return (calc1==null?calc2==null?calc3: calc2: calc1).addition(a, b);
    }
    public double subtraction(double a, double b){
        counter++;
        return (calc1==null?calc2==null?calc3: calc2: calc1).subtraction(a, b);
    }
    public double division(double a, double b){
        counter++;
        return (calc1==null?calc2==null?calc3: calc2: calc1).division(a, b);
    }
    public double multiplication(double a, double b){
        counter++;
        return (calc1==null?calc2==null?calc3: calc2: calc1).multiplication(a, b);
    }
    public double pow(double a, int b){
        counter++;
        return (calc1==null?calc2==null?calc3: calc2: calc1).pow(a, b);
    }
    public double abs(double a){
        counter++;
        return (calc1==null?calc2==null?calc3: calc2: calc1).abs(a);
    }
    public double sqrt(double a){
        counter++;
        return (calc1==null?calc2==null?calc3: calc2: calc1).sqrt(a);
    }
    public long getCountOperation(){
        return counter;
    }
}
