package main;

import main.storage.SqlStorage;
import main.storage.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final File PROPS = new File("config/resumes.properties");
    private static final Config INSTANCE = new Config();

    private File storageDir;
    private final Storage storage;

    public static Config get() {
        return INSTANCE;
    }

    private Config() {
        try (InputStream is = new FileInputStream(PROPS)) {

            Properties props = new Properties();
     /*       System.out.println(props.getProperty("db.url"));
            System.out.println(props.getProperty("db.user"));
            System.out.println(props.getProperty("db.password"));*/


            props.load(is);
            storageDir = new File(props.getProperty("storage.dir"));
        //    storageDir = new File(props.getProperty("/"));

            storage = new SqlStorage(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
          //  storage = new SqlStorage("jdbc:postgresql://localhost:5432/postgres", "postgres","postgres");


        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPS.getAbsolutePath());
        }
    }

    public File getStorageDir() {
        return storageDir;
    }

    public Storage getStorage() {
        return storage;
    }
}
