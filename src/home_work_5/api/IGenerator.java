package home_work_5.api;

import home_work_5.entities.Entity;

import java.util.Collection;

public interface IGenerator<T> {
    void generateCollection(Collection<T> collection, int count);
}
