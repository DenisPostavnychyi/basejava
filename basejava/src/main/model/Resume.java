package main.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Comparable<Resume>, Serializable {

    public static final Resume EMPTY = new Resume();

    static {
        EMPTY.setSection(SectionType.OBJECTIVE, PersonalAndObjective.EMPTY);
        EMPTY.setSection(SectionType.PERSONAL, PersonalAndObjective.EMPTY);
        EMPTY.setSection(SectionType.ACHIEVEMENT, AchievementAndQualifications.EMPTY);
        EMPTY.setSection(SectionType.QUALIFICATIONS, AchievementAndQualifications.EMPTY);
        EMPTY.setSection(SectionType.EXPERIENCE, new ExperienceWorkSection(ExperienceWork.EMPTY));
        EMPTY.setSection(SectionType.EDUCATION, new ExperienceEducationSection(ExperienceEducation.EMPTY));
    }

    private String uuid;
    private String fullName;

    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume() {
    }

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = Objects.requireNonNull(uuid, "uuid must not be null");
        this.fullName = Objects.requireNonNull(fullName, "fullName must not be null");
    }

    public String getUuid() {
        return uuid;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public Map<ContactType, String> getContacts(){
        return contacts;
    }

    public void setContacts(Map<ContactType, String> contacts) {
        this.contacts = contacts;
    }

    public Map<SectionType, Section> getSections() {
        return sections;
    }

    public void setSections(Map<SectionType, Section> sections) {
        this.sections = sections;
    }

    public Section getSection(SectionType sectionType){
        return sections.get(sectionType);
    }

    public void setContact(ContactType type, String value) {
        contacts.put(type, value);
    }

    public void setSection(SectionType type, Section section) {
        sections.put(type, section);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid + " " + fullName;
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }

}