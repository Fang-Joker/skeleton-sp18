package synthesizer;
//import edu.princeton.cs.algs4.In;

import java.util.Iterator;

//do: Make sure to make this class and all of its methods public
//DO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // DO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        this.rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // DO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (this.isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        this.rb[last] = x;
        this.fillCount++;
        if (this.last == this.capacity - 1) {
            this.last = 0;
        } else {
            this.last++;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // DO: Dequeue the first item. Don't forget to decrease fillCount and update
        T tmp;
        if (this.isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        tmp = this.rb[this.first];
        this.fillCount--;
        if (this.first == this.capacity - 1) {
            this.first = 0;
        } else {
            this.first++;
        }
        return tmp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // DO: Return the first item. None of your instance variables should change.
        if (this.isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return this.rb[this.first];
    }

    // DO: When you get to part 5, implement the needed code to support iteration.

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {

        private int wizPos; // track the position as a index in the array rb

        public ArrayRingBufferIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < capacity;
        }

        @Override
        public T next() {
            T returnItem = rb[wizPos];
            wizPos++;
            return returnItem;
        }
    }

//    public static void main(String[] args) {
//        ArrayRingBuffer<Integer> buffer = new ArrayRingBuffer<>(10);
//        int i = 0;
//        while (!buffer.isFull()) {
//            buffer.enqueue(i);
//            i++;
//        }
//
//        Iterator<Integer> iter = buffer.iterator();
//
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//    }
}
