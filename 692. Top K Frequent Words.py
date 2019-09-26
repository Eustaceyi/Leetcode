class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        '''
        O(nlogn) Time O(n) Space sorting solution
        '''
        dic = {}
        for word in words:
            dic[word] = dic.get(word, 0) - 1
        return sorted(dic, key = lambda x: (dic.get(x), x))[:k]

class Ele:
    def __init__(self, count, word):
        self.count = count
        self.word = word
        
    def __lt__(self, other):
        if self.count == other.count:
            return self.word > other.word
        return self.count < other.count

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        '''
        O(nlogk) Time, O(n) Space heap solution
        '''
        dic = {}
        for word in words:
            dic[word] = dic.get(word, 0) + 1
        heap = []
        for w in dic:
            if len(heap) < k:
                heapq.heappush(heap, Ele(dic[w], w))
            else:
                heapq.heappushpop(heap, Ele(dic[w], w))
        return [heapq.heappop(heap).word for i in range(k)][::-1]