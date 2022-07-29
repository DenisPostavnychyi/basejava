package main.storage.serializer;

import main.model.*;

import java.io.*;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(Resume resume, OutputStream os) {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());

            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }

            // TODO implements sections
            Map<SectionType, Section> sections = resume.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
                SectionType type = entry.getKey();
                Section section = entry.getValue();
                dos.writeUTF(type.name());
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        dos.writeUTF(((PersonalAndObjective) section).getDescription());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        List<String> stringList = ((AchievementAndQualifications) section).getElements();

                        dos.writeInt(stringList.size());
                        for (String item : stringList) {
                            dos.writeUTF(item);
                        }
                        break;
                    case EXPERIENCE:
                        List<ExperienceWork> listWork = ((ExperienceWorkSection) section).getExperiences();

                        dos.writeInt(listWork.size());
                        for (ExperienceWork item : listWork) {
                            writeCollection(dos, item);
                            dos.writeUTF(item.getDescription());
                        }
                        break;
                    case EDUCATION:
                        List<ExperienceEducation> listEdu = ((ExperienceEducationSection) section).getEducations();

                        dos.writeInt(listEdu.size());
                        for (ExperienceEducation item : listEdu) {
                            writeCollection(dos, item);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Resume doRead(InputStream is) {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);

            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }

            // TODO implements sections
            size = dis.readInt();
            SectionType sectionType;
            for (int i = 0; i < size; i++) {
                sectionType = SectionType.valueOf(dis.readUTF());
                switch (sectionType) {
                    case PERSONAL:
                    case OBJECTIVE:
                        resume.addSection(sectionType, new PersonalAndObjective(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        int sizeList = dis.readInt();
                        List<String> stringList = new ArrayList<>(sizeList);

                        for (int j = 0; j < sizeList; j++) {
                            stringList.add(dis.readUTF());
                        }

                        resume.addSection(sectionType, new AchievementAndQualifications(stringList));
                        break;
                    case EXPERIENCE:
                        sizeList = dis.readInt();
                        List<ExperienceWork> listWork = new ArrayList<>(sizeList);

                        for (int j = 0; j < sizeList; j++) {
                            listWork.add(new ExperienceWork(readDate(dis), readDate(dis), dis.readUTF(), dis.readUTF(), dis.readUTF(), dis.readUTF()));
                        }

                        resume.addSection(sectionType, new ExperienceWorkSection(listWork));
                        break;
                    case EDUCATION:
                        sizeList = dis.readInt();
                        List<ExperienceEducation> listEdu = new ArrayList<>(sizeList);

                        for (int j = 0; j < sizeList; j++) {
                            listEdu.add(new ExperienceEducation(readDate(dis), readDate(dis), dis.readUTF(), dis.readUTF(), dis.readUTF()));
                        }

                        resume.addSection(sectionType, new ExperienceEducationSection(listEdu));
                        break;
                }
            }
            return resume;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private <T extends AbstractExperience> void writeCollection(DataOutputStream dos, T item) {
        try {
            writeDate(dos, item.getStartDate());
            writeDate(dos, item.getEndDate());
            dos.writeUTF(item.getTitle());
            dos.writeUTF(item.getLink());
            dos.writeUTF(item.getObjective());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeDate(DataOutputStream dos, YearMonth yearMonth) {
        try {
            dos.writeInt(yearMonth.getYear());
            dos.writeInt(yearMonth.getMonthValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private YearMonth readDate(DataInputStream dis) {
        try {
            return YearMonth.of(dis.readInt(), dis.readInt());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
