class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        dic = {}
        for i, char in enumerate(S):
            dic[char] = i
        res = []
        lastpos,i,prev = 0,0,0
        for i, c in enumerate(S):
            lastpos = max(lastpos, dic[c])
            if i == lastpos:
                res.append(i-prev+1)
                prev = i+1
        return res