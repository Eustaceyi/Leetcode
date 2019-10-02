class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        sizes = [0] * 11
        for word in words:
            sizes[self.buildsheet(word)] += 1
        res = []
        for q in queries:
            res.append(sum(sizes[self.buildsheet(q)+1:]))
        return res
        
    def buildsheet(self, word):
        savedchar = 'z'
        count = 0
        for c in word:
            if ord(c) < ord(savedchar):
                savedchar = c
                count = 1
            elif ord(c) == ord(savedchar):
                count += 1
        return count

class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        # 1. Capture counts of smallest characters in each word, and sort 
        # the list in ascending order.
        W = sorted([w.count(min(w)) for w in words])
        
        res = []
        for q in queries:
            # 2. Perform binary search of smallest characters in each query
            # against the sorted list from step#1.
            cnt = q.count(min(q))
            idx = bisect.bisect(W, cnt)
            res.append(len(words) - idx)
        return res