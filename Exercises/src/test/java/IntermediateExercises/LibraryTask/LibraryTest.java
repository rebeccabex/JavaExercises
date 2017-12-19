package IntermediateExercises.LibraryTask;

import org.junit.Before;
import org.junit.Ignore;
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

        library.addMember("Jane Smith", "123 FakeStreet");
        library.addBook("The Lord of the Rings", 1954, "JRR Tolkein");
        library.addNewspaper("Independent", "John Smith");
        library.addJournal("Nature", "Nature publisher");

        library.addNewPeriodicalEditionById(2, 18,12,2017);
        library.addNewPeriodicalEditionById(3, 18,12,2017, 117, 4);
    }

    @Test
    public void canAddResource() {

        library = new Library();

        library.addBook("The Lord of the Rings", 1954, "JRR Tolkein");
        assertEquals(1, library.getTypeOfResourceCount("book"), "Should be 1 book");
        assertEquals(1, library.getResourceCount(),"Should be 1 resource");

        library.addNewspaper("Independent", "John Smith");
        assertEquals(1, library.getTypeOfResourceCount("newspaper"),"Should be 1 newspaper");
        assertEquals(2, library.getResourceCount(),"Should be 2 resources");

        library.addJournal("Lancet", "Nature publisher");
        assertEquals(1, library.getTypeOfResourceCount("journal"),"Should be 1 journal");
        assertEquals(3, library.getResourceCount(),"Should be 3 resources");

    }

    @Test
    public void canAddMember() {

        assertEquals(1, library.getMemberCount());

    }

    @Test
    public void canUpdateBook() {

        library.updateResourceById(1, "name", "The Two Towers");
        assertEquals("The Two Towers", library.findResourceById(1).getName());

        library.updateResourceById(1, "author", "J Tolkein");
        assertEquals("J Tolkein", ((Book) library.findResourceById(1)).getAuthor());

        library.updateResourceById(1, "year published", "1955");
        assertEquals(1955, ((Book) library.findResourceById(1)).getYearPublished());

    }

    @Test
    public void canUpdateNewspaper() {

        library.updateResourceById(2, "name", "The Independent");
        assertEquals("The Independent", library.findResourceById(2).getName());

        library.updateResourceById(2, "editor", "Jane Smith");
        assertEquals("Jane Smith", ((Newspaper) library.findResourceById(2)).getEditor());

    }

    @Test
    public void canUpdateJournal() {

        library.updateResourceById(3, "name", "Nature magazine");
        assertEquals("Nature magazine", library.findResourceById(3).getName());

        library.updateResourceById(3, "publisher", "Nature magazine publisher");
        assertEquals("Nature magazine publisher", ((Journal) library.findResourceById(3)).getPublisher());

    }

    @Test
    public void canUpdateMember() {

        library.updateMemberById(1,"name", "John Smith");
        assertEquals("John Smith", library.findMemberById(1).getName());

        library.updateMemberById(1,"address", "456 New Road");
        assertEquals("456 New Road", library.findMemberById(1).getHomeAddress());

//        library.updateMemberById(2, "name", "John Smith");
//        assertEquals("Jane Smith", member.getName());

    }

    @Test
    public void canBorrowResource() {

        assertEquals(39, library.borrowResource(member, book));
        assertEquals(1, member.getItemsBorrowing().size());
        assertFalse(book.isAvailable());

    }

    @Test
    public void canReturnResource() {

        library.borrowResourceByIds(1, 1);
        library.returnResourceByIds(1, 1);
        assertEquals(0, library.findMemberById(1).getItemsBorrowing().size());
        assertTrue(((Borrowable) library.findResourceById(1)).isAvailable());

    }

    @Test
    public void canDeleteResource() {

        library.deleteResourceById(1);
        assertEquals(0, library.getTypeOfResourceCount("book"), "Should be 0 books");
        assertEquals(2, library.getResourceCount(),"Should be 2 resources");

        library.deleteResourceById(2);
        assertEquals(0, library.getTypeOfResourceCount("newspaper"),"Should be 0 newspapers");
        assertEquals(1, library.getResourceCount(),"Should be 1 resource");

        library.deleteResourceById(3);
        assertEquals(0, library.getTypeOfResourceCount("journal"),"Should be 0 journals");
        assertEquals(0, library.getResourceCount(),"Should be 0 resources");

    }

    @Test
    public void canDeleteMember() {

        library.deleteMemberById(1);
        assertEquals(0, library.getMemberCount(), "Should be 0 members");

    }

    @Test
    public void canAddPeriodicalEdition() {

        assertEquals(1, ((Newspaper) library.findResourceById(2)).getEditionList().size());

        assertEquals(1, ((Journal) library.findResourceById(3)).getEditionList().size());

    }

    @Test
    public void canGetBorrowableList() {

        Book book2 = new Book(2, "The Hunger Games", 2010, "Suzanne Collins");
        library.addBook("The Hunger Games", 2010, "Suzanne Collins");
        assertEquals(2, library.getBorrowableResources().size());

        library.borrowResourceByIds(1, 1);
        assertEquals(1, library.getBorrowableResources().size());

    }

    @Test
    public void canGetAvailableList() {

        assertEquals(3, library.getAvailableResources().size());

        library.addBook("The Hunger Games", 2010, "Suzanne Collins");
        library.addNewspaper("The Guardian", "AN Other");
        library.addNewPeriodicalEditionById(6, 19,12,2017);

        assertEquals(5, library.getAvailableResources().size());

        library.borrowResourceByIds(1, 1);
        assertEquals(4, library.getAvailableResources().size());

    }

    @Test
    public void canSaveAvailableList() {

        assertTrue(library.saveAvailableResources("C:\\Users\\Admin\\JavaExercises\\Exercises\\LibraryAvailableList.txt"));
//        assertFalse(library.saveAvailableResources("string"));

    }

    @Test
    public void canLoadAvailableList() {

        assertTrue(library.loadAvailableResources("C:\\Users\\Admin\\JavaExercises\\Exercises\\LibraryAvailableList.txt"));
        assertFalse(library.loadAvailableResources("string"));

    }

}
