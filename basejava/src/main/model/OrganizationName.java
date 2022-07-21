package main.model;

public class OrganizationName {
    public String title;
    public String link;

    public String getTitle(){
        return title;
    }

    public String getLink(){
        return link;
    }

    public OrganizationName(String title, String link){
        this.title = title;
        this.link = link;
    }

    @Override
    public boolean equals(Object o){
        OrganizationName that = (OrganizationName) o;

        return title.equals(that.title);
    }

    @Override
    public int hashCode(){
        return title.hashCode();
    }
}
