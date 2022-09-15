package exercise.git.栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * add    addLast
 * push   addFirst
 * offer  addLast
 * pop    removeFirst
 * poll   pollFirst
 * remove removeFirst
 * peek   peekFirst
 *
 */
public class LinkedList和ArrayDequeue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.push(4);
        System.out.println(stack.pop());
        stack.addFirst(0);
        stack.addLast(4);
        System.out.println(stack.getFirst());
        stack.offer(100);
        stack.offer(101);
        System.out.println(stack.poll());
        stack.pollLast();
        stack.peek();
        stack.peekFirst();
        stack.peekLast();
        stack.remove();
    }
}
