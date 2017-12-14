package IntermediateExercises.LibraryTask;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    Library library = new Library();
    Book book = new Book();
    Newspaper newspaper = new Newspaper();
    Journal journal = new Journal();
    Member member = new Member();

    @Test
    public void canAddResource() {

        library.addResource(book);
        assertEquals(1, library.getBookCount());
        assertEquals(1, library.getResourceCount());

        library.addResource(newspaper);
        assertEquals(1, library.getNewspaperCount());
        assertEquals(1, library.getResourceCount());

        library.addResource(journal);
        assertEquals(1, library.getJournalCount());
        assertEquals(1, library.getResourceCount());

    }

}
