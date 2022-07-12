package main.storage;

import main.model.Resume;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract int getIndex(String uuid);

    @Override
    public abstract void update(Resume resume);

    @Override
    public abstract void clear();

    @Override
    public abstract int size();

    @Override
    public abstract void save(Resume resume);

    @Override
    public abstract Resume get(String uuid);

    public abstract void delete(String uuid);

    public abstract List<Resume> copyAll();

    private Comparator<Resume> resume_FullName_Uuid_Comparator
            = Comparator.comparing(Resume::getFullName)
            .thenComparing(Resume::getUuid);

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = copyAll();
        Collections.sort(list, resume_FullName_Uuid_Comparator);
        return list;
    }
}
