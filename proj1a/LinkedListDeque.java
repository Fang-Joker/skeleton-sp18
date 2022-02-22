/**
 *   The deque of linked list constructed by linked list.
 */
public class LinkedListDeque<T> {
    /**
     *   The deque class of linked list, provide the ability of bidirectional linked list.
     *   Only allowing user use the item but not see the pointer.
     *
     *  @param  sentinel    The sentinel node represent mark Node, the real first is sentinel.next.
     *  @param  size        The size of Node in the deque.
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

    private Node sentinel;
    private int size = 0;

    public class Node {
        public Node prev;
        public T item;
        public Node next;
        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /**  Instantiate the (class)LinkedListDeque without parameter */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Instantiate the (class)LinkedListDeque with parameter item of class T.
     *  @param  item    Item input into LinkedListDeque */
    public LinkedListDeque(T item) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(sentinel, item, sentinel);
        sentinel.prev = sentinel.next;
        size ++;
    }

    /**
     *  Adds an item of type T to the front of the deque.
     * @param   item    Item added of type T
     */
    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }

    /**
     *  Adds an item of type T to the back of the deque.
     * @param   item    Item added of type T
     */
    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size ++;
    }

    /**
     *  Returns true if deque is empty, false otherwise.
     * @return  boolean
     */
    public boolean isEmpty() {
        boolean mark = false;
        if (sentinel == sentinel.next) { mark = true; }
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
        T removed = null;
        if (sentinel.next != sentinel) {
            removed = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
        }
        return removed;
    }

    /**
     * Removes and returns the items at the back of the deque.
     * If no such item exists, return null.
     * @return T
     */
    public T removeLast() {
        T removed = null;
        if (sentinel.prev != sentinel) {
            removed = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
        }
        return removed;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all in the items have been printed, print out a new line.
     */
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item);
            if (p.next != sentinel) {
                System.out.print(' ');
            }
            p = p.next;
        }
        System.out.println();
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1st is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * @param   index   The given index for got item
     * @return  T
     */
    public T get(int index) {
        Node p = sentinel.next;
        T returned = null;
        if (index >= 0 && index < size) {
            while (index != 0) {
                p = p.next;
                index --;
            }
            returned = p.item;
        }
        return returned;
    }

    /**  Test (class)LinkedListDeque */
    public static void main(String[] args) {
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        LinkedListDeque<Integer> m = new LinkedListDeque<>(10);
        System.out.println("Is Deque l is empty? -->" + l.isEmpty());
        System.out.println("Is Deque m is empty? -->" + m.isEmpty());
        l.addFirst(10);
        l.addLast(15);
        m.addFirst(15);
        m.addLast(20);
        System.out.println("How size is Deque l? -->" + l.size());
        System.out.println("How size is Deque m? -->" + m.size());
        System.out.println("Is Deque l is empty? -->" + l.isEmpty());
        System.out.println("Is Deque m is empty? -->" + m.isEmpty());
        l.printDeque();
        m.printDeque();
        l.removeFirst();
        m.removeLast();
        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(m.get(0));
        System.out.println(m.get(1));
        System.out.println(m.get(2));
        System.out.println(m.get(3));
    }
}
