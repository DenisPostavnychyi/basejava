package main.storage;

import main.exception.StorageException;
import main.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    public void doSave(Resume resume,  Integer index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow");
        }
        storage[size] = resume;
        size++;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
