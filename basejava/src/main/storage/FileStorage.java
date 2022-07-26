package main.storage;

import main.model.Resume;

import java.io.*;

public class FileStorage extends AbstractFileStorage {

    public FileStorage(File directory) {
        super(directory);
    }

    @Override
    protected void doWrite(Resume resume, File file) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(resume);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Resume doRead(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();

            if (object instanceof Resume) {
                return (Resume) object;
            }

            System.out.println("The file is not a resume");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
