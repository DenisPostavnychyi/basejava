package main.storage;

import main.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based main.storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    public static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void doUpdate(Resume resume, Integer index) {
            storage[index] = resume;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    public void doDelete(Integer index) {
        size--;
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[size] = null;
    }

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    public abstract void doSave(Resume resume, Integer index);
    protected abstract Integer getSearchKey(String uuid);
}
