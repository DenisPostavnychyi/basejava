package main.model;

import java.util.Objects;

public class Link {
    private String name;
    private String url;

    public Link(String name, String url) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Link(" + name + ',' + url + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!name.equals(link.name)) return false;
        return url != null ? url.equals(link.url) : link.url == null;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
