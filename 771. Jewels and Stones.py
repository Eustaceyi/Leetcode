class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        j = set(J)
        count = 0
        for s in S:
            if s in j:
                count+=1
        return count