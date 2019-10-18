class Solution:
    def asteroidCollision(self, a: List[int]) -> List[int]:
        '''
        using a stack for keeping track of curr as and new as,
        note for the writing style of while / else
        '''
        stack = []
        for new in a:
            while stack and new < 0 < stack[-1]:
                if stack[-1] < -new:
                    stack.pop()
                    continue
                elif stack[-1] == -new:
                    stack.pop()
                break
            else:
                stack.append(new)
        return stack