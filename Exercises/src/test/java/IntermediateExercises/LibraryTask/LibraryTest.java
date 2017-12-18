package IntermediateExercises.LibraryTask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

        library.addMember(member);
        library.addResource(book);
        library.addResource(newspaper);
        library.addResource(journal);

    }

    @Test
    public void canAddResource() {

        library = new Library();

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

        assertEquals(1, library.getMemberCount());

    }

    @Test
    public void canUpdateBook() {

        library.updateResource(book, "name", "The Two Towers");
        assertEquals("The Two Towers", library.findResourceById(1).getName());

        library.updateResource(book, "author", "J Tolkein");
        assertEquals("J Tolkein", ((Book) library.findResourceById(1)).getAuthor());

        library.updateResource(book, "year published", "1955");
        assertEquals(1955, ((Book) library.findResourceById(1)).getYearPublished());

    }

    @Test
    public void canUpdateNewspaper() {

        library.updateResource(newspaper, "name", "The Independent");
        assertEquals("The Independent", library.findResourceById(2).getName());

        library.updateResource(newspaper, "editor", "Jane Smith");
        assertEquals("Jane Smith", ((Newspaper) library.findResourceById(2)).getEditor());

    }

    @Test
    public void canUpdateJournal() {

        library.updateResource(journal, "name", "Nature magazine");
        assertEquals("Nature magazine", library.findResourceById(3).getName());

        library.updateResource(journal, "publisher", "Nature magazine publisher");
        assertEquals("Nature magazine publisher", ((Journal) library.findResourceById(3)).getPublisher());

    }

    @Test
    public void canUpdateMember() {

        library.updateMember(member,"name", "John Smith");
        assertEquals("John Smith", member.getName());

        library.updateMember(member,"address", "456 New Road");
        assertEquals("456 New Road", member.getHomeAddress());

    }

    @Test
    public void canBorrowResource() {

        assertEquals(39, library.borrowResource(member, book));
        assertEquals(1, member.getItemsBorrowing().size());
        assertFalse(book.isAvailable());

    }

    @Test
    public void canReturnResource() {

        library.borrowResource(member, book);
        library.returnResource(member, book);
        assertEquals(0, member.getItemsBorrowing().size());
        assertTrue(book.isAvailable());

    }

    @Test
    public void canDeleteResource() {

        library.deleteResource(book);
        assertEquals(0, library.getTypeOfResourceCount("book"), "Should be 0 books");
        assertEquals(2, library.getResourceCount(),"Should be 2 resources");

        library.deleteResource(newspaper);
        assertEquals(0, library.getTypeOfResourceCount("newspaper"),"Should be 0 newspapers");
        assertEquals(1, library.getResourceCount(),"Should be 1 resource");

        library.deleteResource(journal);
        assertEquals(0, library.getTypeOfResourceCount("journal"),"Should be 0 journals");
        assertEquals(0, library.getResourceCount(),"Should be 0 resources");

    }

    @Test
    public void canDeleteMember() {

        library.deleteMember(member);
        assertEquals(0, library.getMemberCount(), "Should be 0 members");

    }

    @Test
    public void canAddPeriodicalEdition() {

        library.addNewPeriodicalEdition(newspaper, 18,12,2017);
        assertEquals(1, newspaper.getEditionList().size());

        library.addNewPeriodicalEdition(journal, 18,12,2017, 117, 4);
        assertEquals(1, journal.getEditionList().size());

    }

    @Test
    public void canGetBorrowableList() {

        Book book2 = new Book(2, "The Hunger Games", 2010, "Suzanne Collins");
        library.addResource(book2);
        assertEquals(2, library.getBorrowableResources().size());

        library.borrowResource(member, book2);
        assertEquals(1, library.getBorrowableResources().size());

    }

    @Test
    public void canGetAvailableList() {



    }
}
