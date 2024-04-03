package home_work_2.arrays;

import home_work_2.utils.ArraysUtils;

import java.util.Arrays;

public class Ex2_4 {
    public int getSumEvenPositiveElements(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += ( ((i & 1) == 1) && arr[i] > 0) ? arr[i] : 0 ;
        }
        return sum;
    }
    public int getMaxEvenElementFromArray(int[] arr){
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if( (i & 1) == 0 && arr[i] > result){
                result = arr[i];
            }
        }
        return result;
    }
    public String getElementsLessAverage(int[] arr){
        int numOfElements =0, i =0 ;
        int sum = getSumOfElements(arr);
        int average = sum / arr.length;
        for(int value: arr){
            if(value <= average) numOfElements++;
        }
        int[] result = new int[numOfElements];
        for(int value: arr){
            if(value <= average) {
                result[i] = value;
                i++;
            }
        }
        String strArr = Arrays.toString(result);
        return strArr.substring(1, (strArr.length() - 1));
    }
    public String getTwoMinElementsFromArray(int[] arr){
        int a, b;
        if(arr.length >= 2){
            Arrays.sort(arr);
        } else {
            return "В массиве меньше 2-х элементов";
        }
        return arr[0] + ", " + arr[1];
    }

    public String removeElementsInInterval(int[] arr, int a, int b){
        int tmp, counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= a && arr[i] <= b){
                counter++;
            }else{
                arr[i - counter] = arr[i];
            }
        }
        for (int i = arr.length - counter; i < arr.length; i++) {
            arr[i] = 0;
        }
        return Arrays.toString(arr);
    }
    public int getSumOfElements(int[] arr){
        int sum = 0;
        for (int value: arr){
            sum += value;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] container = ArraysUtils.arrayRandom(50,100);
        Ex2_4 exe = new Ex2_4();
        System.out.println("Сумма четных положительных элементов массива: " + exe.getSumEvenPositiveElements(container));
        System.out.println("Максимальный из элементов массива с четными индексами: " + exe.getMaxEvenElementFromArray(container));
        System.out.println("Элементы массива, которые меньше среднего арифметического: " + exe.getElementsLessAverage(container));
        System.out.println("Два наименьших (минимальных) элемента массива: " + exe.getTwoMinElementsFromArray(container));
        System.out.println("Удалить элементы, принадлежащие интервалу от 5 до 10: " + exe.removeElementsInInterval(container, 5, 10));
        System.out.println("Сумма цифр массива: " + exe.getSumOfElements(container) );
    }
}
