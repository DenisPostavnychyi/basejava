package main.storage;

import main.exception.StorageException;
import main.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void doSave(Resume resume, Integer index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow");
        }

        int i = getSearchKey(resume.getUuid());
        if (i < 0) {
            i = -i - 1;
        }
        System.arraycopy(storage, i, storage, i + 1, size - i);
        storage[i] = resume;
        size++;
    }
    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
