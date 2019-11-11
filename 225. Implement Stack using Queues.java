/**
 * push O(1)
 * pop O(n)
 * peek O(n)
 */
class MyStack {
    private Deque<Integer> q1;
    private Deque<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int temp = q1.poll();
        Deque<Integer> t = q2;
        q2 = q1;
        q1 = t;
        return temp;
    }
    
    /** Get the top element. */
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int temp = q1.poll();
        q2.offer(temp);
        Deque<Integer> t = q2;
        q2 = q1;
        q1 = t;
        return temp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
/**
 * push O(n)
 * pop O(1)
 * peek O(1)
 */
class MyStack {
    private Deque<Integer> q1;
    private Deque<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Deque<Integer> t = q2;
        q2 = q1;
        q1 = t;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */