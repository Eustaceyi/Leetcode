class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minprice = 2**31 - 1
        maxprofit = 0
        for i in prices:
            minprice = min(minprice, i)
            curr = i - minprice
            maxprofit = max(maxprofit, curr)
        return maxprofit