package IntermediateExercises.LibraryTask;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;

public class LibraryTest {

    private Library library;
    private Book book;
    private Newspaper newspaper;
    private Journal journal;
    private Member member;

    @Before
    public void setup() {

        library = new Library();
        book = new Book(1, "The Lord of the Rings", 1954, "JRR Tolkein");
        newspaper = new Newspaper(2, "Independent", "John Smith");
        journal = new Journal(3, "Lancet", "Nature publisher");
        member = new Member(1, "Jane Smith", "123 FakeStreet");
    }

    @Test
    public void canAddResource() {

        library.addResource(book);
        assertEquals(1, library.getTypeOfResourceCount("book"), "Should be 1 book");
        assertEquals(1, library.getResourceCount(),"Should be 1 resource");

        library.addResource(newspaper);
        assertEquals(1, library.getTypeOfResourceCount("newspaper"),"Should be 1 newspaper");
        assertEquals(2, library.getResourceCount(),"Should be 2 resources");

        library.addResource(journal);
        assertEquals(1, library.getTypeOfResourceCount("journal"),"Should be 1 journal");
        assertEquals(3, library.getResourceCount(),"Should be 3 resources");

    }

    @Test
    public void canAddMember() {

        library.addMember(member);
        assertEquals(1, library.getMemberCount());

    }

    @Test
    public void canUpdateBook() {

        library.addResource(book);
        library.updateResource(book, "name", "The Two Towers");
        assertEquals("The Two Towers", library.findResourceById(1).getName());

        library.updateResource(book, "author", "J Tolkein");
        assertEquals("J Tolkein", ((Book) library.findResourceById(1)).getAuthor());

        library.addResource(book);
        library.updateResource(book, "year published", "1955");
        assertEquals(1955, ((Book) library.findResourceById(1)).getYearPublished());

    }

}
