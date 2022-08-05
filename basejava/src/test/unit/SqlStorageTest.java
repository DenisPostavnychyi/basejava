package test.unit;

import main.Config;
import org.junit.Ignore;
import org.junit.Test;

public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }

    @Ignore
    @Test
    public void saveOverflow() {
    }

    @Ignore
    @Test
    public void saveExist(){}
}