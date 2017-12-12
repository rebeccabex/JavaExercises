import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntermediateExercisesTest {

    IntermediateExercises intermediateExercises = new IntermediateExercises();


    @Test
    public void testBlackjackEx() {
        assertEquals(21, intermediateExercises.blackjackEx(18,21));
        assertEquals(20, intermediateExercises.blackjackEx(20,18));
        assertEquals(20, intermediateExercises.blackjackEx(20,22));
        assertEquals(18, intermediateExercises.blackjackEx(22,18));
        assertEquals(0, intermediateExercises.blackjackEx(22,22));
    }

    @Test
    public void testUniqueSumEx() {
        assertEquals(6, intermediateExercises.uniqueSumEx(1,2, 3));
        assertEquals(0, intermediateExercises.uniqueSumEx(3,3, 3));
        assertEquals(1, intermediateExercises.uniqueSumEx(1,3, 3));
        assertEquals(2, intermediateExercises.uniqueSumEx(3,2, 3));
        assertEquals(3, intermediateExercises.uniqueSumEx(1,1, 3));
    }

    @Test
    public void testTooHot() {
        assertTrue(intermediateExercises.tooHotEx(60, false));
        assertTrue(intermediateExercises.tooHotEx(60, true));
        assertTrue(intermediateExercises.tooHotEx(90, false));
        assertTrue(intermediateExercises.tooHotEx(100, true));
        assertFalse(intermediateExercises.tooHotEx(59, false));
        assertFalse(intermediateExercises.tooHotEx(59, true));
        assertFalse(intermediateExercises.tooHotEx(91, false));
        assertFalse(intermediateExercises.tooHotEx(101, true));
    }

}
