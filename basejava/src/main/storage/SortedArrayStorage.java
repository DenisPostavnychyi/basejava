package main.storage;

import main.exception.ExistStorageException;
import main.exception.StorageException;
import main.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow");
        }

        int index = getIndex(resume.getUuid());
        if (index > -1) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            int i = getIndex(resume.getUuid());
            if (i < 0) {
                i = -i - 1;
            }
            System.arraycopy(storage, i, storage, i + 1, size - i);
            storage[i] = resume;
            size++;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume resume = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, resume);
    }
}
