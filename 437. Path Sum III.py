# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        '''
        Brute Force.
        Time O(nlogn) best O(n^2) worse
        Space O(n) recursion
        '''
        if not root:
            return 0
        return self.pathSumFrom(root, sum) + self.pathSum(root.left, sum) + self.pathSum(root.right, sum)
    
    def pathSumFrom(self, root, sum):
        if not root:
            return 0
        this = 1 if root.val == sum else 0
        return this + self.pathSumFrom(root.left, sum-root.val)\
                  + self.pathSumFrom(root.right, sum-root.val)

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        '''
        Cache previous path,
        helper tries to find the sum that already has also remember to remove
        branch if you move to another branch
        Time O(n)
        Space O(n)
        '''
        self.cache = {0:1}
        self.res = 0
        self.helper(sum, root, 0)
        return self.res
        
    def helper(self, sum, root, curr_sum):
        if not root:
            return 
        curr_sum += root.val
        self.res += self.cache.get(curr_sum-sum, 0)
        self.cache[curr_sum] = self.cache.get(curr_sum, 0) + 1
        self.helper(sum, root.left, curr_sum)
        self.helper(sum, root.right, curr_sum)
        self.cache[curr_sum] -= 1