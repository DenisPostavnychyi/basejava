package test.unit;

import main.storage.ListStorage;
import org.junit.Ignore;
import org.junit.Test;

public class AchievementAndQualificationsStorageTest extends AbstractStorageTest {

    public AchievementAndQualificationsStorageTest() {
        super(new ListStorage());
    }

    @Ignore
    @Test
    public void saveOverflow(){}
}