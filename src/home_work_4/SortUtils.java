package home_work_4;

import java.util.Comparator;

public class SortUtils<T> {
    public T[] mixSort(Comparator<T> comparator, T[] data){
        int first = 0, last = data.length - 1, lastIndex;
        while(first < last){
            lastIndex = -1;
            for (int i = first; i < last; i++){
                if(comparator.compare(data[i], data[i + 1]) > 0 ){
                    swap(i, i + 1, data);
                    lastIndex = i;
                }
            }
            last = lastIndex;
            lastIndex = data.length + 1;
            for(int i = last; i > first; i--){
                if(comparator.compare(data[i - 1], data[i]) > 0 ){
                    swap(i, i - 1, data);
                    lastIndex = i;
                }
            }
            first = lastIndex;
        }
        return data;
    }
    private void swap(int idx1, int idx2, T[] data){
        T tmp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = tmp;
    }

}
