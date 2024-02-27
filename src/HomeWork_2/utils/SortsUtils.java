package HomeWork_2.utils;

import java.util.Arrays;

public class SortsUtils {
    public static void sort(int[] arr){
        System.out.print("Bubble sort: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i +1;j < arr.length; j++){
                if (arr[i] > arr[j]){
                    swap(i, j, arr);
                }
            }
        }
        System.out.println(" -> " + Arrays.toString(arr));
    }
    public static void shake(int[] arr){
        System.out.print("Shake sort: " +Arrays.toString(arr));
        int leftBorder = 0, rightBorder = arr.length -1;
        int last = -1, tmp;
        while(leftBorder < rightBorder){
            last = -1;
            for (int i = leftBorder; i < rightBorder; i++){
                if(arr[i] > arr[i+1]){
                    swap(i, i+1, arr);
                    last = i;
                }
            }
            rightBorder = last;
            last = arr.length;
            for (int i = rightBorder - 1; i >= leftBorder; i--){
                if(arr[i] > arr[i+1]){
                    swap(i, i+1, arr);
                    last = i;
                }
            }
            leftBorder = last;
        }
        System.out.println(" -> " + Arrays.toString(arr));
    }
    public static void swap(int a, int b, int[] arr){
        int tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }
}
