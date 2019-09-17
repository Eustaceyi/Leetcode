class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        '''
        Intuition is we count how many to remove,
        and then use dfs to remove those need to remove
        '''
        left, right = 0,0
        for char in s:
            if char == '(':
                left = left + 1 
            elif char == ')':
                if not left:
                    right += 1
                else:
                    left -= 1
        
        ans = set()
        
        
        def recursion(idx, left_count, right_count, left_rem, right_rem, cur):
            if idx == len(s):
                if left_count == right_count and (not left_rem and not right_rem):
                    ans.add(''.join(cur))
            else:
                if s[idx] == '(':
                    if left_rem:
                        recursion(idx+1, left_count, right_count, left_rem-1, right_rem, cur)
                    recursion(idx+1, left_count+1, right_count, left_rem, right_rem, cur+[s[idx]])
                elif s[idx] == ')':
                    if right_rem:
                        recursion(idx+1, left_count, right_count, left_rem, right_rem-1, cur)
                    if right_count < left_count:
                        recursion(idx+1, left_count, right_count+1, left_rem, right_rem, cur+[s[idx]])
                else:
                    recursion(idx+1, left_count, right_count, left_rem, right_rem, cur+[s[idx]])
        
        recursion(0, 0, 0, left, right, [])
        return list(ans)