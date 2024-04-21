package home_work_5.api;

import home_work_5.entities.Entity;
import home_work_5.entities.Person;

public interface IEntityInitializer<T> {
    T initialize();
}
