package main.storage.serializer;

import main.exception.StorageException;
import main.model.Resume;

import java.io.*;

public class ObjectStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume resume, OutputStream os) {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(resume);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Resume doRead(InputStream is) {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
