package main.service;

import main.model.ContactType;
import main.model.Resume;
import main.model.SectionType;

public class ResumePrint {
    public void print(Resume resume) {
        System.out.println("Uuid: " + resume.getUuid());
        System.out.println("Full name: " + resume.getFullName());

        System.out.println(resume.getContact(ContactType.MOBILE_PHONE));
        System.out.println(resume.getContact(ContactType.HOME_PHONE));
        System.out.println(resume.getContact(ContactType.SKYPE));
        System.out.println(resume.getContact(ContactType.MAIL));
        System.out.println(resume.getContact(ContactType.LINKEDIN));
        System.out.println(resume.getContact(ContactType.GITHUB));
        System.out.println(resume.getContact(ContactType.STATCKOVERFLOW));
        System.out.println(resume.getContact(ContactType.HOME_PAGE));

        System.out.println(resume.getSection(SectionType.PERSONAL));
        System.out.println(resume.getSection(SectionType.OBJECTIVE));
        System.out.println(resume.getSection(SectionType.ACHIEVEMENT));
        System.out.println(resume.getSection(SectionType.QUALIFICATIONS));
        System.out.println(resume.getSection(SectionType.EXPERIENCE));
        System.out.println(resume.getSection(SectionType.EDUCATION));
    }
}
