package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer(10);
        assertEquals(10, arb.capacity());
        // arb.dequeue();
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i * 1.1);
        }
        assertEquals(10, arb.fillCount());
        for (int i = 0; i < 10; i++) {
            System.out.println(arb.dequeue());
            arb.enqueue(Math.random() - 0.5);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        // jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
        System.out.println((int)Math.round(12.12));
    }
} 
