class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        '''
        O(MN) solution
        Could replace the index part to binary search
        Also check: https://leetcode.com/problems/shortest-way-to-form-string/discuss/330938/Accept-is-not-enough-to-get-a-hire.-Interviewee-4-follow-up
        '''
        s_c = set(source)
        t_c = set(target)
        for c in t_c:
            if c not in s_c:
                return -1
        
        count = 1
        s_copy = source[:]
        for i, c in enumerate(target):
            if c not in s_copy:
                count += 1
                s_copy = source[:]
            s_copy = s_copy[s_copy.index(c)+1:]
        return count

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        '''
        Two pointer version
        '''
        s_c = set(source)
        t_c = set(target)
        for c in t_c:
            if c not in s_c:
                return -1
        
        count = 1
        ps, pt = 0, 0
        while pt < len(target):
            while ps < len(source) and source[ps] != target[pt]:
                ps += 1
            if ps == len(source):
                count += 1
                ps = 0
            elif source[ps] == target[pt]:
                ps += 1
                pt += 1
        return count