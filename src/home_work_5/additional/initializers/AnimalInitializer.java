package home_work_5.additional.initializers;

import home_work_5.api.IEntityInitializer;
import home_work_5.entities.Animal;
import home_work_5.entities.Person;
import home_work_5.enums.EConfig;
import home_work_5.additional.generators.StringRandomGenerator;

public class AnimalInitializer implements IEntityInitializer<Animal> {
    private EConfig SOURCE_NICK;
    public AnimalInitializer(EConfig source_nick) {
        this.SOURCE_NICK = source_nick;
    }

    public Animal initialize(){
        int age = (int) (Math.random() * 20);
        String nickName = StringRandomGenerator
                .getRandomStringFromSet(SOURCE_NICK.getData(),1);
        return new Animal(age, nickName);
    }
}
