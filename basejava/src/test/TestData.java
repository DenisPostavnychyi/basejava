package test;

import main.model.*;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.UUID;

public class TestData {
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.setContact(ContactType.MAIL, "mail1@ya.ru");
        R1.setContact(ContactType.MOBILE_PHONE, "11111");

        R4.setContact(ContactType.MOBILE_PHONE, "44444");
        R4.setContact(ContactType.SKYPE, "Skype");

        R1.setSection(SectionType.OBJECTIVE, new PersonalAndObjective("Objective1"));
        R1.setSection(SectionType.PERSONAL, new PersonalAndObjective("Personal data"));
        R1.setSection(SectionType.ACHIEVEMENT, new AchievementAndQualifications("Achivment11", "Achivment12", "Achivment13"));
        R1.setSection(SectionType.QUALIFICATIONS, new AchievementAndQualifications("Java", "SQL", "JavaScript"));
        R1.setSection(SectionType.EXPERIENCE, new ExperienceWorkSection(Arrays.asList(new ExperienceWork(YearMonth.of(2013, 10), YearMonth.now(),
                "Work1", "http://Work1.ru", "position1", "description1"))));
        R1.setSection(SectionType.EXPERIENCE, new ExperienceWorkSection(Arrays.asList(new ExperienceWork(YearMonth.of(2014, 10), YearMonth.of(2016, 1),
                "Work1", "http://Work1.ru", "position11", "description11"))));
        R1.setSection(SectionType.EXPERIENCE, new ExperienceWorkSection(Arrays.asList(new ExperienceWork(YearMonth.of(2012, 4), YearMonth.of(2014, 10),
                "Work2", "http://Work2.ru", "position2", "description2"))));
        R1.setSection(SectionType.EDUCATION, new ExperienceEducationSection(Arrays.asList(new ExperienceEducation(YearMonth.of(2001, 4), YearMonth.of(2005, 12),
                "Institute", "http://Institute.ru", "aspirant"))));
        R1.setSection(SectionType.EDUCATION, new ExperienceEducationSection(Arrays.asList(new ExperienceEducation(YearMonth.of(1996, 3), YearMonth.of(2000, 10),
                "Institute", "http://Institute.ru", "student"))));
        R1.setSection(SectionType.EDUCATION, new ExperienceEducationSection(Arrays.asList(new ExperienceEducation(YearMonth.of(1900, 1), YearMonth.of(1900, 7),
                "Edu1", "http://Edu1.ru", "student"))));

        R2.setContact(ContactType.SKYPE, "skype2");
        R2.setContact(ContactType.MOBILE_PHONE, "22222");
    }
}
