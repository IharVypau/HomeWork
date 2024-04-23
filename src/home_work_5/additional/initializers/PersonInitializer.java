package home_work_5.additional.initializers;

import home_work_5.api.IEntityInitializer;
import home_work_5.entities.Entity;
import home_work_5.entities.Person;
import home_work_5.enums.EConfig;
import home_work_5.additional.generators.StringRandomGenerator;

public class PersonInitializer implements IEntityInitializer<Person>{
    private static final StringRandomGenerator generator = new StringRandomGenerator();
    private final EConfig SOURCE_NAMES, SOURCE_PASSWORD, SOURCE_NICK;
    public PersonInitializer(EConfig SOURCE_NAMES, EConfig SOURCE_PASSWORD, EConfig SOURCE_NICK) {
        this.SOURCE_NAMES = SOURCE_NAMES;
        this.SOURCE_PASSWORD = SOURCE_PASSWORD;
        this.SOURCE_NICK = SOURCE_NICK;
    }

     public  Person initialize(){
        String name = generator.getRandomStringFromSet(SOURCE_NAMES.getData(), 1);
        String password = generator.getRandomStringFromSet(SOURCE_PASSWORD.getData(),5);
        String nickName = generator.getRandomStringFromSet(SOURCE_NICK.getData(),1);
        return new Person(nickName, password, name);
    }

}
