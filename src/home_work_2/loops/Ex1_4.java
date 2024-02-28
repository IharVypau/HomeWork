package home_work_2.loops;

import java.util.Scanner;

/*
* 1.4.* Умножать число long a = 1; пока не произойдёт переполнение.
* В конце в консоль вывести сообщение со значением до переполнения и после переполнения. Умножать на:
   1.4.1. 3
   1.4.2. 188
   1.4.3. -19
   1.4.4. Да и вообще на любое целочисленное
* */
public class Ex1_4 {
    public static void main(String[] args) {
        multiplyNumberToOverflow(3);
        multiplyNumberToOverflow(189);
        multiplyNumberToOverflow(-19);
    }
    static void multiplyNumberToOverflow(long num){
        long a = 1;
        long b = num;
        do {
            a = b;
            b = a * num;
        }while((b / a) == num );
        System.out.printf("%nзначение до переполнения = %d, значение после переполнения = %d", a, b);
    }
}
