import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('Z', 'Y'));
        assertFalse(offByOne.equalChars('A', 'A'));
        assertTrue(offByOne.equalChars('<', '='));
        assertFalse(offByOne.equalChars('<', '*'));
        assertFalse(offByOne.equalChars('a', 'k'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('0', 'z'));
    }

}
