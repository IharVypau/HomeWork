package home_work_3.additional;

import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathCopy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStringExpression implements ICalculator {
    private StackNumbers stackNumbers;
    private InfixToPostfixParser parser;
    private ICalculator calc ;
    private String[] output;

    public CalculatorStringExpression(ICalculator calc){
        this.calc = calc;
        this.parser = new InfixToPostfixParser();
    }
    public boolean isCorrect(String in){
        return parser.checkExpression(in);
    }

    private double parseAndCalculate(String input) {
        double num1, num2;
        output = parser.convert(input);
        stackNumbers = new StackNumbers(output.length);
        for (int i = 0; i < output.length && output[i] != null; i++){
            if (output[i].matches("\\d+([.]\\d+)?")){
                stackNumbers.push(Double.parseDouble(output[i]));
            } else {
                char operator = output[i].charAt(0);
                if (stackNumbers.size() > 1) {
                    num2 = stackNumbers.pop();
                    num1 = stackNumbers.pop();
                    stackNumbers.push(executeOperation(operator, num1, num2));
                }
            }
        }

        return stackNumbers.pop();
    }

    private double executeOperation(char operator, double number1, double number2) {
        switch (operator) {
            case '+':
                return addition(number1, number2);
            case '-':
                return subtraction(number1, number2);
            case '*':
                return multiplication(number1, number2);
            case '/':
                return division(number1, number2);
            case '^':
                return pow(number1, (int) number2);
            default:
                return 0;
        }
    }
    public double calculate(String input){
        input = input.replaceAll("\\s+","");
        parser = new InfixToPostfixParser();
        parser.parserInit(input);
        return parseAndCalculate(input);
    }

    public double addition(double a, double b) {
        return calc.addition(a, b);
    }
    public double subtraction(double a, double b) {
        return calc.subtraction(a, b);
    }
    public double division(double a, double b) {
        return calc.division(a, b);
    }
    public double multiplication(double a, double b) {
        return calc.multiplication(a, b);
    }
    public double pow(double a, int b) {
        return calc.pow(a, b);
    }
    public double abs(double a) {
        return calc.abs(a);
    }
    public double sqrt(double a) {
        return calc.sqrt(a);
    }
}


class InfixToPostfixParser {
    private static final byte LOW_PRIORITY = 1;
    private static final byte HIGH_PRIORITY = 2;
    private StackOperator stackOp;
    private String input;
    private int currOutputIdx = 0;
    private int currIdx;
    private String[] output;

    public void parserInit(String in){
        input= in.replaceAll("\\s+","");
        int size = in.length();
        stackOp = new StackOperator(size);
        output = new String[size];
    }

    public String[] convert(String input) {
        for (currIdx = 0; currIdx < input.length(); currIdx++) {
            char ch = input.charAt(currIdx);
            switch (ch) {
                case '+':
                case '-':
                    setOperator(ch, LOW_PRIORITY);
                    break;
                case '*':
                case '/':
                case '^':
                    setOperator(ch, HIGH_PRIORITY);
                    break;
                case '(':
                    stackOp.push(ch);
                    break;
                case ')':
                    readTillCloseBracket(ch);
                    break;
                default: {
                    String num = getNumber();
                    output[currOutputIdx++] = num;
                }
            }
        }

        while (!stackOp.isEmpty()) {
            output[currOutputIdx++] = stackOp.pop() + "";
        }
        return output;
    }

    public void setOperator(char opThis, int prec1) {
        char opTop = 0;
        while (!stackOp.isEmpty()) {
            opTop = stackOp.pop();
            if (opTop == '(') {
                stackOp.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = LOW_PRIORITY;
                } else {
                    prec2 = HIGH_PRIORITY;
                }
                if (prec2 < prec1) {
                    stackOp.push(opTop);
                    break;
                } else {
                    output[currOutputIdx++] = Character.toString(opTop);
                }
            }
        }
        stackOp.push(opThis);
    }

    public void readTillCloseBracket(char ch) {
        while (!stackOp.isEmpty()) {
            char chx = stackOp.pop();
            if (chx == '(') {
                break;
            } else {
                output[currOutputIdx++] = Character.toString(chx);
            }
        }
    }

    public String getNumber() {
        String outputNumber = "";
        String tempStr = input.substring(currIdx);
        Pattern pattern = Pattern.compile("^\\d+([.]\\d+)?|^PI|^E");
        Matcher matcher = pattern.matcher(tempStr);
        if (matcher.find()) {
            outputNumber = matcher.group();
            currIdx += matcher.end() - 1;
        }
        if (outputNumber.equals("PI")) {
            outputNumber = "3.14";
        } else if (outputNumber.equals("E")) {
            outputNumber = "2.71828";
        }
        return outputNumber;
    }

    public boolean checkExpression(String in) {
        input= in.replaceAll("\\s+","");
        StackOperator stack = new StackOperator(input.length());
        String exp = "";
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if (chx != '(') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
                default:
                    exp += ch + "";
                    break;
            }
        }

        return stack.isEmpty() && validate(exp);
    }

    public boolean validate(String text) {
        return text.matches("((?:(?:^|[-+*/^])(?:\\s*-?\\d+(\\.\\d+)?(?:[-+*/^][E|PI]*?)?\\s*))+$)");
    }
}

class StackNumbers {
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

class StackOperator {

    private char[] stackArray;
    private int top, maxSize;

    public StackOperator(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char show() {
        return stackArray[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

}
