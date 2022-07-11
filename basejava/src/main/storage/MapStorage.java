package main.storage;

import main.exception.ExistStorageException;
import main.exception.NotExistStorageException;
import main.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage{
    private Map<String, Resume> map = new HashMap<>();
    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    public void update(Resume resume) {
        if (!map.containsValue(resume)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            map.replace(resume.getUuid(),resume);
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
        if (map.containsValue(resume)) {
            throw new ExistStorageException(resume.getUuid());
        }
        map.put(resume.getUuid(), resume);
    }

    @Override
    public Resume get(String uuid) {
        if (!map.containsKey(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return map.get(uuid);
    }

    @Override
    public void delete(String uuid) {
        if (!map.containsKey(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        map.remove(uuid);
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }
}
