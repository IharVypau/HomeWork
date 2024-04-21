package home_work_5;

import home_work_5.comparators.SorUsertByPasswordLength;
import home_work_5.comparators.SortByAnimalAge;
import home_work_5.comparators.SortByAnimalAgeAndAnimalNames;
import home_work_5.comparators.SortUserByPasswordLengthAndNickName;
import home_work_5.entities.Animal;
import home_work_5.entities.Person;
import home_work_5.additional.generators.AnimalGenerator;
import home_work_5.additional.generators.Generator;
import home_work_5.additional.generators.PersonGenerator;
import home_work_5.utils.SortUtil;

import java.util.*;
import java.util.stream.Collectors;

import static home_work_5.enums.EConfig.*;

public class HomeWork5Main {
    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<>();
        List<Animal> list2 = new LinkedList<>();
        Set<Person> set1 = new HashSet<>();
        Set<Animal> set2 = new TreeSet<>(new SortByAnimalAge());

        Generator<Person> personGenerator = new PersonGenerator(FROM_FILE, FROM_RANDOM_SET, FROM_SET_OF_NAMES);
        Generator<Animal> animalGenerator = new AnimalGenerator(FROM_SET_OF_NAMES);

        initializeCollection(list1,personGenerator, 100_000, "Заполнения коллекции ArrayList<Person>");
        initializeCollection(list2,animalGenerator, 100_000, "Заполнения коллекции LinkedList<Animal>");
        initializeCollection(set1,personGenerator, 100_000, "Заполнения коллекции HashSet<Person>");
        initializeCollection(set1,personGenerator, 100_000, "Заполнения коллекции TreeSet<Animal>");

        iterateCollectionUsingIterator(list1, "Итерирования коллекции ArrayList<Person>");
        iterateCollectionUsingIterator(list2, "Итерирования коллекции LinkedList<Animal>");
        iterateCollectionUsingIterator(set1, "Итерирования коллекции HashSet<Person>");
        iterateCollectionUsingIterator(set2, "Итерирования коллекции TreeSet<Animal>");

        iterateListUsingFor(list1, "Итерирования коллекции при помощи for ArrayList<Person>");
        iterateListUsingFor(list2, "Итерирования коллекции при помощи for LinkedList<Animal>");
        //iterateSetUsingFor(set1, "Итерирования коллекции HashSet<Person>");
        //iterateSetUsingFor(set2, "Итерирования коллекции TreeSet<Animal>");

        list1.sort(new SortUserByPasswordLengthAndNickName());
        list2.sort(Comparator.comparing(Animal::getAge));
        SortUtil.insertionSort(list2, new SortByAnimalAgeAndAnimalNames());

    }

    private static <T> void initializeCollection(Collection<T> collection, Generator<T> gen, int count, String op){
        long start = System.currentTimeMillis();
        gen.generateCollection(collection, count);
        long total = System.currentTimeMillis() - start;
        displayStatistics(op, total);
    }
    private static <T> void iterateCollectionUsingIterator(Collection<T> collection, String op){
        long start = System.currentTimeMillis();
        Iterator<T> it = collection.iterator();
        while(it.hasNext()){
            it.next();
        }
        long total = System.currentTimeMillis() - start;
        displayStatistics(op, total);
    }

    private static <T> void iterateListUsingFor(List<T> collection, String op){
        long start = System.currentTimeMillis();
        for (int i = 0; i < collection.size(); i++) {
            collection.get(i);
        }
        long total = System.currentTimeMillis() - start;
        displayStatistics(op, total);
    }

    private static void displayStatistics(String op, long time){
        System.out.println(op +": " + time+"ms");
    }


}
