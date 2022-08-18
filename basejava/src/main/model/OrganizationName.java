package main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrganizationName implements Serializable {
    public String title;
    public String link;

    public static List<AbstractExperience> experiences = new ArrayList<>();

    public static List<AbstractExperience> getExperiences() {
        return experiences;
    }

    public OrganizationName(){}

    public OrganizationName(String title, String link, AbstractExperience... experiences) {
        this.title = title;
        this.link = link;
        this.experiences = Arrays.asList(experiences);
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        OrganizationName that = (OrganizationName) o;

        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
