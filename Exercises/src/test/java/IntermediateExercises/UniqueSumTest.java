package IntermediateExercises;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UniqueSumTest {

    UniqueSum uniqueSum = new UniqueSum();

    @Test
    public void testCalculateUniqueSum() {
        assertEquals(6, uniqueSum.calculateUniqueSum(1,2, 3));
        assertEquals(0, uniqueSum.calculateUniqueSum(3,3, 3));
        assertEquals(1, uniqueSum.calculateUniqueSum(1,3, 3));
        assertEquals(2, uniqueSum.calculateUniqueSum(3,2, 3));
        assertEquals(3, uniqueSum.calculateUniqueSum(1,1, 3));
    }

}
