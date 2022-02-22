import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

import java.util.Observable;

/** Array based list.
 *  @author Fang-Joker
 */

public class AList<T> {
    /** Creates an empty list. */
    private T[] list;
    private int size;
    private static final int RFACTOR = 2;
    public AList() {
        list = (T[]) new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        T[] a = (T[]) new Object[size + 1];
        System.arraycopy(list, 0, a, 0, size);
        a[size] = x;
        list = a;
        size ++;
    }

    public void insertBack(T x) {
        if (size == list.length) {
            resize(size * RFACTOR);
        }
        list[size] = x;
        size ++;
    }

    /** Resize the size of the box memory. */
    public void resize(int x) {
        T[] a = (T[]) new Object[x];
        System.arraycopy(list, 0, a , 0, size);
        list = a;
    }
    /** Returns the item from the back of the list. */
    public T getLast() {
        return list[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return list[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        if (size < 0.25 * list.length && list.length > 100) {
            resize( list.length / 2);
        }
        T x = list[size - 1];
        size --;
        return x;
    }

    public static void main(String[] args) {
        AList a = new AList<Integer>();
        a.insertBack(1);
        a.insertBack(2);
        a.insertBack(3);
        System.out.println(a.getLast());
        System.out.println(a.get(1));
        System.out.println(a.size());
        System.out.println(a.removeLast());
        System.out.println(a.removeLast());
    }
}
