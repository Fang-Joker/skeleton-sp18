import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /**
     * You must use this palindrome, and not instantiate
     * new Palindromes, or the autograder might be upset.
     */

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String[] isPalindrome = new String[]{"", "a", "noon", "racecar"};
        String[] noPalindrome = new String[]{"no", "car", "nack", "there"};

        for (int i = 0; i < isPalindrome.length; i++) {
            assertTrue(palindrome.isPalindrome(isPalindrome[i]));
        }
        for (int i = 0; i < noPalindrome.length; i++) {
            assertFalse(palindrome.isPalindrome(noPalindrome[i]));
        }

        String[] isOffByOnePalindrome = new String[]{"", "a", "ab", "acfdb"};
        String[] noOffByOnePalindrome = new String[]{"np", "car", "nack", "there"};
        OffByOne offByOne = new OffByOne();
        for (int i = 0; i < isOffByOnePalindrome.length; i++) {
            assertTrue(palindrome.isPalindrome(isOffByOnePalindrome[i], offByOne));
        }
        for (int i = 0; i < noOffByOnePalindrome.length; i++) {
            assertFalse(palindrome.isPalindrome(noOffByOnePalindrome[i], offByOne));
        }

        String[] isOffBy2Palindrome = new String[]{"", "a", "ac", "acfec"};
        String[] noOffBy2Palindrome = new String[]{"no", "car", "nabk", "there"};
        OffByN offBy2 = new OffByN(2);
        for (int i = 0; i < isOffBy2Palindrome.length; i++) {
            assertTrue(palindrome.isPalindrome(isOffBy2Palindrome[i], offBy2));
        }
        for (int i = 0; i < noOffByOnePalindrome.length; i++) {
            assertFalse(palindrome.isPalindrome(noOffBy2Palindrome[i], offBy2));
        }
    }
}
