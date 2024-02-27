package home_work_2.arrays;

import home_work_2.utils.ArraysUtils;

/*
* 2. Массивы:
   2.1. Создать класс ArraysUtils. В этом классе не должно быть main метода. В этом классе написать следующие методы:
   2.1.1. Написать метод public static int[] arrayFromConsole(). Данный метод размер массива и каждый его элемент запрашивает у пользователя через консоль.
   2.1.1.1. Пример в отдельном классе с main. int[] container = arrayFromConsole(). Результат: В методе arrayFromConsole будет запрошена информация у пользователя, пользователь вводит размер (3) и его элементы по порядку {4, 17, 32}. Соответсвенно будет создан массив размером 3 с элементами {4, 17, 32} и сохранён в переменную container.
   2.1.2. Написать метод public static int[] arrayRandom(int size, int maxValueExclusion). Данный метод принимает два аргумента. Первый (size) указывает размер массива который мы хотим получить. Второй (maxValueExclusion) указывает до какого числа генерировать рандомные числа.
   2.1.2.1. Пример в отдельном классе с main. int[] container = arrayRandom(5, 100). Результат: В методе arrayRandom будет создан массив размером 5 с числами от 0 до 99 (использовать класс Random) и сохранён в переменную container.
   2.2 Создать класс ArraysIteration. В этом классе написать перебор (итерирование) массива при помощи do....while, while, for, foreach. Вызывая ранее созданный метод arrayFromConsole (ArraysUtils.arrayFromConsole()) получить массив.
   *  Все задачи в одном классе, в отдельных методах, в каждом методе используется 4 разных цикла. Должно получиться 3 метода:
   2.2.1. Вывести все элементы в консоль.
   2.2.2. Вывести каждый второй элемент массива в консоль.
   2.2.3. Вывести все элементы массива в консоль в обратном порядке.
   2.3* Выполнить задание 2.2 иным способом. Создать интерфейс IArraysOperation с методами из задания, каждый метод должен принимать массив с которым он будет работать. Написать 4 отдельных класса и реализовать данный интерфейс:
   2.3.1. DoWhileOperation - во всех методах можно использовать только do....while
   2.3.2. WhileOperation - во всех методах можно использовать только while
   2.3.3. ForOperation - во всех методах можно использовать только for
   2.3.4. ForEachOperation - во всех методах можно использовать только foreach

   * 2.4 Задачи в презентации. На сайте есть пояснения по каждой из этих задач.
   * Все задачи в одном классе, в отдельных методах.
   * Для получения массивов вызывать ранее созданный метод arrayRandom (ArraysUtils.arrayRandom(50, 100))
   2.4.1. Сумма четных положительных элементов массива
   2.4.2. Максимальный из элементов массива с четными индексами
   2.4.3. Элементы массива, которые меньше среднего арифметического
   2.4.4. Найти два наименьших (минимальных) элемента массива
   2.4.5. Сжать массив, удалив элементы, принадлежащие интервалу
   2.4.6. Сумма цифр массива
   * */
public class Ex2 {
    private static int[] container, container2;
    static void outputArray(IArraysOperation operation, int[] arr){
        operation.outputArray2_2_1(arr);
        operation.outputArray2_2_2(arr);
        operation.outputArray2_2_3(arr);
    }

    public static void main(String[] args) {
        container = ArraysUtils.arrayFromConsole();
        container2 = ArraysUtils.arrayRandom(5, 102);
        IArraysOperation doWhileOperation = new DoWhileOperation();
        IArraysOperation whileOperation = new WhileOperation();
        IArraysOperation forOperation = new ForOperation();
        IArraysOperation forEachOperation = new ForEachOperation();
        outputArray(doWhileOperation, container);
        outputArray(whileOperation, container);
        outputArray(forOperation, container);
        outputArray(forEachOperation, container);
    }
}
