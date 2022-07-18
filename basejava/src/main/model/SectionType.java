package main.model;

public enum SectionType {
    PERSONAL("Особисті якості"), // TextSection
    OBJECTIVE("Позиція"), // TextSection
    ACHIEVEMENT("Досягнення"), // ListSection
    QUALIFICATIONS("Кваліфікація"), // ListSection
    EXPERIENCE("Досвід роботи"), // ExperienceWorkSection
    EDUCATION("Освіта"); // ExperienceEducationSection

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
