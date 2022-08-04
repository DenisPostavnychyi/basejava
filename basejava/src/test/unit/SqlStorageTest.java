package test.unit;

import main.Config;
import main.exception.ExistStorageException;
import main.exception.NotExistStorageException;
import main.exception.StorageException;
import main.model.Resume;
import main.storage.AbstractArrayStorage;
import main.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.ResumeTestData;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SqlStorageTest  {

//    protected static final File STORAGE_DIR = Config.get().getStorageDir();
    protected static final File STORAGE_DIR = Config.get().getStorageDir();

    private Storage storage = Config.get().getStorage();


  /*  public SqlStorageTest() {
        this.storage = new SqlStorage("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
    }
*/
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = ResumeTestData.create(UUID_1, "Name1");
        RESUME_2 = ResumeTestData.create(UUID_2, "Name2");
        RESUME_3 = ResumeTestData.create(UUID_3, "Name3");
        RESUME_4 = ResumeTestData.create(UUID_4, "Name4");
    }


    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "New Name1");
        storage.update(newResume);
        assertEquals(newResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(list, Arrays.asList(RESUME_1, RESUME_2, RESUME_3));
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }

    // TODO remain only for Arrays implementations
    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                Resume resume = new Resume("uuid" + i, "Name" + i);
                storage.save(resume);
            }
        } catch (StorageException e) {
            Assert.fail("Filled earlier than expected");
        }
        storage.save(new Resume("Name"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}