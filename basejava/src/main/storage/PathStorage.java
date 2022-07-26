package main.storage;

import main.model.Resume;

import java.io.*;

public class PathStorage extends AbstractPathStorage {

    public PathStorage(String directory) {
        super(directory);
    }

    @Override
    protected void doWrite(Resume resume, OutputStream os) {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(resume);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Resume doRead(InputStream is) {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
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