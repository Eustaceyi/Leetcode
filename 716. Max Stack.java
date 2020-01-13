class MaxStack {
    class Pair {
        int max;
        int pos;
        public Pair(int max, int pos) {
            this.max = max;
            this.pos = pos;
        }
    }
    private Deque<Integer> stack;
    private List<Pair> maxs;
    
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new ArrayDeque<>();
        maxs = new ArrayList<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            maxs.add(new Pair(x, 0));
        } else {
            int pos = stack.size();
            stack.push(x);
            if (x >= maxs.get(maxs.size()-1).max) {
                maxs.add(new Pair(x, pos));
            }
        }
    }
    
    public int pop() {
        int ans = stack.pop();
        int size = stack.size();
        if (maxs.get(maxs.size()-1).pos == size) {
            maxs.remove(maxs.size()-1);
        }
        return ans;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxs.get(maxs.size()-1).max;
    }
    
    public int popMax() {
        Pair popped = maxs.remove(maxs.size()-1);
        Deque<Integer> temp = new ArrayDeque<>();
        while (stack.size() > popped.pos+1) {
            temp.push(stack.pop());
        }
        stack.pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return popped.max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */