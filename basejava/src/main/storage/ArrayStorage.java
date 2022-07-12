package main.storage;

import main.exception.ExistStorageException;
import main.exception.StorageException;
import main.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow");
        }

        int index = getIndex(resume.getUuid());
        if (index > -1) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            storage[size] = resume;
            size++;
        }
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
