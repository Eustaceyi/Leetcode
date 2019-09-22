# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class Solution:
    def depthSumInverse(self, nestedList: List[NestedInteger]) -> int:
        stack = [node for node in nestedList]
        res = 0
        level = []
        while stack:
            temp = []
            next_stack = []
            for node in stack:
                if node.isInteger():
                    temp.append(node.getInteger())
                else:
                    next_stack += node.getList()
            level.append(temp)
            stack = next_stack
        for i in range(len(level)):
            res += (len(level)-i) * sum(level[i])
        return res

    def one_pass(self, nestedList):
        summ = 0
        level_sum = 0
        while nestedList:
            next_level_list = []
            for n in nestedList:
                if n.isInteger():
                    level_sum += n.getInteger()
                else:
                    for m in n.getList():
                        next_level_list.append(m)
            summ += level_sum
            nestedList = next_level_list
        return summ