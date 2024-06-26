package home_work_2.loops;

import java.util.Scanner;

/*
* 1.5. Задачи в презентации. На сайте есть пояснения по каждой из этих задач. Все задачи в одном классе, в отдельных методах.
   1.5.1. Найти наибольшую цифру натурального числа
   1.5.2. Вероятность четных случайных чисел
   1.5.3. Посчитать четные и нечетные цифры числа
   1.5.4. Ряд Фибоначчи
   1.5.5. Вывести ряд чисел в диапазоне с шагом
   1.5.6. Переворот числа
   1.6. Вывести таблицу умножения в консоль.
   В консоли должно получиться также как и на картинке (динозаврика рисовать не надо): https://www.dropbox.com/s/ibakfuppvy2w32g/multiplication_table.jpeg?dl=0
* */
public class Ex1_5 {
    static final int MAX_RAND_VALUE = 10000;
    static final int MIN_RAND_VALUE = 1000;
    static final String ERROR_INPUT_MSG = "Введено не корректное число";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Найти наибольшую цифру натурального числа. Введите число : ");
        String numStr = input.next();
        if (cheakInputNumber(numStr)){
            int num = Integer.parseInt(numStr);
            System.out.println("Наибольшая цифра этого натурального числа = " + getMaxNaturalDigit(num));
        }else showInputErrorMessage();
        System.out.printf("Вероятность выпадения случайных чисел на выборке > 1000 чисел: %3.2f%% %n",getStatisticsOfEvenNumbers());
        System.out.print("Посчитать четные и нечетные цифры от введенного целого числа. Введите число: ");
        numStr = input.next();
        if (cheakInputNumber(numStr)){
            int num = Integer.parseInt(numStr);
            int countOddNums = countEvenOrOddNums(num,true);
            int countEvenNums = countEvenOrOddNums(num,false);
            System.out.println("В числе " + num + ", нечетных - " + countOddNums + ", четных -  " + countEvenNums);
        }else {
            showInputErrorMessage();
        }
        System.out.print("Посчитать Ряд Фибоначчи числа 132. Введите количество элементов ряда для отображения: ");
        numStr = input.next();
        if (cheakInputNumber(numStr)){
            int num = Integer.parseInt(numStr);
            System.out.print("Ряд Фибоначчи числа 132: ");
            System.out.println(countFibonacci(132, num));
        }else {
            showInputErrorMessage();
        }
        System.out.println("\nВывести ряд чисел в диапазоне с шагом");
        System.out.print("Введите максимальное натуральное число: ");
        String maxStr = input.next();
        if (cheakInputNumber(maxStr)){
            int max = Integer.parseInt(maxStr);
            System.out.print("Введите минимальное натуральное число: ");
            String minStr = input.next();
            if (cheakInputNumber(minStr)){
                int min = Integer.parseInt(minStr);
                System.out.print("Введите шаг: ");
                String stepStr = input.next();
                if (cheakInputNumber(stepStr)){
                    int step = Integer.parseInt(stepStr);
                    System.out.println(showRowOfNumsWithStep(min, max, step));
                }else {
                    showInputErrorMessage();
                }
            }else {
                showInputErrorMessage();
            }
        }else {
            showInputErrorMessage();
        }

        System.out.println("\nПереворот числа");
        System.out.print("Введите натуральное число: ");
        numStr = input.next();
        if (cheakInputNumber(numStr)){
            int num = Integer.parseInt(numStr);
            System.out.println(showReverseNumber(num));
        }else {
            showInputErrorMessage();
        }
        System.out.println("Таблица умножения");
        System.out.println(showMultiplicationTable());

    }
    public static int getMaxNaturalDigit(int value){
        int max = -1;
        do{
            int currNum = value % 10;
            if(max < currNum) max = currNum;
            value /= 10;
        }while(value > 0);
        return max;
    }
    public static double getStatisticsOfEvenNumbers(){
        int randomNum = MIN_RAND_VALUE + (int) (Math.random() * (MAX_RAND_VALUE - MIN_RAND_VALUE  + 1));
        int evenNumberCounter = 0;
        for (int i = randomNum; i > 0; i--) {
            if ((int)(Math.random() * 2 ) == 0 ) evenNumberCounter++;
        }
        return (evenNumberCounter > 0 ) ? (double) evenNumberCounter / randomNum * 100 : 0.0;
    }
   public static int countEvenOrOddNums(int value, boolean isOdd){
        int count = 0;
        while(value > 0){
            int currNum = value % 10;
            if(currNum != 0 && !isOdd && (currNum & 1) == 0) count++;
            else if(currNum != 0 && isOdd && (currNum & 1)  == 1){
                count++;
            }
            value /= 10;
        }
        return count;
    }
    public static String countFibonacci(int number, int count){
        int a = 1, b = 1, c;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number && count > 0; i++, count--) {
            result.append(b).append(" ");
            c = a + b;
            a = b;
            b = c;
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
    public static String showRowOfNumsWithStep(int min,int max, int step){
        StringBuilder str = new StringBuilder();
        for (int i = min; i < max; i+=step) {
            str.append(i).append(" ");
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
    public static String showReverseNumber(int number){
        StringBuilder str = new StringBuilder();
        while(number > 0){
            int a = number % 10;
            number /= 10;
            str.append(a);
        }
        return str.toString();
    }
    public static String showMultiplicationTable() {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            for (int j = 2; j <= 5; j++) {
                str.append(String.format(" %d x %2d = %2d ", j, i, (i * j)));
            }
            str.append(String.format("%n"));
        }
        str.append(String.format("%n"));
        for (int i = 1; i <= 10; i++) {
            for (int j = 6; j <= 9; j++) {
                str.append(String.format(" %d x %2d = %2d ", j, i, (i * j)));
            }
            str.append(String.format("%n"));
        }
        return str.toString();
    }

    static boolean cheakInputNumber(String numberStr){
        return numberStr.matches("[1-9]\\d*");
    }
    static void showInputErrorMessage(){
        System.out.println(ERROR_INPUT_MSG);
    }
}
