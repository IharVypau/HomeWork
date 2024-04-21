package home_work_5.additional.generators;

import home_work_5.api.IEntityInitializer;
import home_work_5.api.IGenerator;
import home_work_5.entities.Entity;

import java.util.Collection;

public abstract class Generator<T> implements IGenerator<T> {
    protected IEntityInitializer<T> initializer;

    public Generator(IEntityInitializer<T> initializer) {
        this.initializer = initializer;
    }

    public abstract void generateCollection(Collection<T> collection, int count);
}
