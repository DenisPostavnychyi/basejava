package test.unit;

import main.storage.PathStorage;
import main.storage.serializer.ObjectStreamSerializer;
import org.junit.Ignore;
import org.junit.Test;

public class PathStorageTest extends AbstractStorageTest{

    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
    }

    @Ignore
    @Test
    public void saveOverflow() {
    }
}