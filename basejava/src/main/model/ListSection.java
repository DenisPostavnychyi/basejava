package main.model;

import java.util.List;
import java.util.Objects;

public class ListSection implements Section{
    private List<String> elements;

    public ListSection(List<String> elements) {
        this.elements = Objects.requireNonNull(elements, "elements must not be null");
    }

    public List<String> getElements(){
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

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
