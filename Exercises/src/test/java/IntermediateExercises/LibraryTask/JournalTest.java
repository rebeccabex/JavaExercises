package IntermediateExercises.LibraryTask;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JournalTest {

    private Journal journal;

    @Before
    public void setup() {

        journal = new Journal(1, "Nature", "Nature publisher");
        journal.addEdition(200,14, 12, 2017, 10, 3);

    }

    @Test
    public void canCreateJournal() {

        assertEquals(1, journal.getId(), "ID should be 1");
        assertEquals("Nature", journal.getName(), "Name should be Nature");
        assertEquals("Nature publisher", journal.getPublisher(), "Publisher should be Nature publisher");

    }

    @Test
    public void canUpdateJournal() {

        journal.setName("Nature magazine");
        assertEquals("Nature magazine", journal.getName());
        journal.setPublisher("Nature magazine publisher");
        assertEquals("Nature magazine publisher", journal.getPublisher());

    }

    @Test
    public void canAddEdition() {

        assertEquals(1, journal.getEditionList().size());

    }

    @Test
    public void canSearchForEdition() {

        assertEquals(journal.getEditionList().get(0), journal.findEditionByDate(14, 12, 2017));

    }

    @Test
    public void canGetFullList() {

        List<Edition> testList = new ArrayList<Edition>();
        testList.add(new Edition(200,14, 12, 2017, 10, 3));
        assertEquals(testList, journal.getEditionList());

    }

}
