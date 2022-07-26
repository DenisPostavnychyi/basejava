package main.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ExperienceWorkSection implements Section, Serializable {
    public List<ExperienceWork> experienceWorks;

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
