class MinStack {
    // Main stack to store the elements
    private Stack<Integer> stack;
    // Auxiliary stack to store the minimum elements
    private Stack<Integer> minStack;

    public MinStack() {
        // Initialize the stacks
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        // Push the element to the main stack
        stack.push(x);
        // Push the minimum element to the min stack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    public void pop() {
        // Pop from both stacks if the element to pop is the same as the minimum
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        // Return the top element from the main stack
        return stack.peek();
    }
    
    public int getMin() {
        // Return the minimum element from the min stack
        return minStack.peek();
    }
}
