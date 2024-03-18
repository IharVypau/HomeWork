package home_work_3.additional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfixParser {
    private static final byte LOW_PRIORITY = 1;
    private static final byte HIGH_PRIORITY = 2;
    private StackOperator stackOp;
    private String input;
    private int currOutputIdx = 0;
    private int currIdx;
    private String[] output;

    public InfixToPostfixParser(String in) {
        input = in;
        int size = in.length();
        stackOp = new StackOperator(size);
        output = new String[size];
    }

    public String[] convert() {
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

    public boolean checkExpression() {
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
