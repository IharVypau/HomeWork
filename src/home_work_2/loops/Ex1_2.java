package home_work_2.loops;
/*
* 1.2. Все цифры из числа введенного через аргумент к исполняемой программе перемножить между собой и вывести ход вычислений в консоль.
   Пользователь обязан ввести целое число. Если ввели не целое то выдать сообщение о том что пользователь ввёл некорректные данные.
   1.2.1 Пример: Ввели 181232375, должно получиться в консоли: 1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10 080
   1.2.2 Пример: Ввели 99.2, должно получиться в консоли: Введено не целое число
   1.2.3 Пример: Ввели Привет, должно получиться в консоли: Введено не число
* */
public class Ex1_2 {
    public static void main(String[] args) {
        if(args[0].matches("-?\\d+")){
            String numberStr = args[0];
            long result = multiplyStringOfDigits(numberStr);
            System.out.println(String.join(" * ", numberStr.split(""))+ " = " + result);
        }else if(args[0].matches("-?\\d+.\\d+")){
            System.out.println("Введено не целое число");
        } else System.out.println("Введено не число");
    }
    static long multiplyStringOfDigits(String number){
        long result = 1;
        for (int i = 0; i < number.length(); i++) {
            result *= Integer.parseInt((String.valueOf(number.charAt(i))));
        }
        return result;
    }

}
