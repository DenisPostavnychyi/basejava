package test.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                AchievementAndQualificationsStorageTest.class,
                ArrayStorageTest.class,
                DataPathStorageTest.class,
                FileStorageTest.class,
                MapUuidStorageTest.class,
                MapHashCodeStorageTest.class,
                PathStorageTest.class,
                SortedArrayStorageTest.class,
                SqlStorageTest.class,
                XmlPathStorageTest.class,
        })
public class AllStorageTest {
}
