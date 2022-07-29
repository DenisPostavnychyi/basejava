package test.unit;

import main.storage.PathStorage;
import main.storage.serializer.XmlStreamSerializer;
import org.junit.Ignore;
import org.junit.Test;

public class XmlPathStorageTest extends AbstractStorageTest {

    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }

    @Ignore
    @Test
    public void saveOverflow() {
    }
}
