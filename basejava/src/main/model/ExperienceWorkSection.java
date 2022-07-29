package main.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExperienceWorkSection extends Section implements Serializable {
    private List<ExperienceWork> experienceWorks;

    public ExperienceWorkSection(){}

    public ExperienceWorkSection(List<ExperienceWork> experienceWorks){
        this.experienceWorks = Objects.requireNonNull(experienceWorks, "experienceWorks must not be null");
    }

    public List<ExperienceWork> getExperiences() {
        return experienceWorks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperienceWorkSection that = (ExperienceWorkSection) o;

        return experienceWorks.equals(that.experienceWorks);
    }

    @Override
    public int hashCode() {
        return experienceWorks.hashCode();
    }

    @Override
    public String toString() {
        return experienceWorks.toString();
    }
}
