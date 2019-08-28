"""
# Definition for a Node.
class Node:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
"""
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        '''
        DFS solution with stack
        '''
        if not node:
            return None
        newnode = Node(node.val, [])
        stack = [node]
        dic = {node: newnode}
        while stack:
            temp = stack.pop(-1)
            for n in temp.neighbors:
                if n not in dic:
                    dic[n] = Node(n.val, [])
                    dic[temp].neighbors.append(dic[n])
                    stack.append(n)
                else:
                    dic[temp].neighbors.append(dic[n])
        return newnode


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        '''
        BFS solution with queue
        '''
        if not node:
            return None
        newnode = Node(node.val, [])
        queue = [node]
        dic = {node: newnode}
        while queue:
            temp = queue.pop(0)
            for n in temp.neighbors:
                if n not in dic:
                    dic[n] = Node(n.val, [])
                    dic[temp].neighbors.append(dic[n])
                    queue.append(n)
                else:
                    dic[temp].neighbors.append(dic[n])
        return newnode

class Solution:
    '''
    DFS recursion
    '''
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        newnode = Node(node.val, [])
        self.dic = {node: newnode}
        self.dfs(node)
        return newnode
        
        
    def dfs(self, node):
        for n in node.neighbors:
            if n not in self.dic:
                self.dic[n] = Node(n.val, [])
                self.dic[node].neighbors.append(self.dic[n])
                self.dfs(n)
            else:
                self.dic[node].neighbors.append(self.dic[n])