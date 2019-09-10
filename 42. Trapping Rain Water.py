class Solution:
    def trap_dp(self, height: List[int]) -> int:
        '''
        DP solution, calculate max height from left to right and from right to left,
        and water trapped must be min of the two bounded minus its height, time O(n) space O(n)
        '''
        if not height:
            return 0
        ltor = [0] * len(height)
        rtol = [0] * len(height)
        ltor[0] = height[0]
        for i in range(1, len(height)):
            ltor[i] = max(ltor[i-1], height[i])
        rtol[-1] = height[-1]
        for i in range(len(height)-2, -1, -1):
            rtol[i] = max(rtol[i+1], height[i])
        water = 0
        for i in range(len(height)):
            water += min(ltor[i], rtol[i]) - height[i]
        return water

    def trap_two_pointer(self, height: List[int]) -> int:
        '''
        make two pointer stand for maxheight from left to right and from right to left,
        if rtol is smaller, then when ltor is the same position, it must larger than rtol since it is already larger before that postion
        the same is for the other side
        time O(n), space O(1)
        '''
        if not height:
            return 0
        l, r = 0, len(height)-1
        ltor, rtol = 0, 0
        water = 0
        while l < r:
            ltor = max(ltor, height[l])
            rtol = max(rtol, height[r])
            if ltor > rtol:
                water += rtol - height[r]
                r -= 1
            else:
                water += ltor - height[l]
                l += 1
        return water