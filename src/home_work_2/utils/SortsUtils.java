package home_work_2.utils;

import java.util.Arrays;

public class SortsUtils {
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i +1;j < arr.length; j++){
                if (arr[i] > arr[j]){
                    swap(i, j, arr);
                }
            }
        }
        return arr;
    }
    public static int[] shake(int[] arr){
        int leftBorder = 0, rightBorder = arr.length -1;
        int last = -1;
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
        return  arr;
    }
    private static void swap(int a, int b, int[] arr){
        int tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }
}
