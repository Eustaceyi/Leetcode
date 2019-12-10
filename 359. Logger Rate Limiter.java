class Logger {
    class Node {
        int time;
        String message;
        Node(int time, String message) {
            this.time = time;
            this.message = message;
        }
    }
    Deque<Node> deque;

    /** Initialize your data structure here. */
    public Logger() {
        deque = new ArrayDeque<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!deque.isEmpty() && deque.peekFirst().time <= timestamp-10) {
            deque.pollFirst();
        }
        for (Node n : deque) {
            if (n.message.equals(message)) {
                return false;
            }
        }
        deque.offer(new Node(timestamp, message));
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */