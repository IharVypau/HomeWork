package home_work_5.additional.generators;

import home_work_5.additional.initializers.AnimalInitializer;
import home_work_5.entities.Animal;
import home_work_5.entities.Entity;
import home_work_5.enums.EConfig;

import java.util.Collection;

public class AnimalGenerator extends Generator<Animal> {
    
    public AnimalGenerator(EConfig source_nick) {
        super(new AnimalInitializer(source_nick));
    }

    @Override
    public void generateCollection(Collection<Animal> collection, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(initializer.initialize());
        }
    }
}
