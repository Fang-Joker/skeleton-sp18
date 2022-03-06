public class Palindrome {

    /**
     * Coverts String to Deque,like given String "abc" should be taken
     * to the Deque like a -> b -> c.
     * @param word
     * @return Deque<Character>
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /**
     * Checks if the given word is a palindrome, return true if it is, and false otherwise.
     * @param word
     * @return boolean
     */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque);
    }

    /**
     * Private helper method to help method isPalindrome that uses recursion.
     * @param word
     * @return boolean
     */
    private boolean isPalindrome(Deque word) {
        if (word.size() <= 1) {
            return true;
        }
        return (word.removeFirst() == word.removeLast()) && isPalindrome(word);
    }

    /**
     * Checks if two char is off-by-one, return ture if it is, false otherwise.
     * @param word
     * @param cc CharacterComparator
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        boolean mark = true;
        int iterNum =  wordDeque.size() / 2;
        for (int i = 0; i < iterNum; i++) {
            if (!cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())) {
                mark = false;
                break;
            }
        }
        return mark;
    }
}
