package IntermediateExercises.LibraryTask;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewspaperTest {

    private Newspaper newspaper;

    @Before
    public void setup() {

        newspaper = new Newspaper(1, "Independent",  "John Smith");
        newspaper.addEdition(200,14, 12, 2017);

    }

    @Test
    public void canCreateNewspaper() {

        assertEquals(1, newspaper.getId(), "ID should be 1");
        assertEquals("Independent", newspaper.getName(), "Name should be Independent");
        assertEquals("John Smith", newspaper.getEditor(), "Editor should be John Smith");

    }

    @Test
    public void canUpdateNewspaper() {

        newspaper.update("name","The Independent");
        assertEquals("The Independent", newspaper.getName());
        newspaper.update("editor","Jane Smith");
        assertEquals("Jane Smith", newspaper.getEditor());

    }

    @Test
    public void canAddEdition() {

        assertEquals(1, newspaper.getEditionList().size());

    }

    @Test
    public void canSearchForEdition() {

        assertEquals(newspaper.getEditionList().get(0), newspaper.findEditionByDate(14, 12, 2017));

    }

    @Test
    public void canGetFullList() {

        List<Edition> testList = new ArrayList<Edition>();
        testList.add(new Edition(200,14, 12, 2017));
        assertEquals(testList, newspaper.getEditionList());

    }

}
