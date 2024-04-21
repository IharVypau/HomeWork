package home_work_5.comparators;

import home_work_5.entities.Animal;

import java.util.Comparator;

public class SortByAnimalAgeAndAnimalNames implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        int age =  a1.getAge() - a2.getAge();
        int name = a1.getName().compareTo(a2.getName());
        return age !=0 ? age
                : name == 0 ? age : name;
    }
}
