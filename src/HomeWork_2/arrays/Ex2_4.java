package HomeWork_2.arrays;

import HomeWork_2.utils.ArraysUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex2_4 {
    static int getSumEvenPositiveElements(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += ( ((i & 1) == 1) && arr[i] > 0) ? arr[i] : 0 ;
        }
        return sum;
    }
    static int getMaxEvenElementFromArray(int[] arr){
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if( (i & 1) == 1 && arr[i] > result){
                result = arr[i];
            }
        }
        return result;
    }
    static String getElementsLessAverage(int[] arr){
        int sum = 0, numOfElements =0, i =0 ;
        for(int value: arr){
            sum += value;
        }
        int average = sum / arr.length;
        for(int value: arr){
            if(value < average) numOfElements++;
        }
        int[] result = new int[numOfElements];
        for(int value: arr){
            if(value < average) {
                result[i] = value;
                i++;
            }
        }
        String strArr = Arrays.toString(result);
        return strArr.substring(1, (strArr.length() - 1));
    }
    public static void main(String[] args) {
        int[] container = ArraysUtils.arrayRandom(50,100);
        System.out.println("Сумма четных положительных элементов массива: " + getSumEvenPositiveElements(container));
        System.out.println("Максимальный из элементов массива с четными индексами: " + getMaxEvenElementFromArray(container));
        System.out.print("Элементы массива, которые меньше среднего арифметического: " + getElementsLessAverage(new int[]{1,2,2,3,4}));
    }
}
