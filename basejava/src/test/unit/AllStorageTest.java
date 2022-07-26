package test.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedArrayStorageTest.class,
                AchievementAndQualificationsStorageTest.class,
                MapUuidStorageTest.class,
                MapHashCodeStorageTest.class,
        })
public class AllStorageTest {
}
