from collections import Counter, defaultdict
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ''
        
        dict_t = Counter(t)
        required = len(dict_t)
        
        filtered_s = []
        for i, char in enumerate(s):
            if char in dict_t:
                filtered_s.append((char, i))
        
        l,r = 0,0
        formed = 0
        window_count = defaultdict(int)
        
        ans = 2**31-1, None, None
        
        while r < len(filtered_s):
            char = filtered_s[r][0]
            window_count[char] += 1
            
            if window_count[char] == dict_t[char]:
                formed += 1
                
            while l <= r and formed == required:
                ch = filtered_s[l][0]
                
                end = filtered_s[r][1]
                start = filtered_s[l][1]
                if end - start + 1 < ans[0]:
                    ans = (end - start + 1, start, end)
                    
                window_count[ch] -= 1
                if window_count[ch] < dict_t[ch]:
                    formed -= 1
                l += 1
            r += 1
        return '' if ans[0] == 2**31-1 else s[ans[1]:ans[2]+1]