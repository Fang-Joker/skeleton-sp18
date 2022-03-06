public interface Deque<T> {
    /**
     *   The deque class of list, provide the interface.
     *   Only allowing user use the item but not see the array.
     *
     *  @param  items       The list of deque by used array.
     *  @param  size        The size of items in the deque.
     *
     *  @method addFirst    Adds a Node at the front of deque.
     * @method  addLast     Adds a Node at the last of deque.
     * @method  isEmpty     Returns if input deque is empty.
     * @method  size        Returns the size of the deque.
     * @method  removeFirst Returns and removes the front of deque.
     * @method  removeLast  Returns and removes the Last of deque.
     * @method  printDeque  Prints the all items of deque from first to last.
     * @method  get         Gets the item at the input n-th.
     */

    /**
     *  Adds an item of type T to the front of the deque.
     * @param   item    Item added of type T
     */
    public void addFirst(T item);

    /**
     *  Adds an item of type T to the back of the deque.
     * @param   item    Item added of type T
     */
    public void addLast(T item);

    /**
     *  Returns true if deque is empty, false otherwise.
     * @return  boolean
     */
    public boolean isEmpty();

    /**
     * Returns the number of items in the deque.
     * @return  int
     */
    public int size();

    /**
     * Removes and returns the items at the front of the deque.
     * If no such item exists, return null.
     * @return T
     */
    public T removeFirst();

    /**
     * Removes and returns the items at the back of the deque.
     * If no such item exists, return null.
     * @return T
     */
    public T removeLast() ;

    /**
     * Gets the item at the given index, where 0 is the front, 1st is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * @param   index   The given index for got item
     * @return  T
     */
    public T get(int index) ;

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all in the items have been printed, print out a new line.
     */
    public void printDeque();
}
