package main.model;

public enum SectionType {
    PERSONAL("Особисті якості"), // PersonalAndObjective
    OBJECTIVE("Позиція"), // PersonalAndObjective
    ACHIEVEMENT("Досягнення"), // AchievementAndQualifications
    QUALIFICATIONS("Кваліфікація"), // AchievementAndQualifications
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
