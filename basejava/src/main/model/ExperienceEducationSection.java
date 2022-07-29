package main.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExperienceEducationSection extends Section implements Serializable {
    private List<ExperienceEducation> experienceEducations;

    public ExperienceEducationSection(){}

    public ExperienceEducationSection(List<ExperienceEducation> experienceEducations) {
        this.experienceEducations = Objects.requireNonNull(experienceEducations, "experienceEducation must not be null");
    }

    public List<ExperienceEducation> getEducations() {
        return experienceEducations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperienceEducationSection that = (ExperienceEducationSection) o;

        return experienceEducations.equals(that.experienceEducations);
    }

    @Override
    public int hashCode() {
        return experienceEducations.hashCode();
    }

    @Override
    public String toString() {
        return experienceEducations.toString();
    }
}
