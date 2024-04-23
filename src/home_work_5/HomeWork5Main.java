package home_work_5;

import home_work_5.comparators.SortByAnimalAge;
import home_work_5.comparators.SortByAnimalAgeAndAnimalNames;
import home_work_5.comparators.SortUserByPasswordLengthAndNickName;
import home_work_5.entities.Animal;
import home_work_5.entities.Person;
import home_work_5.additional.generators.AnimalGenerator;
import home_work_5.additional.generators.Generator;
import home_work_5.additional.generators.PersonGenerator;
import home_work_5.utils.SortUtil;
import home_work_5.utils.StatisticsUtil;

import java.util.*;
import java.util.stream.Collectors;

import static home_work_5.enums.EConfig.*;

public class HomeWork5Main {
    private static final int ELEMENTS_COUNT = 10_000;
    public static void main(String[] args) {

        List<Person> list1 = new ArrayList<>();
        List<Animal> list2 = new LinkedList<>();
        Set<Person> set1 = new HashSet<>();
        Set<Animal> set2 = new TreeSet<>(new SortByAnimalAge());

        StatisticsUtil statistics = new StatisticsUtil();

        Generator<Person> personGenerator = new PersonGenerator(FROM_FILE, FROM_RANDOM_SET, FROM_SET_OF_NAMES);
        Generator<Animal> animalGenerator = new AnimalGenerator(FROM_SET_OF_NAMES);

        statistics.initializeCollection(list1, ELEMENTS_COUNT, personGenerator);
        statistics.initializeCollection(list2, ELEMENTS_COUNT, animalGenerator);
        statistics.initializeCollection(set1, ELEMENTS_COUNT, personGenerator);
        statistics.initializeCollection(set2, ELEMENTS_COUNT, animalGenerator);
        System.out.println();
        statistics.sortCollectionPersonsUsingCustomComparators(list1, new SortUserByPasswordLengthAndNickName());
        statistics.sortCollectionAnimalsUsingJdk(list2);
        statistics.sortCollectionPersonsUsingCustomSort(list2, new SortByAnimalAgeAndAnimalNames());
        System.out.println();
        statistics.iterateCollectionUsingIterator(list1);
        statistics.iterateCollectionUsingIterator(list2);
        statistics.iterateCollectionUsingIterator(set1);
        statistics.iterateCollectionUsingIterator(set2);
        System.out.println();
        statistics.iterateListUsingFor(list1);
        statistics.iterateListUsingFor(list2);
        statistics.iterateListUsingFor(set1);
        statistics.iterateListUsingFor(set2);
        System.out.println();
        List<Person> list1Copy = new ArrayList<>(list1);
        List<Animal> list2Copy = new LinkedList<>(list2);
        Set<Person> set1Copy = new HashSet<>(set1);
        Set<Animal> set2Copy = new TreeSet<>(new SortByAnimalAge());
        set2Copy.addAll(set2);

        statistics.removeElementsFromCollectionUsingIterator(list1);
        statistics.removeElementsFromCollectionUsingIterator(list2);
        statistics.removeElementsFromCollectionUsingIterator(set1);
        statistics.removeElementsFromCollectionUsingIterator(set2);
        System.out.println();
        statistics.removeElementsFromCollectionUsingJdk(list1Copy);
        statistics.removeElementsFromCollectionUsingJdk(list2Copy);
        statistics.removeElementsFromCollectionUsingJdk(set1Copy);
        statistics.removeElementsFromCollectionUsingJdk(set2Copy);
    }



}
