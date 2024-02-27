package home_work_2.utils;

import java.util.Scanner;


public class ArraysUtils {
    public static int[] arrayFromConsole(){
        int[] resultArr;
        Scanner input  = new Scanner(System.in);
        System.out.println("Введите желаемый размер массива");
        int sizeOfArr = input.nextInt();
        resultArr = new int[sizeOfArr];
        for (int i = 0; i < sizeOfArr ; i++) {
            System.out.printf("Введите значение для %d - го элемента массива: ", i);
            resultArr[i] = input.nextInt();
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
