package IntermediateExercises.LibraryTask;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void setup() {
        book = new Book(1, "The Lord of the Rings", 1954, "JRR Tolkein");
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

        book.setName("Harry Potter");
        assertEquals("Harry Potter", book.getName());
        book.setYearPublished(1997);
        assertEquals(1997, book.getYearPublished());
        book.setAuthor("JK Rowling");
        assertEquals("JK Rowling", book.getAuthor());

    }

}
