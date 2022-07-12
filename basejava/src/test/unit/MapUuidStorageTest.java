package test.unit;

import main.storage.MapUuidStorage;
import org.junit.Ignore;
import org.junit.Test;

public class MapUuidStorageTest extends AbstractStorageTest{

    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }

    @Ignore
    @Test
    public void saveOverflow(){}
}
