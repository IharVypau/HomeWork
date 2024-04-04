package home_work_3.runners;

import home_work_3.additional.CalculatorStringExpression;
import home_work_3.calcs.simple.CalculatorWithMathCopy;

import java.util.Scanner;

public class CalculatorStringExpressionMain {
    public static void main(String[] args) {
        /*System.out.print("Введите математическое выражение: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();*/
        String input =   "4.1 + 15 * 7 + (28 / 5) ^ 2"; // 140.46"
        System.out.println(input);
        CalculatorStringExpression stringCalcExpr = new CalculatorStringExpression(new CalculatorWithMathCopy());
        if(stringCalcExpr.isCorrect(input)){
            System.out.printf("%.2f%n", stringCalcExpr.calculate(input));
        }else {
            System.out.println("Выражение не корректное");
        }
    }
}