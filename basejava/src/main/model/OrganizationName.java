package main.model;

import java.io.Serializable;

public class OrganizationName implements Serializable {
    public String title;
    public String link;

    public OrganizationName(){}

    public OrganizationName(String title, String link) {
        this.title = title;
        this.link = link;
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
