package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

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
            System.out.println("Resume " + resume.getUuid() + " not exist");
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
        if (size >= storage.length) {
            System.out.println("Unable to save " + resume.uuid + ", storage is overflowing");
            return;
        }

        int index = getIndex(resume.getUuid());
        if (index > -1) {
            System.out.println("Resume " + resume.uuid + " already in storage");
        } else {
            insertElement(resume);
            size++;
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + ", not exist");
            return;
        }
        size--;
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract void insertElement(Resume r);
    protected abstract int getIndex(String uuid);
}
