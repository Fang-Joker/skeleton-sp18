public class ArrayDequeTest {
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
    }
}
