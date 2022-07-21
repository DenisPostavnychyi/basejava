package main.model;

import java.time.YearMonth;

public class ExperienceEducation extends AbstractExperience {

    public ExperienceEducation(YearMonth startDate, YearMonth endDate, String title, String titleLink, String objective) {
        super(startDate, endDate, title, titleLink, objective);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperienceEducation that = (ExperienceEducation) o;

        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "title= " + title +
                ", titleLink= " + link +
                ", startDate= " + startDate +
                ", endDate= " + endDate +
                ", objective= " + objective + "\n";
    }
}
