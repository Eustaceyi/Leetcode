class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        ls = len(s)
        lt = len(t)
        
        if ls > lt:
            return self.isOneEditDistance(t, s)
        
        if (lt - ls) == 1:
            for i in range(ls):
                if s[i] != t[i]:
                    if s[i:] != t[i+1:]:
                        return False
                    else:
                        return True
            return True
        elif lt == ls:
            if s == t:
                return False
            for i in range(ls):
                if s[i] != t[i]:
                    if s[i+1:] != t[i+1:]:
                        return False
                    else:
                        return True 
        else:
            return False
        