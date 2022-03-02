/**
 *   The deque of linked list constructed by array data structure build-in in java.
 */

public class ArrayDeque<T> {
    /**
     *   The deque class of list, provide the ability of array data structure build-in in java.
     *   Only allowing user use the item but not see the array.
     *
     *  @param  items       The list of deque by used array.
     *  @param  size        The size of items in the deque.
     *
     *  @class  Node        Data structure of bidirectional linked list.
     *  @method addFirst    Adds a Node at the front of deque.
     * @method  addLast     Adds a Node at the last of deque.
     * @method  isEmpty     Returns if input deque is empty.
     * @method  size        Returns the size of the deque.
     * @method  removeFirst Returns and removes the front of deque.
     * @method  removeLast  Returns and removes the Last of deque.
     * @method  printDeque  Prints the all items of deque from first to last.
     * @method  get         Gets the item at the input n-th.
     */

    private T[] items;
    private int size;
    private static final int FACTOR = 2;
    private int fPointer;
    private int lPointer;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        fPointer = 0;
        lPointer = 0;
    }

    /** Creates a deep copy of other.
     * @param other The deque copied deeply
     */
    /**
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, items, 0, other.items.length);
        size = other.size();
        fPointer = other.fPointer;
        lPointer = other.lPointer;
    }
     */

    /** Resize the size of the box memory.
     * @param   x     The size changed of the deque. */
    private void resize(int x) {
        T[] a = (T[]) new Object[x];
        if (fPointer < lPointer) {
            System.arraycopy(items, fPointer, a, 0, size);
        } else {
            System.arraycopy(items, fPointer, a, 0, items.length - fPointer);
            System.arraycopy(items, 0, a, items.length - fPointer, lPointer + 1);
        }
        items = a;
        fPointer = 0;
        lPointer = size - 1;
    }

    /**
     *  Adds an item of type T to the front of the deque.
     * @param   item    Item added of type T
     */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * FACTOR);
        }
        if (size == 0) {
            items[fPointer] = item;
        } else if (fPointer == 0) {
            fPointer = items.length - 1;
            items[fPointer] = item;
        } else {
            items[--fPointer] = item;
        }
        size++;
    }

    /**
     *  Adds an item of type T to the back of the deque.
     * @param   item    Item added of type T
     */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * FACTOR);
        }
        if (size == 0) {
            items[lPointer] = item;
        } else if (lPointer == items.length - 1) {
            lPointer = 0;
            items[lPointer] = item;
        } else {
            items[++lPointer] = item;
        }
        size++;
    }

    /**
     *  Returns true if deque is empty, false otherwise.
     * @return  boolean
     */
    public boolean isEmpty() {
        boolean mark = false;
        if (size == 0) {
            mark = true;
        }
        return mark;
    }

    /**
     * Returns the number of items in the deque.
     * @return  int
     */
    public int size() {
        return size;
    }

    /**
     * Removes and returns the items at the front of the deque.
     * If no such item exists, return null.
     * @return T
     */
    public T removeFirst() {
        if (size == items.length / FACTOR && items.length > 8) {
            resize(items.length / FACTOR);
        }
        T removed;
        if (size == 0) {
            removed = null;
        } else {
            removed = items[fPointer];
            if (fPointer != lPointer) {
                if (fPointer == items.length - 1) {
                    fPointer = 0;
                } else {
                    fPointer++;
                }
            }
            size--;
        }

        return removed;
    }

    /**
     * Removes and returns the items at the back of the deque.
     * If no such item exists, return null.
     * @return T
     */
    public T removeLast() {
        if (size == items.length / FACTOR && items.length > 8) {
            resize(items.length / FACTOR);
        }
        T removed;
        if (size == 0) {
            removed = null;
        } else {
            removed = items[lPointer];
            if (fPointer != lPointer) {
                if (lPointer == 0) {
                    lPointer = items.length - 1;
                } else {
                    lPointer--;
                }
            }
            size--;
        }

        return removed;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1st is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * @param   index   The given index for got item
     * @return  T
     */
    public T get(int index) {
        T returned;
        if (size == 0 || index > size - 1 || index < 0) {
            returned = null;
        } else if (fPointer < lPointer) {
            returned = items[fPointer + index];
        } else {
            if (index <= items.length - fPointer - 1) {
                returned = items[fPointer + index];
            } else {
                returned = items[fPointer + index - items.length];
            }
        }
        return returned;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all in the items have been printed, print out a new line.
     */
    public void printDeque() {
        int p = fPointer;
        if (fPointer < lPointer) {
            while (p < lPointer) {
                System.out.print(get(p));
                System.out.print(' ');
                p++;
            }
            System.out.print(get(lPointer));
        } else if (fPointer > lPointer) {
            while (p < items.length) {
                System.out.print(get(p));
                System.out.print(' ');
                p++;
            }
            p = 0;
            while (p < lPointer) {
                System.out.print(get(p));
                System.out.print(' ');
                p++;
            }
            System.out.print(get(lPointer));
        }
        System.out.println();
    }

    /** Test ArrayDeque. */
    /**
    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addLast(0);
        a.addLast(1);
        a.addLast(3);
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        a.addFirst(7);
        a.addFirst(8);
        a.addFirst(9);
        a.addFirst(10);
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
    }
     */
}
