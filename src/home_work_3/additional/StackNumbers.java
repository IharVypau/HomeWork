package home_work_3.additional;

public class StackNumbers {
    private double[] stackArray;
    private int top;
    public StackNumbers(int size){
        stackArray = new double[size];
        top = -1;
    }
    public void push(double j){
        stackArray[++top] = j;
    }
    public double pop(){
        return stackArray[top--];
    }
    public int size(){
        return top + 1;
    }
    public boolean isEmpty(){
        return (top == -1);
    }
}
