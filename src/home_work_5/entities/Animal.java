package home_work_5.entities;


import java.util.Objects;

public class Animal extends Entity {
    private int age;

    public Animal(int age, String name) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, getName());
    }

    @Override
    public String toString() {
        return "{" +
                "age=" + age +
                ", nick='" + getName() + '\'' +
                '}';
    }
}
