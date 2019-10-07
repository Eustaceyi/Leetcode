class Solution:

    def __init__(self, nums: List[int]):
        self.store = nums[:]
        

    def reset(self) -> List[int]:
        """
        Resets the array to its original configuration and return it.
        """
        return self.store

    def shuffle(self) -> List[int]:
        """
        Returns a random shuffling of the array.
        """
        shuffle = self.store[:]
        l = len(self.store)
        for i in range(l):
            r = random.randrange(i, l)
            shuffle[i], shuffle[r] = shuffle[r], shuffle[i]
        return shuffle


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()