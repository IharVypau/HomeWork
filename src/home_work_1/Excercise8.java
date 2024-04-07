package home_work_1;

import java.util.Scanner;

/*
* Создать СТАТИЧЕСКИЙ метод String toBinaryString(byte number) и возвращает двоичное представление числа.
*  В методе можно использовать только обычную математику которая описана в теории.
* Если число отрицательное то вернуть дополнительный код. Теория https://planetcalc.ru/747 Пример:
	8.1 Вводим: 42.  Возвращает: 00101010
	8.2 Вводим: 15.  Возвращает: 00001111
	8.3 Вводим: -42. Возвращает: 11010110
	8.4 Вводим: -15. Возвращает: 11110001
* */
public class Excercise8 {
    public static void main(String[] args) {
        System.out.print("Перевод числа из десятеричной системы в двоичную.\nВведите любое целое число от -127 до 127: ");
        int number = new Scanner(System.in).nextInt();
        if(number <= 127 && number >= -127) {
            String str = toBinaryString(number);
            str = (number > 0) ? String. format("%8s", str).replace(" ", "0") : str.substring(str.length() - 8);
            System.out.println("Ваше число в двоичной системе равно: " + str );
        }
        else System.out.println("Число не корректное, должно быть от -127 до 127");

    }
    public static String toBinaryString(int x) {
        StringBuffer stringBuffer = new StringBuffer();
        do {
            stringBuffer.append((x & 1) == 1 ? "1" : "0");
            x >>>= 1;
        } while (x != 0);
        return stringBuffer.reverse().toString();
    }
}
