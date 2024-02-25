package HomeWork_2.arrays;

import HomeWork_2.utils.ArraysUtils;

/*
* 2.2 Создать класс ArraysIteration. В этом классе написать перебор (итерирование) массива при помощи do....while, while, for, foreach.
   *  Вызывая ранее созданный метод arrayFromConsole (ArraysUtils.arrayFromConsole()) получить массив.
   *  Все задачи в одном классе, в отдельных методах, в каждом методе используется 4 разных цикла. Должно получиться 3 метода:
   2.2.1. Вывести все элементы в консоль.
   2.2.2. Вывести каждый второй элемент массива в консоль.
   2.2.3. Вывести все элементы массива в консоль в обратном порядке.
   2.3* Выполнить задание 2.2 иным способом.
   * Создать интерфейс IArraysOperation с методами из задания,
   * каждый метод должен принимать массив с которым он будет работать.
   * Написать 4 отдельных класса и реализовать данный интерфейс:
   2.3.1. DoWhileOperation - во всех методах можно использовать только do....while
   2.3.2. WhileOperation - во всех методах можно использовать только while
   2.3.3. ForOperation - во всех методах можно использовать только for
   2.3.4. ForEachOperation - во всех методах можно использовать только foreach
   2.4 Задачи в презентации. На сайте есть пояснения по каждой из этих задач. Все задачи в одном классе, в отдельных методах. Для получения массивов вызывать ранее созданный метод arrayRandom (ArraysUtils.arrayRandom(50, 100))
   2.4.1. Сумма четных положительных элементов массива
   2.4.2. Максимальный из элементов массива с четными индексами
   2.4.3. Элементы массива, которые меньше среднего арифметического
   2.4.4. Найти два наименьших (минимальных) элемента массива
   2.4.5. Сжать массив, удалив элементы, принадлежащие интервалу
   2.4.6. Сумма цифр массива
* */
public class ArraysIteration {
    public static void outputArray2_2_1(int[] container){
        int i = 0;
        System.out.print("do...while: ");
        do {
            System.out.print(container[i]+" ");
        }while (++i < container.length);
        System.out.print("\nwhile: ");
        i = 0;
        while(container.length > i){
            System.out.print(container[i]+" ");
            i++;
        }
        System.out.print("\nfor: ");
        for (i = 0; i < container.length; i++){
            System.out.print(container[i]+" ");
        }
        System.out.print("\nforeach: ");
        for(int j : container){
            System.out.print(j + " ");
        }
    }
    public static void outputArray2_2_2(int[] container){
        System.out.println("\nКаждый второй элемент массива");
        int i = 0;
        System.out.print("do...while: ");
        do {
            if((i & 1) == 1){
                System.out.print(container[i]+" ");
            }
        }while (++i < container.length);
        System.out.print("\nwhile: ");
        i = 0;
        while(container.length > i){
            if((i & 1) == 1){
                System.out.print(container[i]+" ");
            }
            i++;
        }
        System.out.print("\nfor: ");
        for (i = 0; i < container.length; i++){
            if((i & 1) == 1){
                System.out.print(container[i]+" ");
            }
        }
        System.out.print("\nforeach: ");
        i = 0;
        for(int j : container){
            if((i & 1) == 1){
                System.out.print(j+" ");
            }
            i++;
        }
    }
    public static void outputArray2_2_3(int[] container){
        System.out.println("\nЭлементы массива в обратном порядке");
        int i = container.length-1;
        System.out.println("do...while: ");
        do {
            System.out.print(container[i]+" ");
        }while (--i >= 0);
        System.out.print("\nwhile: ");
        i = container.length-1;
        while(i >= 0){
            System.out.print(container[i]+" ");
            i--;
        }
        System.out.print("\nfor: ");
        for (i = container.length - 1; i >= 0; i--){
            System.out.print(container[i]+" ");
        }
        System.out.print("\nforeach: ");
        i = container.length-1;
        for(int j : container){
            System.out.print(container[i] + " ");
            i--;
        }
    }
    public static void main(String[] args) {
        int[] container = ArraysUtils.arrayFromConsole();
        outputArray2_2_1(container);
        outputArray2_2_2(container);
        outputArray2_2_3(container);
    }
}
