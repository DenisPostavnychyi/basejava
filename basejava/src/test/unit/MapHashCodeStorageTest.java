package test.unit;

import main.storage.MapHashCodeStorage;
import org.junit.Ignore;
import org.junit.Test;

public class MapHashCodeStorageTest extends AbstractStorageTest{

    public MapHashCodeStorageTest() {
        super(new MapHashCodeStorage());
    }

    @Ignore
    @Test
    public void saveOverflow(){}
}
