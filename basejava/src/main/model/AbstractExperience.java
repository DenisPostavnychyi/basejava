package main.model;

import java.time.LocalDate;

public abstract class AbstractExperience{
    public LocalDate startDate;
    public LocalDate endDate;
    public String title;
    public String titleLink;
    public String objective;

    public AbstractExperience(LocalDate startDate, LocalDate endDate, String title, String titleLink, String objective) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.titleLink = titleLink;
        this.objective = objective;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
