package main.model;

public enum ContactType {
    MOBILE_PHONE("Мобільний тел.: "),
    HOME_PHONE("Домашній тел.: "),
    SKYPE("Skype: "),
    MAIL("Пошта: "),
    LINKEDIN("Профіль LinkedIn"),
    GITHUB("Профіль GitHub"),
    STATCKOVERFLOW("Профіль Stackoverflow"),
    HOME_PAGE("Домашня сторінка");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
