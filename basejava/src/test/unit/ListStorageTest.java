package test.unit;

import main.storage.ListStorage;
import org.junit.Ignore;
import org.junit.Test;

public class ListStorageTest extends AbstractStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Ignore
    @Test
    public void saveOverflow(){}
}