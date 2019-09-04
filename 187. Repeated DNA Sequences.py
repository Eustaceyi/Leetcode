class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        '''
        check if current string in seen and then put in result 
        '''
        seen = set()
        ret = set()
        for i in range(len(s)-9):
            if s[i:i+10] in seen:
                ret.add(s[i:i+10])
            else:
                seen.add(s[i:i+10])
        return ret