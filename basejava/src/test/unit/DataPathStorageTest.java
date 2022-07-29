package test.unit;

import main.storage.PathStorage;
import main.storage.serializer.DataStreamSerializer;
import org.junit.Ignore;
import org.junit.Test;

public class DataPathStorageTest extends AbstractStorageTest{

    public DataPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }

    @Ignore
    @Test
    public void saveOverflow() {
    }
}