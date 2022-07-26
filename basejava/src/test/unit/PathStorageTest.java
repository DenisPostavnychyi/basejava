package test.unit;

import main.storage.PathStorage;
import org.junit.Ignore;
import org.junit.Test;

public class PathStorageTest extends AbstractStorageTest{

    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath()));
    }

    @Ignore
    @Test
    public void saveOverflow() {
    }
}