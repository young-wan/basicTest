package other_pack;

import java.util.Arrays;

/**
 * @Author young
 * @Date 2020/7/22 14:21
 * @Desc
 **/
public class StackDemo {
    private int[] storage;
    private int capacity;
    private int count;
    private static final int FACTOR = 2;

    public StackDemo() {
        this.capacity = 8;
        this.storage = new int[this.capacity];
        this.count = 0;
    }

    public StackDemo(int initCapacity) {
        if (initCapacity < 0) {
            throw new IllegalArgumentException("illegal capacity");
        }
        this.capacity = initCapacity;
        this.storage = new int[initCapacity];
        this.count = 0;
    }

    public void push(int value) {
        if (count == capacity) {
            ensureCapacity();
        }
        storage[count++] = value;
    }

    private void ensureCapacity() {
        System.out.println("ensure capacity");
        int newCapacity = this.capacity * FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    public int poll() {
        count--;
        if (count < 0) {
            throw new IllegalArgumentException("Stack is empty.");
        }
        return storage[count];
    }

    public int peek() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty.");
        }
        return storage[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
//        StackDemo stack = new StackDemo();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.poll());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.size());
        System.out.println(3|9);
        System.out.println(3&9);
    }
}
