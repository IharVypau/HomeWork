package home_work_5.comparators;

import home_work_5.entities.Person;

import java.util.Comparator;

public class SortUserByPasswordLengthAndNickName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int passLengthComp =  p1.getPassword().length() - p2.getPassword().length();
        int nickNameComp = p1.getNick().compareTo(p2.getNick());
        return passLengthComp !=0 ? passLengthComp
                : nickNameComp == 0 ? passLengthComp : nickNameComp;
    }
}
