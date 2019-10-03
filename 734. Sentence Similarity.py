class Solution:
    def areSentencesSimilar(self, words1: List[str], words2: List[str], pairs: List[List[str]]) -> bool:
        if len(words1) != len(words2):
            return False
        pairset = set([tuple(i) for i in pairs])
        
        return all(w1 == w2 or (w1, w2) in pairset or (w2, w1) in pairset for w1, w2 in zip(words1, words2))

class Solution:
    def areSentencesSimilar(self, words1: List[str], words2: List[str], pairs: List[List[str]]) -> bool:
        if len(words1) != len(words2):
            return False
        dic = collections.defaultdict(set)
        for k, v in pairs:
            dic[k].add(v)
        
        for w1, w2 in zip(words1, words2):
            if w1 == w2:
                continue
            if w1 not in dic[w2] and w2 not in dic[w1]:
                return False
        return True