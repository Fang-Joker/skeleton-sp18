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
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, items, 0, other.items.length);
        size = other.size();
        fPointer = other.fPointer;
        lPointer = other.lPointer;
    }

    /** Resize the size of the box memory.
     * @param   x     The size changed of the deque. */
    public void resize(int x) {
        T[] a = (T[]) new Object[x];
        if (fPointer < lPointer) {
            System.arraycopy(items, fPointer, a, 0, size);
        } else {
            System.arraycopy(items, fPointer, a, 0, size - fPointer);
            System.arraycopy(items, 0, a, size - fPointer, lPointer + 1);
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
        } else if (fPointer == items.length - 1) {
            fPointer = 0;
            items[fPointer] = item;
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
        T removed = items[fPointer];
        if (size == 0) {
            removed = null;
        } else {
            if (fPointer == items.length - 1) {
                fPointer = 0;
            } else {
                fPointer++;
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
        T removed = items[lPointer];
        if (size == 0) {
            removed = null;
        } else {
            if (lPointer == 0) {
                lPointer = items.length - 1;
            } else {
                lPointer--;
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

    /** Test ArrayDeque. */
    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        System.out.println(a.isEmpty());
        System.out.println(a.size());
        for (int i = 0; i < 10; i ++) {
            a.addLast(i);
        }
        for (int i = 0; i < 10; i ++) {
            a.addFirst(i);
        }
        for (int i = 0; i < 10; i ++) {
            a.addLast(i);
        }
        System.out.println(a.isEmpty());
        System.out.println(a.size());
        for (int i = 0; i < 10; i ++) {
            a.removeLast();
        }
        ArrayDeque<Integer> b = new ArrayDeque<>(a);
        System.out.println(b.get(0));
        System.out.println(b.get(3));
        System.out.println(b.get(4));
        System.out.println(b.get(-1));
        System.out.println(b.get(20));
    }
}
