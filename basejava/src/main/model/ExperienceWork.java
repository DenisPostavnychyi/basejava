package main.model;

import java.time.LocalDate;

public class ExperienceWork extends AbstractExperience {
    private String description;

    public ExperienceWork(LocalDate startDate, LocalDate endDate, String title, String titleLink, String objective, String description) {
        super(startDate, endDate, title, titleLink, objective);
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperienceWork that = (ExperienceWork) o;

        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "title= " + title +
                ", startDate= " + startDate +
                ", endDate= " + endDate +
                ", titleLink= " + titleLink +
                ", objective= " + objective +
                ", description= " + description;
    }
}
