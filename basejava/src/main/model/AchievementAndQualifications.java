package main.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AchievementAndQualifications extends Section implements Serializable {

    public static final AchievementAndQualifications EMPTY = new AchievementAndQualifications("");

    private List<String> elements;

    public AchievementAndQualifications(){}

    public AchievementAndQualifications(String... elements) {
        this(Arrays.asList(elements));
    }

    public AchievementAndQualifications(List<String> elements) {
        this.elements = Objects.requireNonNull(elements, "elements must not be null");
    }

    public List<String> getElements(){
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AchievementAndQualifications that = (AchievementAndQualifications) o;

        return elements.equals(that.elements);
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
