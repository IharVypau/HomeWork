package home_work_2.loops;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

/*
* 1.3. Возведение в степень. Через консоль пользователь вводит два числа. Первое число это число которое мы будем возводить,
     Второе число это степень в которую возводят первое число.
   * Степень - только положительная и целая. Возводимое число - может быть отрицательным и оно будет дробным. Math использовать нельзя.
   1.3.1 Пример: Ввели 18 и 5, должно получиться в консоли: 18.0 ^ 5 = 1 889 568.0
   1.3.2 Пример: Ввели 7.5 и 2, должно получиться в консоли: 7.5 ^ 2 = 56.25
* */
public class Ex1_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число которое мы будем возводить в степень: ");
        String numStr = input.next();
        if(numStr.matches("-?\\d+\\.\\d+")){
            double num = Double.parseDouble(numStr);
            System.out.print("Введите степень в которую будем возводить число: ");
            String powString = input.next();
            if(powString.matches("\\d+")){
                int pow = Integer.parseInt(powString);
                double result = calculatePow( num, pow);
                System.out.printf(numStr + " ^ " + pow + " = " + customFormat(result));
            }else {
                System.out.println("Введена не корректная степень числа (только положительная и целая)");
            }
        } else {
            System.out.println("Введено не корректное число (дробное, может быть отрицательным)");
        }
    }
    public static double calculatePow(double x, int y){
        double result = 1.0;
        for (int i = 1; i <= y; i++) {
            result *= x;
        }
        return result;
    }
    public static String customFormat(double value ) {
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        formatSymbols.setGroupingSeparator(' ');
        DecimalFormat df = new DecimalFormat("###,###.00",formatSymbols);
        return df.format(value);
    }
}
