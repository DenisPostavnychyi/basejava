package test.unit;

import main.storage.ListStorage;
import org.junit.Ignore;
import org.junit.Test;

public class ListSectionStorageTest extends AbstractStorageTest {

    public ListSectionStorageTest() {
        super(new ListStorage());
    }

    @Ignore
    @Test
    public void saveOverflow(){}
}