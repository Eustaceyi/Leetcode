class MovingAverage {
    private int size;
    private int currsize;
    private int sum;
    private Deque<Integer> cache;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        currsize = 0;
        sum = 0;
        cache = new ArrayDeque<>(size);
    }
    
    public double next(int val) {
        if (currsize == size) {
            sum -= cache.poll();
            sum += val;
            cache.offer(val);
        } else {
            sum += val;
            cache.offer(val);
            currsize++;
        }
        return (double) sum / (double) currsize;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */