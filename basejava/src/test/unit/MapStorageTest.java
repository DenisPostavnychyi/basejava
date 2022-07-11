package test.unit;

import main.storage.MapStorage;
import org.junit.Ignore;
import org.junit.Test;

public class MapStorageTest extends AbstractStorageTest{

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Ignore
    @Test
    public void saveOverflow(){}
}
