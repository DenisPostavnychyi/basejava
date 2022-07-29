package main.storage.serializer;

import main.model.*;
import main.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XmlStreamSerializer implements StreamSerializer {
    private XmlParser xmlParser;

    public XmlStreamSerializer() {
        xmlParser = new XmlParser(
                Resume.class, ExperienceEducation.class, ExperienceEducationSection.class, ExperienceWork.class,
                ExperienceWorkSection.class, PersonalAndObjective.class, AchievementAndQualifications.class);
    }

    @Override
    public void doWrite(Resume resume, OutputStream os) {
        try (Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marshall(resume, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Resume doRead(InputStream is) {
        try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
