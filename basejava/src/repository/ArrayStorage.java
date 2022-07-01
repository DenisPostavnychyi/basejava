package repository;

import model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    int size = 0;
    public Resume[] storage = new Resume[3];

    public void update(Resume resume) {
        int index = getIndex(resume.uuid);
        if (index >= 0) {
            storage[index] = resume;
            System.out.println("Resume successfully updated");
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Unable to save " + resume.uuid + ", storage is overflowing");
            return;
        }

        if (getIndex(resume.uuid) > -1) {
            System.out.println("Resume with this " + resume.uuid + " already in storage");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Resume with this " + uuid + " is apsent");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Unable to delete " + uuid + ", there is no such data");
            return;
        }
        size--;
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = Arrays.copyOfRange(storage, 0, size);
        return resumes;
    }

    public int size() {
        return size;
    }
}
