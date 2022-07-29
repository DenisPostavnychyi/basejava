package main.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.time.YearMonth;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExperienceWork extends AbstractExperience {
    protected String description;

    public ExperienceWork(){
        super();
    }

    public ExperienceWork(YearMonth startDate, YearMonth endDate, String title, String titleLink, String objective, String description) {
        super(startDate, endDate, title, titleLink, objective);
        this.description = description;
    }

    public ExperienceWork(YearMonth startDate, YearMonth endDate, String title, String link, String objective) {
        super(startDate, endDate, title, link, objective);
    }

    public String getDescription() {
        return description;
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
                ", titleLink= " + link +
                ", startDate= " + startDate +
                ", endDate= " + endDate +
                ", objective= " + objective +
                ", description= " + description + "\n";
    }
}
