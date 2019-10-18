class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        '''
        Time O(NlogN + N*W)
        '''
        # build chain length map for each word
        length = {word: 1 for word in words}
        words.sort(key=len)

        for word in words[::-1]:
            for i in range(len(word)):
                removed = word[:i] + word[i+1:]
                if removed in length:
                    # compare to its own chain with this new chain
                    length[removed] = max(length[removed], length[word] + 1)

        return max(length.values())