class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        '''
        first uses sort to find the first one according to alphabetical order and compare it with the last one to find out the common
        '''
        if not strs:
            return ''
        if len(strs) == 1:
            return strs[0]
        strs.sort()
        toret = ''
        for i, j in zip(strs[0], strs[-1]):
            if i == j:
                toret += i
            else:
                break
        return toret