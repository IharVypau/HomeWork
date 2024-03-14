package home_work_3.additional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithCounterClassic extends CalculatorWithMathExtends {
    private int counter = 0;
    public void incrementCountOperation(){
        counter++;
    }
    public long getCountOperation(){
        return counter;
    }
}
