package IntermediateExercises.LibraryTask;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        LibraryTest.class,
        BookTest.class,
        NewspaperTest.class,
        JournalTest.class,
        EditionTest.class,
        MemberTest.class
})

public class LibraryTestSuite {


}
