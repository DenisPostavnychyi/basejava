package main.storage;

import main.exception.ExistStorageException;
import main.exception.NotExistStorageException;
import main.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapHashCodeStorage extends AbstractStorage {
    private Map<Integer, Resume> map = new HashMap<>();

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    public void update(Resume resume) {
        if (!map.containsKey(resume.getUuid().hashCode())) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            map.replace(resume.getUuid().hashCode(), resume);
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void save(Resume resume) {
        if (map.containsKey(resume.getUuid().hashCode())) {
            throw new ExistStorageException(resume.getUuid());
        }
        map.put(resume.getUuid().hashCode(), resume);
    }

    @Override
    public Resume get(String uuid) {
        if (!map.containsKey(uuid.hashCode())) {
            throw new NotExistStorageException(uuid);
        }
        return map.get(uuid.hashCode());
    }

    @Override
    public void delete(String uuid) {
        if (!map.containsKey(uuid.hashCode())) {
            throw new NotExistStorageException(uuid);
        }
        map.remove(uuid.hashCode());
    }

    @Override
    public List<Resume> copyAll() {
        return new ArrayList<>(map.values());
    }
}
