class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        '''
        The problem asks us to find out the two words follows a <= b
        so we need to check if all char in the two words;
        one case is if the shorter one is the same as the longer's prefix, then the shorter is smaller
        '''
        ord_index = {c:i for i,c in enumerate(order)}
        
        for i in range(len(words)-1):
            word1, word2 = words[i], words[i+1]
            for i in range(min(len(word1), len(word2))):
                if word1[i] != word2[i]:
                    if ord_index[word1[i]] > ord_index[word2[i]]:
                        return False
                    break
            else:
                if len(word1) > len(word2):
                    return False
        return True