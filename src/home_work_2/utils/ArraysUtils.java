package home_work_2.utils;

import java.util.Scanner;


public class ArraysUtils {
    public static short MAX_SIZE_ARRAY =  200;
    public static short MIN_SIZE_ARRAY =  2;
    public static int[] arrayFromConsole(){
        int[] resultArr;
        Scanner input  = new Scanner(System.in);
        System.out.println("Введите желаемый размер массива");
        int sizeOfArr = input.nextInt();
        if(sizeOfArr <= MAX_SIZE_ARRAY && sizeOfArr>= MIN_SIZE_ARRAY){
            resultArr = new int[sizeOfArr];
            for (int i = 0; i < sizeOfArr ; i++) {
                System.out.printf("Введите значение для %d - го элемента массива: ", i);
                resultArr[i] = input.nextInt();
            }
        } else{
            System.out.println("Ошибка ввода. Размер массива должен быть от 2 до 200");
            resultArr = new int[0];
        }

    return resultArr;
    }
    public static int[] arrayRandom(int size, int maxValueExclusion){
        int[] resultArr = new int[size];
        for (int i = 0; i < size; i++) {
            resultArr[i] = (int) (Math.random() * (maxValueExclusion + 1));
        }
        return resultArr;
    }

}
