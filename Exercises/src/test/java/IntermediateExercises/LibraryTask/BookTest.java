package IntermediateExercises.LibraryTask;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {

    private Book book;
    private Book book2;

    @Before
    public void setup() {
        book = new Book(1, "The Lord of the Rings", 1954, "JRR Tolkein");
        book2 = new Book(2, "The Hunger Games", 2010, "Suzanne Collins");
    }

    @Test
    public void canCreateBook() {

        assertEquals(1, book.getId());
        assertEquals("The Lord of the Rings", book.getName());
        assertEquals(1954, book.getYearPublished());
        assertEquals("JRR Tolkein", book.getAuthor());

    }

    @Test
    public void canUpdateBook() {

        book.update("name","Harry Potter");
        assertEquals("Harry Potter", book.getName());
        book.update("year published","1997");
        assertEquals(1997, book.getYearPublished());
        book.update("author","JK Rowling");
        assertEquals("JK Rowling", book.getAuthor());

    }

    @Test
    public void canCheckAvailability() {

        assertTrue(book.isAvailable());
        book2.borrowItem(18);
        assertFalse(book2.isAvailable());

    }

    @Test
    public void canModifyLoanLength() {

        assertEquals(21, book.getLoanLength());
        book.setLoanLength(14);
        assertEquals(14, book.getLoanLength());

    }

}
