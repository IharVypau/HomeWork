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

}
