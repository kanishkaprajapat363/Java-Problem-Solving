import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public Queue<Integer> reverseQueue(Queue<Integer> q) {
        // Create a new stack to hold the queue elements
        Stack<Integer> stack = new Stack<>();

        // Step 1: Transfer all elements from the queue to the stack
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }

        // Step 2: Transfer all elements back from the stack to the queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        return q;
    }
}