package test.unit;

import main.model.Resume;
import main.storage.Storage;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest {
    Storage storage;

    static final Resume resume1 = new Resume("uuid1");
    static final Resume resume2 = new Resume("uuid2");
    static final Resume resume3 = new Resume("uuid3");
    static final Resume resume4 = new Resume("uuid4");

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void size() {
    }

    @Test
    public void update() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void save() {
    }

    @Test
    public void get() {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void getAll() {
    }
}