import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        char a = 'a';
        char b = 'b';
        char c = 'a';
        assertEquals(a, a);
        assertNotEquals(a, b);
        assertEquals(a, c);
    }

}
