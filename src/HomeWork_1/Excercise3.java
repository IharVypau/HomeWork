package HomeWork_1;

import java.lang.Math;
/*
* Изучить библиотеку (класс) Math из jdk. (https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html).
* Отразить эксперименты в сданной домашней работе. Материалов в интернете очень много*/

public class Excercise3 {
    public static void main(String[] args) {
        System.out.println("Модуль числа -55 равен Math.abs(-55): " + Math.abs(-55));
        System.out.println("Квадратный корень числа 100 равен Math.sqrt(100): " + Math.sqrt(100));
        System.out.println("Округление числа 2.34 до 3 Math.ceil(2.34): " + Math.ceil(2.34));
        System.out.println("Округление числа 2.34 до 2 Math.floor(2.34): " + Math.floor(2.34));
        System.out.println("Остаток от деления двух чисел: Math.floorDiv(7, 2): " + Math.floorDiv(7, 2));
        System.out.println("Деление без остатка Math.divideExact(24, 6): " + Math.divideExact(24, 6));
        System.out.println("Минимальное число из двух чисел Math.min(1, 4): " + Math.min(1, 4));
        System.out.println("Максимальное число из двух чисел Math.max(1, 4): " + Math.min(1, 4));
        System.out.println("Десятичный логарифм с основанием 10 Math.log10(100): " + Math.log10(100));
    }
}
