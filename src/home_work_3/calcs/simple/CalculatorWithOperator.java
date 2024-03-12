package home_work_3.calcs.simple;

public class CalculatorWithOperator {
    public int addition(int a, int b){
        return a + b;
    }
    public int subtraction(int a, int b){
        return a - b;
    }
    public double division(double a, int b){
        return (double) (a / b);
    }
    public double multiplication(double a, double b){
        return  (a * b);
    }
    public double pow(double a, int b){
        if(b == 0) return 1;
        return a * pow(a, --b);
    }
    public double abs(int a){
       return (a > 0) ? a : multiplication(a, -1);
    }
    public double sqrt(double a){
        return Math.sqrt(a);
    }
}
