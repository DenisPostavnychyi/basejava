package test.unit;

import main.exception.ExistStorageException;
import main.exception.NotExistStorageException;
import main.exception.StorageException;
import main.model.Resume;
import main.storage.AbstractArrayStorage;
import main.storage.ArrayStorage;
import org.junit.Assert;
import org.junit.Test;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void update() {
        Resume newResume = new Resume("uuid2");
        storage.update(newResume);
        Assert.assertSame(newResume, storage.get("uuid2"));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        Resume newResume = new Resume("dummy");
        storage.update(newResume);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() {
        storage.save(resume4);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(resume4, storage.get("uuid4"));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(resume1);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                Resume resume = new Resume();
                resume.setUuid("uuid"+ i);
                storage.save(resume);
            }
        } catch (StorageException e) {
            Assert.fail("Filled earlier than expected");
        }
        storage.save(new Resume());
    }

    @Test
    public void get() {
        Assert.assertEquals(resume1, storage.get("uuid1"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(resume1.getUuid());
        Assert.assertEquals(2, storage.size());
        storage.get(resume1.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void getAll() {
        Resume[] array = storage.getAll();
        Assert.assertEquals(3, array.length);
        Assert.assertEquals(resume1, array[0]);
        Assert.assertEquals(resume2, array[1]);
        Assert.assertEquals(resume3, array[2]);
    }
}