public class OffByOne implements CharacterComparator {

    /**
     * Checks if two char is off-by-one, return ture if it is, false otherwise.
     * @param char1
     * @param char2
     * @return boolean
     */
    @Override
    public boolean equalChars(char char1, char char2) {
        return ((char1 - char2) == 1) || ((char1 - char2) == -1);
    }

}
