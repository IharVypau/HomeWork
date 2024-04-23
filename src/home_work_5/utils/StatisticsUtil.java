package home_work_5.utils;

import home_work_5.api.IGenerator;
import home_work_5.comparators.SortByAnimalAgeAndAnimalNames;
import home_work_5.comparators.SortUserByPasswordLengthAndNickName;
import home_work_5.entities.Animal;
import home_work_5.entities.Person;

import java.util.*;

public class StatisticsUtil {

    public <T> void initializeCollection(Collection<T> collection, int count, IGenerator<T> gen) {
        long start = System.currentTimeMillis();
        gen.generateCollection(collection, count);
        long total = System.currentTimeMillis() - start;
        displayStatistics("заполнение коллекции " + getCollectionNameAndType(collection), total);
    }
    public  void sortCollectionAnimalsUsingJdk(List<Animal> list) {
        long start = System.currentTimeMillis();
        list.sort(Comparator.comparing(Animal::getAge));
        long total = System.currentTimeMillis() - start;
        displayStatistics("сортировка коллекции Animals по годам используя comparing метод", total);
    }
    public <T> void sortCollectionPersonsUsingCustomComparators(List<T> list, Comparator<T> comp) {
        long start = System.currentTimeMillis();
        list.sort(comp);
        long total = System.currentTimeMillis() - start;
        displayStatistics("сортировка коллекции Person по длине пароля и имени, используя свой компаратор", total);
    }
    public <T> void sortCollectionPersonsUsingCustomSort(List<T> list, Comparator<T> comp) {
        long start = System.currentTimeMillis();
        SortUtil.insertionSort(list, comp);
        long total = System.currentTimeMillis() - start;
        displayStatistics("сортировка коллекции методом вставки", total);
    }

    public <T> void iterateCollectionUsingIterator(Collection<T> collection) {
        StringBuffer stringBuffer = new StringBuffer(1000_000);
        long start = System.currentTimeMillis();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        long total = System.currentTimeMillis() - start;
        displayStatistics("итерирование коллекции " + getCollectionNameAndType(collection), total);
    }

    public <T> void iterateListUsingFor(Collection<T> collection) {
        StringBuffer stringBuffer = new StringBuffer(1000_000);
        long start = System.currentTimeMillis();
        for (T item : collection) {
            stringBuffer.append(item);
        }
        long total = System.currentTimeMillis() - start;
        displayStatistics("итерирование коллекции через for " + getCollectionNameAndType(collection), total);
    }

    public <T> void removeElementsFromCollectionUsingIterator(Collection<T> collection) {
        if(collection.isEmpty()){
            return;
        }
        String collectionName = getCollectionNameAndType(collection);
        long start = System.currentTimeMillis();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            T item = it.next();
            if(collection.contains(item)){
                it.remove();
            }
        }
        long total = System.currentTimeMillis() - start;
        displayStatistics("удаления всех элементов коллекции "+collectionName+" используя iterator" , total);
    }

    public <T> void removeElementsFromCollectionUsingJdk(Collection<T> collection) {
        if(collection.isEmpty()){
            return;
        }
        String collectionName = getCollectionNameAndType(collection);
        long start = System.currentTimeMillis();
        collection.clear();
        long total = System.currentTimeMillis() - start;
        displayStatistics("удаления всех элементов коллекции "+ collectionName+" средствами jdk:", total);
    }

    private void displayStatistics(String operation, long time) {
        System.out.println("Операция: " + operation + ". Заняла: " + time + "мс");
    }

    private <T> String getCollectionNameAndType(Collection<T> collection) {
        String collectionName = (collection.getClass() + "").split("\\.")[2];
        String genericType = collection.iterator().next().getClass().getName().split("\\.")[2];
        return collectionName + "<" + genericType + ">";
    }

}
