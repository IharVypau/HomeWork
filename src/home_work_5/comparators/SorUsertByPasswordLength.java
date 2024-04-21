package home_work_5.comparators;

import home_work_5.entities.Person;

import java.util.Comparator;

public class SorUsertByPasswordLength implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getPassword().length() - p2.getPassword().length();
    }
}
