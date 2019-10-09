class MovingAverage:

    def __init__(self, size: int):
        """
        Initialize your data structure here.
        """
        self.q = collections.deque()
        self.size = size
        self.window_sum = 0
        self.count = 0

    def next(self, val: int) -> float:
        if self.count < self.size:
            self.q.append(val)
            self.window_sum += val
            self.count += 1
        else:
            toremove = self.q.popleft()
            self.q.append(val)
            self.window_sum += val - toremove
        return sum(self.q) / self.count


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)