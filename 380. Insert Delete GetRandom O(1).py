class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dic = {}
        self.arr = []

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val not in self.dic:
            self.dic[val] = len(self.arr)
            self.arr.append(val)
            return True
        else:
            return False

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.dic:
            return False
        else:
            self.dic[self.arr[-1]] = self.dic[val]
            self.arr[self.dic[val]] = self.arr[-1]
            self.dic.pop(val)
            self.arr.pop()
            return True
        

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return self.arr[random.randrange(len(self.arr))]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()