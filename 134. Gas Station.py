class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        '''
        If there is more gas than cost, there must be a route that will make the car go a round
        then we pick a start point, if there is somewhere that it cannot go to, the startint point 
        must be behind that point.
        So we can do it in one pass
        Time O(n)
        Space O(1)
        '''
        if sum(gas) < sum(cost):
            return -1
        diff = 0
        start = 0
        for i in range(len(gas)):
            diff += gas[i] - cost[i]
            if diff < 0:
                start = i+1
                diff = 0
        return start