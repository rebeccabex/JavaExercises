package IntermediateExercises;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemperatureCheckerTest {

    TemperatureChecker temperatureChecker = new TemperatureChecker();

    @Test
    public void testIsTempGood() {
        assertTrue(temperatureChecker.isTempGood(60, false));
        assertTrue(temperatureChecker.isTempGood(60, true));
        assertTrue(temperatureChecker.isTempGood(90, false));
        assertTrue(temperatureChecker.isTempGood(100, true));
        assertFalse(temperatureChecker.isTempGood(59, false));
        assertFalse(temperatureChecker.isTempGood(59, true));
        assertFalse(temperatureChecker.isTempGood(91, false));
        assertFalse(temperatureChecker.isTempGood(101, true));
    }

}
