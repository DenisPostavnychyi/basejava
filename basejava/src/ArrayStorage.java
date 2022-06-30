import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    int size = 0;
    public Resume[] storage = new Resume[10000];

    void clear() {
        size = 0;
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; storage[i] != null; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int i, j;
        for (i = 0, j = 0; storage[i] != null; i++, j++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
                j++;
                size--;
            }
            storage[i] = storage[j];
        }
        storage[j] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] array = new Resume[size];
        System.arraycopy(storage, 0, array, 0, size);
        return array;
    }

    int size() {
        return size;
    }
}
