package main.model;

import java.io.Serializable;
import java.util.Objects;

public class PersonalAndObjective extends Section implements Serializable {

    public static final PersonalAndObjective EMPTY = new PersonalAndObjective("");

    private String description;

    public PersonalAndObjective(){}

    public PersonalAndObjective(String description) {
        this.description = Objects.requireNonNull(description, "description must not be null");
    }

    public String getDescription(){
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalAndObjective that = (PersonalAndObjective) o;

        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }

    @Override
    public String toString() {
        return description;
    }
}
