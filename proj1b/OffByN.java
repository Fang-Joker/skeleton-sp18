public class OffByN implements CharacterComparator {

    static private int n;

    /**
     * Initiate the class to set the num to off-by for two char.
     * For example, 'a' and 'c' are off-by-2 when n equals 2.
     * @param N
     */
    public OffByN(int N) {
        n = N;
    }

    /**
     * Checks if two char is off-by-n, return ture if it is, false otherwise.
     * @param char1
     * @param char2
     * @return boolean
     */
    @Override
    public boolean equalChars(char char1, char char2) {
        return ((char1 - char2) == n) || ((char1 - char2) == -n);
    }
}
