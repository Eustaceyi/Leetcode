class Solution:
    def maxArea(self, height: List[int]) -> int:
        '''
        This uses two pointer method, and each time moves the smaller one closer to the other.
        '''
        max_area = 0
        lp, rp = 0, len(height) - 1
        while lp < rp:
            area = (rp - lp) * min(height[lp], height[rp])
            if area > max_area:
                max_area = area
            if height[lp] > height[rp]:
                rp -= 1
            else:
                lp += 1
        return max_area