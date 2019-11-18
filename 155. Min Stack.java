class MinStack {
    private Deque<Integer> minStack;
    private Deque<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
        } else {
            stack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */