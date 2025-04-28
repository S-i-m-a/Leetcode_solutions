import java.util.Deque;
import java.util.ArrayDeque;

class MyQueue {
    private Deque<Integer> input;
    private Deque<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shiftStacks();
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        shiftStacks();
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    /** Helper function to transfer elements from input to output stack */
    private void shiftStacks() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}
