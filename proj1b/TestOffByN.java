import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN;

    @Test
    public void testEqualChars() {
        offByN = new OffByN(2);
        assertTrue(offByN.equalChars('a', 'c'));
        assertFalse(offByN.equalChars('a', 'b'));
        assertFalse(offByN.equalChars('a', 'a'));
    }
}
