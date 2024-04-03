package home_work_1;

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
    public int getOddNumber(int a, int b){
        return Ex4_1.getOddNumber(a, b);
    }
    public int getAverage(int a, int b, int c){
        return Ex4_2.getAverage(a, b, c);
    }
    public boolean checkDivisionOfTwoNumbers(int a, int b){
        return Ex4_3.checkDivisionOfTwoNumbers(a, b);
    }
    public double convertByteToKBytes(int a){
        return Ex4_4.convertByteToKBytes(a);
    }
    public boolean isLetter(char c){
        return Ex4_5.isLetter(c);
    }
    public boolean isLeapYear(int year){
        return Ex4_6.isLeapYear(year);
    }
}

// 4.1 Определить нечётное число
class Ex4_1 {
    public static void main(String[] args) {
        System.out.println("4.1 Определить нечётное число среди двух чисел ");
        System.out.print("Введите первое число: ");
        int a = Excercise4.input.nextInt();
        System.out.print("\nВведите второе число: ");
        int b = Excercise4.input.nextInt();
        if( ((a + b) & 1) == 1  ){
            System.out.println("Введены не корректные числа (Одно число должно быть четным, другое нечетным).");
            return;
        }
        System.out.println("Нечетное число равно: " + (""+getOddNumber( a, b )));
    }
    public static int getOddNumber(int a, int b) {
        return ((a & 1) != 0) ? a : b;
    }
}

//4.2 Среди трёх чисел найти среднее
class Ex4_2{
    public static void main(String[] args){
        System.out.print("4.2 Среди трёх чисел найти среднее.\nВведите первое целое число: ");
        int a = Excercise4.input.nextInt();
        System.out.print("\nВведите второе целое число: ");
        int b = Excercise4.input.nextInt();
        System.out.print("\nВведите третье целое число: ");
        int c = Excercise4.input.nextInt();
        System.out.println("Среднее значение равно: " + getAverage(a, b, c));
    }
    public static int getAverage(int a, int b, int c){
        double sum = 0;
        if( (c + b) > (b + a) && (a > b)) return a;
        if( (a + b) < (c + a) && (b > a)) return b;
        return c;
    }
}

//4.3 Проверка делимости одного числа на другое
class Ex4_3{

    public static void main(String[] args){
        System.out.print("4.3 Проверка делимости одного числа на другое.\nВведите первое целое число: ");
        int a = Excercise4.input.nextInt();
        System.out.print("\nВведите второе целое число: ");
        int b = Excercise4.input.nextInt();
        if(checkDivisionOfTwoNumbers(a, b)){
            System.out.printf(" Делится без остатка. Результат выражения %d / %d = %d", a, b, a / b);
        } else {
            System.out.printf(" Делится c остатком. Результат выражения %d / %d = %d.\n " +
                    "Остаток от деления равен: %d", a, b, Math.divideExact(a, b), a % b);
        }
    }
    public static boolean checkDivisionOfTwoNumbers(int a, int b){
        return Math.floorMod(a, b) == 0;
    }
}

//4.4 Перевести байты в килобайты или наоборот
class Ex4_4{

    public static void main(String[] args){
        System.out.print("4.4 Перевести байты в килобайты или наоборот.\nВведите размер байт: ");
        int value = Excercise4.input.nextInt();
        double dVal = convertByteToKBytes(value);
        System.out.printf("%d байт = %.2f кБайт",value,dVal);
    }
    public static double convertByteToKBytes(int value){
        return (double) value / 1024;
    }
}

// * 4.5 Буква или иной символ
class Ex4_5{
    public static void main(String[] args){
        System.out.print("4.5 Буква или иной символ.\nВведите букву или символ: ");
        int code = Excercise4.input.nextInt();
        if((code > 65) && (code < 91) || (code > 96) && (code < 123)){
            System.out.println("Буква " + Character.toString(code));
        } else {
            System.out.println("Не буква латинского алфавита, а символ " + Character.toString(code));
        }
        //String ch = Character.toString(code);
        //String msg = Character.isLetter(ch.charAt(0)) ? "Буква" : "Не буква";
    }
    public static boolean isLetter(char ch){
        return Character.isLetter(ch);
    }
}

//* 4.6 Определить високосный год или нет
class Ex4_6{
    public static boolean isLeapYear(int year){
        return Math.floorMod(year,4) == 0;
    }
    public static void main(String[] args){
        System.out.print("4.6 Определить високосный год или нет.\nВведите год ");
        int year = Excercise4.input.nextInt();
        String msg = isLeapYear(year) ? "Високосный " : "Не високосный год";
        System.out.println(msg);
    }
}