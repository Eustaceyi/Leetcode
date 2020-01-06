from heapq import heappush, heappop
class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.count = 0
        self.higher = []
        self.lower = []

    def addNum(self, num: int) -> None:
        if self.count == 0:
            heappush(self.lower, -num)
            self.count+=1
        elif self.count == 1:
            if num > -1*self.lower[0]:
                heappush(self.higher, num)
                self.count+=1
            else:
                temp = -1*heappop(self.lower)
                heappush(self.higher, temp)
                heappush(self.lower, -num)
                self.count+=1
        elif self.count % 2 == 0:
            if num > self.higher[0]:
                temp = heappop(self.higher)
                heappush(self.higher, num)
                heappush(self.lower, -temp)
                self.count+=1
            else:
                heappush(self.lower, -num)
                self.count+=1
        else:
            if num < -1*self.lower[0]:
                temp = -1*heappop(self.lower)
                heappush(self.lower, -num)
                heappush(self.higher, temp)
                self.count+=1
            else:
                heappush(self.higher, num)
                self.count+=1
        

    def findMedian(self) -> float:
        if self.count % 2 == 0:
            return (-1*self.lower[0] + self.higher[0])/2
        else:
            return -1.0 * self.lower[0]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()