package IndividualExercises;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargeNumbersTest {

    private LargeNumbers ln;

    @Before
    public void setup() {
        ln = new LargeNumbers(false);
    }

    @Test
    public void createShortFormWithValidInput() {

        assertEquals("1 trillion 234 billion 567 million 891 thousand 111", ln.createName("1234567891111", true));
        assertEquals("1 trillion 234 billion ", ln.createName("1234000000000", true));
        assertEquals("1 thousand 234", ln.createName("1234", true));
        assertEquals("123", ln.createName("123", true));

    }

    @Test
    public void createLongFormWithValidInput() {

        assertEquals("1 billion 234 milliard 567 million 891 thousand 111", ln.createName("1234567891111", false));
        assertEquals("1 billion 234 milliard ", ln.createName("1234000000000", false));
        assertEquals("1 thousand 234", ln.createName("1234", false));
        assertEquals("123", ln.createName("123", false));

    }

    @Test
    public void numbersWithZeroes() {

        assertEquals("", ln.createName("0000", false).trim());
        assertEquals("123", ln.createName("000123", false).trim());
        assertEquals("123 thousand 456", ln.createName("000123456", false).trim());
        assertEquals("123 million 456 thousand", ln.createName("123456000", false).trim());
        assertEquals("123 milliard 456 thousand", ln.createName("123000456000", false).trim());
        assertEquals("123 milliard 045 million 607 thousand 890", ln.createName("123045607890", false).trim());

    }

    @Test
    public void invalidInput() {

        assertEquals("Not a number", ln.bothForms("b"));
        assertEquals("That number is too large. Maximum length 24 digits.", ln.bothForms("123456789012345678901234567890"));

    }

}
