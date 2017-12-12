import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackjackTest {

    Blackjack blackjack = new Blackjack();

    @Test
    public void testCompareHands() {
        assertEquals(21, blackjack.compareHands(18,21));
        assertEquals(20, blackjack.compareHands(20,18));
        assertEquals(20, blackjack.compareHands(20,22));
        assertEquals(18, blackjack.compareHands(22,18));
        assertEquals(0, blackjack.compareHands(22,22));
    }

}
