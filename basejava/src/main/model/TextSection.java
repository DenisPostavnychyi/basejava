package main.model;

import java.util.Objects;

public class TextSection implements Section{
    private String description;

    public TextSection(String description) {
        this.description = Objects.requireNonNull(description, "description must not be null");
    }

    public String getDescription(){
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

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
