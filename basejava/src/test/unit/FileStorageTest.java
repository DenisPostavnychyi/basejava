package test.unit;

import main.storage.FileStorage;
import org.junit.Ignore;
import org.junit.Test;

public class FileStorageTest extends AbstractStorageTest {

    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR));
    }

    @Ignore
    @Test
    public void saveOverflow() {
    }
}