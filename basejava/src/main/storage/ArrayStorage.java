package main.storage;

import main.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertElement(Resume resume) {
        storage[size] = resume;
    }
    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}