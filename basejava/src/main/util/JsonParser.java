package main.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.model.Section;

import java.io.Reader;
import java.io.Writer;

public class JsonParser {
    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Section.class, new JsonSectionAdapter())
            .create();

    public static <T> T read(Reader reader, Class<T> clazz) {
        return gson.fromJson(reader, clazz);
    }

    public static <T> void write(T object, Writer writer) {
        gson.toJson(object, writer);
    }

}

