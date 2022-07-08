package main.storage;

import main.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract int getIndex(String uuid);

    public abstract void update(Resume resume);

    public abstract int size();

    public abstract void save(Resume resume);

    public abstract Resume get(String uuid);

    public abstract void delete(String uuid);

    public abstract void clear();
}
