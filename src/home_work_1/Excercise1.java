package home_work_1;


import java.util.Scanner;
import java.lang.Integer;
public class Excercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b;
        System.out.print("Введите первое целое число: ");
        a = input.nextInt();  //например первое число = 7, в двоичном коде (8 бит) = 00000111
        System.out.print("Введите второе целое число: ");
        b = input.nextInt();  //например второе число = 12, в двоичном коде (8 бит) = 00001100
        String resultAndOperation = Integer.toBinaryString((a & b)); // Результат побитовой операции И этих чисел (7 и 12): в DEC = 4, в BIN = 100
        String resultOrOperation = Integer.toBinaryString((a | b)); // Результат побитовой операции ИЛИ этих чисел (7 и 12): в DEC = 15, в BIN = 1111
        System.out.printf("Первое число в DEC = %s,  в BIN = %s %n" +
                          "Второе число в DEC = %s,  в BIN = %s %n" +
                          "Результат побитовой операции И этих чисел: в DEC =  %s, в BIN = %s %n" +
                          "Результат побитовой операции ИЛИ этих чисел: в DEC =  %s, в BIN = %s",
                          a, Integer.toBinaryString(a),
                          b, Integer.toBinaryString(b),
                          (a & b), resultAndOperation,
                          (a | b), resultOrOperation);
    }
}

class Excercise1_3 {
    public static void main(String[] args) {
        //Следующий пример вызывает ошибку на стадии компиляции "типы операндов используемых в бинарном операторе несовместимы",
        // должны быть целые числа типа int, которые могут преобразовываться к двоичному виду
        // int x = 42.5 & 1;
    }
}
