package HomeWork_2.loops;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Locale;

/*
* 1. Циклы. Для преобразования строки в число можно использовать http://proglang.su/java/numbers-parseint, если хотите можете добавить проверки на корректность ввода данных. Число положительное, максимум long:
   1.1. Перемножить числа от 1 до числа (включительно) введенного через аргумент к исполняемой программе.
   * Есть нюанс с переполнением, можно добавить проверки и сообщения пользователю.
   Пример: Ввели 5, должно получиться в консоли: 1 * 2 * 3 * 4 * 5 = ответ
   1.1.1. Используя только цикл
   1.1.2.* Используя рекурсию
   1.2. Все цифры из числа введенного через аргумент к исполняемой программе перемножить между собой и вывести ход вычислений в консоль.
   * Пользователь обязан ввести целое число. Если ввели не целое то выдать сообщение о том что пользователь ввёл некорректные данные.
   1.2.1 Пример: Ввели 181232375, должно получиться в консоли: 1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10 080
   1.2.2 Пример: Ввели 99.2, должно получиться в консоли: Введено не целое число
   1.2.3 Пример: Ввели Привет, должно получиться в консоли: Введено не число
   1.3. Возведение в степень. Через консоль пользователь вводит два числа. Первое число это число которое мы будем возводить, Второе число это степень в которую возводят первое число.
   * Степень - только положительная и целая. Возводимое число - может быть отрицательным и оно будет дробным. Math использовать нельзя.
   1.3.1 Пример: Ввели 18 и 5, должно получиться в консоли: 18.0 ^ 5 = 1 889 568.0
   1.3.2 Пример: Ввели 7.5 и 2, должно получиться в консоли: 7.5 ^ 2 = 56.25
   1.4.* Умножать число long a = 1; пока не произойдёт переполнение. В конце в консоль вывести сообщение со значением до переполнения и после переполнения. Умножать на:
   1.4.1. 3
   1.4.2. 188
   1.4.3. -19
   1.4.4. Да и вообще на любое целочисленное
   1.5. Задачи в презентации. На сайте есть пояснения по каждой из этих задач. Все задачи в одном классе, в отдельных методах.
   1.5.1. Найти наибольшую цифру натурального числа
   1.5.2. Вероятность четных случайных чисел
   1.5.3. Посчитать четные и нечетные цифры числа
   1.5.4. Ряд Фибоначчи
   1.5.5. Вывести ряд чисел в диапазоне с шагом
   1.5.6. Переворот числа
   1.6. Вывести таблицу умножения в консоль. В консоли должно получиться также как и на картинке (динозаврика рисовать не надо): https://www.dropbox.com/s/ibakfuppvy2w32g/multiplication_table.jpeg?dl=0
* */
public class Excercise_1 {
    final static int MAX_NUMBER = 100;
    static long result = 1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число больше нуля и меньше 100: ");
        int num = input.nextInt();
        if(num > 0 && num <= MAX_NUMBER){
            result = inLoop(num);
            //result = inRecursion(num);
            if(result > 0){
                StringBuffer strBuff = new StringBuffer();
                for(int i = 1; i < num; i++){
                    strBuff.append(i).append(" * ");
                }
                System.out.println(strBuff.toString() + num + " = " + result);
            } else{
                System.out.println("Результат выполнения выражения превышает 64 битное целое число (long).");
            }
        } else{
            System.out.println("Ввели некорректное число");
        }
    }
    private static long inLoop(long number){
        long result = number;
        while(--number > 1) {
            result *= number;
            if(result < 0) {
                result = -1;
                break;
            }
        }
       return result;
    }
    private static long inRecursion(long number){
        if(number <= 1) return 1;
        else {
            long result = number * inRecursion(number-1);
            return (result < 0) ? -1 : result;
        }
    }
}

class Ex1_2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите любое целое число: ");
        String numStr = input.next();
        if(Pattern.matches("\\d*", numStr) && Integer.parseInt(numStr) >0){
            long result = multiplyStringOfDigits(numStr);
            System.out.println(String.join(" * ", numStr.split(""))+ " = " + result);
        }else if(numStr.contains(".")){
            System.out.println("Введено не целое число");
        } else System.out.println("Введено не число");
    }
    static long multiplyStringOfDigits(String nums){
        long result = 1;
        for (int i = 0; i < nums.length(); i++) {
            result *= Integer.parseInt((String.valueOf(nums.charAt(i))));
        }
        return result;
    }
}

class Ex1_3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число которое мы будем возводить в степень: ");
        String numStr = input.next();
        double num = Double.parseDouble(numStr);
        System.out.print("Введите степень в которую будем возводить число: ");
        int pow = input.nextInt();//1 889 568.0
        double result = calculatePow( num, pow);
        System.out.printf(numStr + " ^ " + pow + " = " + customFormat(result));
    }
    static double calculatePow(double x, int y){
        double result = 1.0;
        for (int i = 1; i <= y; i++) {
            result *= x;
        }
        return result;
    }
    static public String customFormat(double value ) {
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        formatSymbols.setGroupingSeparator(' ');
        DecimalFormat df = new DecimalFormat("###,###.00",formatSymbols);
        return df.format(value);
    }
}

class Ex1_4{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите целое число на которое производить умножение: ");
        int num = input.nextInt();
        long a = 1;
        long b = a * num;
        do {
            a = b;
            b = a * num;
        }while((b / a) == num );
        System.out.printf("значение до переполнения = %d%nзначение после переполнения = %d",a,b);
    }
}

class Ex1_5{
    static final int MAX_RAND_VALUE = 10000;
    static final int MIN_RAND_VALUE = 1000;
    public static int getNaturalNumber(int value){
        int max = -1;
        do{
            int currNum = value % 10;
            if(max < currNum) max = currNum;
            value /= 10;
        }while(value > 0);
        return max;
    }
    static double getStatisticsOfEvenNumbers(){
        int randomNum = MIN_RAND_VALUE + (int) (Math.random() * (MAX_RAND_VALUE - MIN_RAND_VALUE  + 1));
        int evenNumberCounter = 0;
        for (int i = randomNum; i > 0; i--) {
            if ((int)(Math.random() * 2 ) == 0 ) evenNumberCounter++;
        }
        return (evenNumberCounter > 0 ) ? (double) evenNumberCounter / randomNum * 100 : 0.0;
    }
    static int countEvenOrOddNums(int value, boolean isOdd){
        int count = 0;
        while(value > 0){
            int currNum = value % 10;
            if(!isOdd && (currNum & 1) == 0) count++;
            else if(isOdd && (currNum & 1)  == 1){
                count++;
            }
            value /= 10;
        }
        return count;
    }
    static void countFibonacci(int number, int count){
        int a = 1, b = 1, c;
        for (int i = 0; i < number && count > 0; i++, count--) {
            System.out.print(b+" ");
            c = a + b;
            a = b;
            b = c;
        }
    }
    static void showRowOfNumsWithStep(int min,int max, int step){
        for (int i = min; i < max; i+=step) {
            System.out.print(i+"  ");
        }
    }
    static void showReverseNumber(int number){
        System.out.println(new StringBuffer(number + "").reverse());
    }
    static void showMultiplicationTable() {
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j <= 5; j++) {
                System.out.printf(" %d x %d = %2d ", j, i, (i * j));
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i < 10; i++) {
            for (int j = 6; j <= 9; j++) {
                System.out.printf(" %d x %d = %2d ", j, i, (i * j));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int num = input.nextInt();
        System.out.println("Наибольшая цифра этого натурального числа = " + getNaturalNumber(num));
        System.out.printf("Вероятность выпадения случайных чисел на выборке > 1000 чисел: %3.2f%% %n",getStatisticsOfEvenNumbers());
        System.out.print("Посчитать четные и нечетные цифры от введенного целого числа. Введите число: ");
        int num2 = input.nextInt();
        int countOddNums = countEvenOrOddNums(num2,true);
        int countEvenNums = countEvenOrOddNums(num2,false);
        System.out.println("В числе 1231233, нечетных - " + countOddNums + ", четных -  " + countEvenNums);
        System.out.print("Посчитать Ряд Фибоначчи числа 132. Введите количество элементов ряда для отображения: ");
        int num3 = input.nextInt();
        System.out.print("Ряд Фибоначчи числа 132: ");
        countFibonacci(132, num3);
        System.out.println("Вывести ряд чисел в диапазоне с шагом");
        System.out.print("Введите максимальное натуральное число: ");
        int max = input.nextInt();
        System.out.print("Введите минимальное натуральное число: ");
        int min = input.nextInt();
        System.out.print("Введите шаг: ");
        int step = input.nextInt();
        showRowOfNumsWithStep(min, max, step);
        System.out.println("Переворот числа");
        System.out.print("Введите натуральное число: ");
        int num4 = input.nextInt();
        showReverseNumber(num4);
        System.out.println("Таблица умножения");
        showMultiplicationTable();

    }
}