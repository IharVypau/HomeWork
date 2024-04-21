package home_work_5.additional.generators;

import home_work_5.additional.initializers.PersonInitializer;
import home_work_5.entities.Entity;
import home_work_5.entities.Person;
import home_work_5.enums.EConfig;

import java.util.Collection;

public class PersonGenerator extends Generator<Person> {
    public PersonGenerator(EConfig source_names, EConfig source_password, EConfig source_nick) {
        super(new PersonInitializer(source_names, source_password, source_nick));
    }

    @Override
    public void generateCollection(Collection<Person> collection, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(initializer.initialize());
        }
    }
}
