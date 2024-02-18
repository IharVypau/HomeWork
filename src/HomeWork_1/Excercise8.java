package HomeWork_1;

import java.util.Scanner;

/*
* Создать СТАТИЧЕСКИЙ метод String toBinaryString(byte number) и возвращает двоичное представление числа.
*  В методе можно использовать только обычную математику которая описана в теории.
* Если число отрицательное то вернуть дополнительный код. Теория https://planetcalc.ru/747. Пример:
	8.1 Вводим: 42.  Возвращает: 00101010
	8.2 Вводим: 15.  Возвращает: 00001111
	8.3 Вводим: -42. Возвращает: 11010110
	8.4 Вводим: -15. Возвращает: 11110001*/
public class Excercise8 {
    static String toBinaryString(byte number){
        boolean isPositive  = number >= 0;
        String result = "";
        String[] bitArr = new String[]{"0", "0", "0", "0", "0", "0", "0", "0"};
        for(int digit = number, i = bitArr.length -1; digit != 0; digit /= 2, i--){
            bitArr[i] = "" + Math.abs(digit % 2);
        }

        if(!isPositive){
           for (int i = 0; i < bitArr.length; i++){
               bitArr[i] = ( bitArr[i].equals("0") ) ? "1" : "0";
           }
           result = String.join("", bitArr);
           int index = result.lastIndexOf("0");
           bitArr[index] = "1";
           for(index = index+1; index < bitArr.length; index++) bitArr[index] = "0";

        }
        result = String.join("", bitArr);
        return result;
    }

    public static void main(String[] args) {
        System.out.print("Перевод числа из десятеричной системы в двоичную.\nВведите любое целое число от -127 до 127: ");
        int number = new Scanner(System.in).nextInt();
        if(number <= 127 && number >= -127)
            System.out.println("Ваше число в двоичной системе равно: "+toBinaryString((byte) number));
        else System.out.println("Число не корректное, должно быть от -127 до 127");
    }
}
