package home_work_5.entities;


import java.util.Objects;

public class Person extends Entity implements Comparable<Person> {
    private String nick;
    private String password;

    public Person(String nick, String password, String name) {
        super(name);
        this.nick = nick;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getNick() {
        return nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }


    @Override
    public String toString() {
        return  "{ name='" + getName() + '\'' +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        return getName().compareTo(p.getName());
    }
}
