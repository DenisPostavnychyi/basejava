package main.service;

import main.model.ContactType;
import main.model.SectionType;

public class ResumeService {
    public void print(main.model.Resume resume) {
        System.out.println("Uuid: " + resume.getUuid());
        System.out.println("Full name: " + resume.getFullName());

        System.out.println(resume.getContacts(ContactType.MOBILE_PHONE));
        System.out.println(resume.getContacts(ContactType.HOME_PHONE));
        System.out.println(resume.getContacts(ContactType.SKYPE));
        System.out.println(resume.getContacts(ContactType.MAIL));
        System.out.println(resume.getContacts(ContactType.LINKEDIN));
        System.out.println(resume.getContacts(ContactType.GITHUB));
        System.out.println(resume.getContacts(ContactType.STATCKOVERFLOW));
        System.out.println(resume.getContacts(ContactType.HOME_PAGE));

        System.out.println(resume.getSections(SectionType.PERSONAL));
        System.out.println(resume.getSections(SectionType.OBJECTIVE));
        System.out.println(resume.getSections(SectionType.ACHIEVEMENT));
        System.out.println(resume.getSections(SectionType.QUALIFICATIONS));
        System.out.println(resume.getSections(SectionType.EXPERIENCE));
        System.out.println(resume.getSections(SectionType.EDUCATION));
    }
}
