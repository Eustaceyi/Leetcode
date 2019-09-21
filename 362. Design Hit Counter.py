class HitCounter:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q = [(0,0) for _ in range(300)]

    def hit(self, timestamp: int) -> None:
        """
        Record a hit.
        @param timestamp - The current timestamp (in seconds granularity).
        """
        index = timestamp % 300
        time, hit = self.q[index]
        if timestamp != time:
            self.q[index] = (timestamp, 1)
        else:
            self.q[index] = (time, hit+1)

    def getHits(self, timestamp: int) -> int:
        """
        Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity).
        """
        count = 0
        for t, hit in self.q:
            if t > timestamp-300:
                count += hit
        return count


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)