package home_work_4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class DataContainer<T> {
    private T[] data;
    private int numOfElements = 0;

    public  DataContainer(T[] data){
        this.data = data;
    }

    public int add(T item) {
        if(item == null){
            return -1;
        }
        if (isFull()) {
            data = Arrays.copyOf(data, data.length+1);
        }
        int index = numOfElements++;
        data[index] = item;
        return index;
    }

    public T get(int index){
        if(index > data.length){
            return null;
        }
        return data[index];
    }
    public T[] getItems(){
        return data;
    }
    public boolean delete(int index){
        if(!isEmpty() && numOfElements > index){
            deleteItemFromData(index);
            return true;
        }
        return false;
    }

    public boolean delete(T item){
        if(!isEmpty() && item != null){
            for (int i = 0; i < data.length;i++){
                if(Objects.equals(data[i], item)){
                    deleteItemFromData(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void sort(Comparator<T> comparator) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (comparator.compare(data[i], data[j]) > 0) {
                    T tmp = data[j];
                    data[j] = data[i];
                    data[i] = tmp;
                }
            }
        }
    }
    private void deleteItemFromData(int deleteIndex){
        for (int i = deleteIndex; i < data.length - 1; i++) {
            data[i] = data[i+1];
        }
        data = Arrays.copyOf(data, data.length - 1);
    }
    private boolean isFull() {
        return numOfElements == data.length;
    }
    private boolean isEmpty(){
        return numOfElements == 0;
    }
}
