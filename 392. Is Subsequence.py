from collections import defaultdict
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        charset = set(s)
        dic = defaultdict(list)
        for i, c in enumerate(t):
            if c in charset:
                dic[c].append(i)
        prev = -1
        for c in s:
            if c not in dic:
                return False
            else:
                temp = dic[c]
                lo = 0
                hi = len(temp)
                while lo < hi:
                    mid = (hi-lo)//2+lo
                    if temp[mid] > prev:
                        hi = mid
                    else:
                        lo = mid + 1
                if lo > len(temp)-1 or temp[lo] < prev:
                    return False
                else:
                    prev = temp[lo]
            
        return True

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        ps = 0
        pt = 0
        while ps < len(s) and pt < len(t):
            if s[ps] == t[pt]:
                ps += 1
            pt += 1
        if ps < len(s):
            return False
        else:
            return True