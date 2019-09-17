class TimeMap:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.d = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.d:
            self.d[key] = [(timestamp, value)]
        else:
            self.d[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.d:
            return ''
        else:
            i = bisect.bisect(self.d[key], (timestamp, chr(127)))
            return self.d[key][i-1][1] if i else ''
        


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)