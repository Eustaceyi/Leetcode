from collections import defaultdict

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        '''
        BFS solution, time and space O(MN), where M is number of words and N is length of each word
        Time Complexity: O(M×N), where M is the length of words and 
        N is the total number of words in the input word list.
        Finding out all the transformations takes MM iterations for each of the NN words. 
        Also, breadth first search in the worst case might go to each of the NN words.

        Space Complexity: O(M×N), to store all M transformations for each of the NN words, 
        in the dictionary. Visited dictionary is of N size. 
        Queue for BFS in worst case would need space for all NN words.
        '''
        if endWord not in wordList:
            return 0
        d = self.make_dict(wordList)
        queue, visited = [(beginWord,1)], set()
        while queue:
            word, step = queue.pop(0)
            if word not in visited:
                visited.add(word)
                if word == endWord:
                    return step
                for i in range(len(word)):
                    s = word[:i] + '_' + word[i+1:]
                    for w in d[s]:
                        if w not in visited:
                            queue.append((w, step+1))
        return 0
        
    def make_dict(self, wordList):
        d = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                s = word[:i] + '_' + word[i+1:]
                d[s].append(word)
        return d