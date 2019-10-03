class Solution:
    def areSentencesSimilarTwo(self, words1: List[str], words2: List[str], pairs: List[List[str]]) -> bool:
        '''
        DFS solution
        Time O(NP) N is len of words1 and words2, P is len of pairs, where for each in N could search the entire graph
        Sapce O(P)
        '''
        if len(words1) != len(words2):
            return False
        graph = collections.defaultdict(list)
        for m, n in pairs:
            graph[m].append(n)
            graph[n].append(m)
            
        for w1, w2 in zip(words1, words2):
            if w1 == w2:
                continue
            stack = [w1]
            seen = {w1}
            while stack:
                w = stack.pop()
                if w == w2:
                    break
                for nei in graph[w]:
                    if nei not in seen:
                        stack.append(nei)
                        seen.add(nei)
            else:
                return False
        return True

'''
This question also has a Union Find Solution, add it later with other union find question
'''