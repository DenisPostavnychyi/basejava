package main.storage;

import main.exception.ExistStorageException;
import main.exception.NotExistStorageException;
import main.exception.StorageException;
import main.model.Resume;

import java.util.Arrays;

/**
 * Array based main.storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    public static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }
    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
            System.out.println("Resume successfully updated");
        }
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow");
        }

        int index = getIndex(resume.getUuid());
        if (index > -1) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            insertElement(resume);
            size++;
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        size--;
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[size] = null;
    }

    /**
     * @return array, contains only Resumes in main.storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract void insertElement(Resume r);
    protected abstract int getIndex(String uuid);
}
