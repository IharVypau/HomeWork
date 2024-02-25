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
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if( (i & 1) == 1 && arr[i] > result){
                result = arr[i];
            }
        }
        return result;
    }
    static String getElementsLessAverage(int[] arr){
        int numOfElements =0, i =0 ;
        int sum = getSumOfElements(arr);
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
    static String getTwoMinElementsFromArray(int[] arr){
        int a, b;
        if(arr.length >= 2){
            Arrays.sort(arr);
        } else {
            return "В массиве меньше 2-х элементов";
        }
        return arr[0] + ", " + arr[1];
    }

    static String removeElementsInInterval(int[] arr, int a, int b){
        int tmp, counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= a && arr[i] <= b){
                counter++;
            }else{
                arr[i - counter] = arr[i];
            }
        }
        for (int i = arr.length-1; i >= arr.length - counter; i--) {
            arr[i] = 0;
        }
        return Arrays.toString(arr);
    }
    static int getSumOfElements(int[] arr){
        int sum = 0;
        for (int value: arr){
            sum += value;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] container = ArraysUtils.arrayRandom(50,100);
        System.out.println("Сумма четных положительных элементов массива: " + getSumEvenPositiveElements(container));
        System.out.println("Максимальный из элементов массива с четными индексами: " + getMaxEvenElementFromArray(container));
        System.out.println("Элементы массива, которые меньше среднего арифметического: " + getElementsLessAverage(container));
        System.out.println("Два наименьших (минимальных) элемента массива: " + getTwoMinElementsFromArray(container));
        System.out.println("Удалить элементы, принадлежащие интервалу от 5 до 10: " + removeElementsInInterval(container, 5, 10));
        System.out.println("Сумма цифр массива: " + getSumOfElements(container) );
    }
}
