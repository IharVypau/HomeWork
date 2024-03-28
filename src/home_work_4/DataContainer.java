package home_work_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class DataContainer<T> {
    private T[] data;
    private SortUtils<T> sorter;
    private int numOfElements = 0;

    public  DataContainer(T[] data){
        this.data = data;
        sorter = new SortUtils<>();
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
            for (int i = 0; i < data.length; i++){
                if(Objects.equals(data[i], item)){
                    deleteItemFromData(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void sort(Comparator<T> comparator) {
        sorter.mixSort(comparator, data);
    }

    public static  <T extends Comparable<T>> void sort(DataContainer<T> container){
        T[] data = container.getItems();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if(data[j].compareTo(data[j+1]) > 0){
                    T tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
    }
    /*
    * 12.* В DataContainer добавить СТАТИЧЕСКИЙ метод void sort(DataContainer<.............> container, Comparator<.......> comparator)
    * который будет принимать объект DataContainer и реализацию интерфейса Comparator.
    * Данный метод будет сортировать элементы в ПЕРЕДАННОМ объекте DataContainer используя реализацию сравнения из ПЕРЕДАННОГО объекта интерфейса Comparator.
    * */
    public static  <T> void sort(DataContainer<T> container, Comparator<? super T> comparator){
        T[] data = container.getItems();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if(comparator.compare(data[j], data[j+1]) > 0){
                    T tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
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
    public String toString(){
        String result = "[";
        for (int i =0; i < data.length; i++){
            result += data[i];
            if( i != data.length - 1){
                result += ", ";
            }
        }
        return result +"]";
    }

    public int compareTo(T o) {
        return 0;
    }
}
