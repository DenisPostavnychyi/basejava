package test.unit;

import main.storage.ListStorage;
import org.junit.Test;

public class ListStorageTest extends AbstractStorageTest{

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Test
    public void saveOverflow() throws Exception {
        System.out.println("You need 2,147,483,648+ resumes for overflow ArrayList");
    }
}