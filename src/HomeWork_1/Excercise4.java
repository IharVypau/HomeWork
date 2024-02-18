package HomeWork_1;

import java.nio.charset.Charset;
import java.util.Scanner;

/*
* 4. Разбираемся с операторами ветвления. Каждую задачу в отдельном классе.
* Пояснения по задачам смотреть в презентации и на сайте по ссылке в презентации.
* 4.1 Определить нечётное число
* 4.2 Среди трёх чисел найти среднее
* 4.3 Проверка делимости одного числа на другое
* 4.4 Перевести байты в килобайты или наоборот
* 4.5 Буква или иной символ
* 4.6 Определить високосный год или нет
* */

//
public class Excercise4 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s",
                          new Ex4_1(),
                          new Ex4_2(),
                          new Ex4_3(),
                          new Ex4_4(),
                          new Ex4_5(),
                          new Ex4_6());
    }
}

// 4.1 Определить нечётное число
class Ex4_1 {
    boolean isOdd(int value) {
        if (value % 2 != 0) {
          return true;
        }
        return false;
    }
    public String toString() {
        System.out.print("4.1 проверка нечетности числа.\nВведите целое число: ");
        int value = Excercise4.input.nextInt();
        return isOdd(value) ? "Число не четное" : "Число четное";
    }
}

//4.2 Среди трёх чисел найти среднее
class Ex4_2{
    double getAverage(int[] arr){
        double sum = 0;
        for(int x: arr) sum += x;
        return sum == 0 ? 0 : sum / arr.length;
    }
    public String toString() {
        System.out.print("4.2 Среди трёх чисел найти среднее.\nВведите первое целое число: ");
        int a = Excercise4.input.nextInt();
        System.out.print("\nВведите второе целое число: ");
        int b = Excercise4.input.nextInt();
        System.out.print("\nВведите третье целое число: ");
        int c = Excercise4.input.nextInt();
        return "Среднее значение равно: " + Double.toString(getAverage(new int[]{a, b, c}));
    }

}

//4.3 Проверка делимости одного числа на другое
class Ex4_3{
    boolean checkDivisionOfTwoNumbers(int a, int b){
        return a % b == 0;
    }
    public String toString() {
        System.out.print("4.3 Проверка делимости одного числа на другое.\nВведите первое целое число: ");
        int a = Excercise4.input.nextInt();
        System.out.print("\nВведите второе целое число: ");
        int b = Excercise4.input.nextInt();
        return checkDivisionOfTwoNumbers(a, b) ? " Первое число делится без остатка на второе" : "Не делится";
    }
}

//4.4 Перевести байты в килобайты или наоборот
class Ex4_4{
    double convertByteToKBytes(int value){
        return (double) value / 1024;
    }
    public String toString(){
        System.out.print("4.4 Перевести байты в килобайты или наоборот.\nВведите размер байт: ");
        int value = Excercise4.input.nextInt();
        return value+"байт = "+Double.toString(convertByteToKBytes(value))+"кБайт";
    }
}

// * 4.5 Буква или иной символ
class Ex4_5{
    boolean isLetter(char s){
        return Character.isLetter(s);
    }
    public String toString(){
        System.out.print("4.5 Буква или иной символ.\nВведите букву или символ: ");
        String ch = Excercise4.input.next();
        return isLetter(ch.charAt(0)) ? "Буква" : "Не буква";
    }

}

//* 4.6 Определить високосный год или нет
class Ex4_6{
    boolean isLeapYear(int year){
        return year % 4 == 0;
    }
    public String toString(){
        System.out.print("4.6 Определить високосный год или нет.\nВведите год ");
        int year = Excercise4.input.nextInt();
        return (isLeapYear(year)) ? "Високосный " : "Не високосный год";
    }
}