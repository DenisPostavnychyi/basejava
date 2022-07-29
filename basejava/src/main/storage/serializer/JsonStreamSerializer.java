package main.storage.serializer;

import main.model.Resume;
import main.util.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume resume, OutputStream os) {
        try (Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            JsonParser.write(resume, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Resume doRead(InputStream is) {
        try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return JsonParser.read(reader, Resume.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
