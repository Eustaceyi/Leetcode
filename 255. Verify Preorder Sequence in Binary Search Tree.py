class Solution:
    def verifyPreorder(self, preorder: List[int]) -> bool:
        stack = [float("inf")]
        lo = float("-inf")
        for i in preorder:
            while i > stack[-1]:
                temp = stack.pop()
                lo = temp
            if lo >= i:
                return False
            stack.append(i)
        return True