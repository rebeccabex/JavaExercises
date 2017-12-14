package IntermediateExercises.LibraryTask;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberTest {

    private Member member;

    @Before
    public void setup() {

        member = new Member(1, "John Smith", "123 Fake Street");

    }

    @Test
    public void canCreateMember() {

        ArrayList<Resource> emtpyList = new ArrayList<>();

        assertEquals(1, member.getId());
        assertEquals("John Smith", member.getName());
        assertEquals("123 Fake Street", member.getHomeAddress());
        assertEquals(emtpyList, member.getResourcesBorrowing());

    }

    @Test
    public void canUpdateMember() {

        member.setName("Jane Smith");
        assertEquals("Jane Smith", member.getName());
        member.setHomeAddress("321 New Street");
        assertEquals("321 New Street", member.getHomeAddress());

    }

}
