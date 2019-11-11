class MyQueue {
    private Deque<Integer> forPush;
    private Deque<Integer> forPop;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        forPush = new ArrayDeque<>();
        forPop = new ArrayDeque<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        forPush.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (forPop.isEmpty()) {
            while (!forPush.isEmpty()) {
                forPop.push(forPush.pop());
            }
        }
        return forPop.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (forPop.isEmpty()) {
            while (!forPush.isEmpty()) {
                forPop.push(forPush.pop());
            }
        }
        return forPop.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return forPush.isEmpty() && forPop.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */