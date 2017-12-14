package IntermediateExercises.LibraryTask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditionTest {

    private Edition edition;
    private Edition issueEdition;

    @Before
    public void setup() {

        edition = new Edition(200, 1, 12, 2017);
        issueEdition = new Edition(200, 1, 12, 2017, 10, 3);

    }

    @Test
    public void canCreateDailyEdition() {

        assertEquals(200, edition.getId(), "ID should be 200");
        assertEquals(1, edition.getDate(), "Date should be 1");
        assertEquals(12, edition.getMonth(), "Month should be 1");
        assertEquals(2017, edition.getYear(), "Year should be 1");

    }

    @Test
    public void canCreateIssueEdition() {

        assertEquals(200, edition.getId(), "ID should be 200");
        assertEquals(1, issueEdition.getDate(), "Date should be 1");
        assertEquals(12, issueEdition.getMonth(), "Month should be 1");
        assertEquals(2017, issueEdition.getYear(), "Year should be 1");
        assertEquals(10, issueEdition.getVolume(), "Volume should be 10");
        assertEquals(3, issueEdition.getIssue(), "Issue should be 3");

    }

}
