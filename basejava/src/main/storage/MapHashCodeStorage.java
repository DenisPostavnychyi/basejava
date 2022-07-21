package main.storage;

import main.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapHashCodeStorage extends AbstractStorage<Integer> {
    private Map<Integer, Resume> map = new HashMap<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        if (map.get(uuid.hashCode()) != null)
            return  uuid.hashCode();
        return null;
    }

    @Override
    protected boolean isExist(Integer index) {
        return index != null;
    }

    @Override
    public void doUpdate(Resume resume, Integer index) {
        map.replace(resume.getUuid().hashCode(), resume);
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
    public void doSave(Resume resume, Integer index) {
        map.put(resume.getUuid().hashCode(), resume);
    }

    @Override
    public Resume doGet(Integer index) {
        return map.get(index.hashCode());
    }

    @Override
    public void doDelete(Integer index) {
        map.remove(index.hashCode());
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }
}
