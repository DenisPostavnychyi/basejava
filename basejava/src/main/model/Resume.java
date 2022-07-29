package main.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Comparable<Resume>, Serializable {
    private String uuid;
    private String fullName;

    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume() {
    }

    public Resume(String uuid) {
        this.uuid = uuid;
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

    public void addContact(ContactType type, String value) {
        contacts.put(type, value);
    }

    public void addSection(SectionType type, Section section) {
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