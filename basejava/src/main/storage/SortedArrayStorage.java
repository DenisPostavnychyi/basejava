package main.storage;

import main.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume) {
        int i = getIndex(resume.getUuid());
        if (i < 0) {
            i = -i - 1;
        }
        System.arraycopy(storage, i, storage, i + 1, size - i);
        storage[i] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
