# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root, target, K):
        """
        :type root: TreeNode
        :type target: TreeNode
        :type K: int
        :rtype: List[int]
        First we make the directed graph into a undirected graph,
        and then we use bfs for finding distance of K
        """
        graph = collections.defaultdict(list)
        queue = [root]
        while queue:
            node = queue.pop(0)
            if node.left:
                graph[node].append(node.left)
                graph[node.left].append(node)
                queue.append(node.left)
            if node.right:
                graph[node].append(node.right)
                graph[node.right].append(node)
                queue.append(node.right)
        
        layer = [target]
        seen = {target}
        while K > 0:
            newlayer = []
            for node in layer:
                for newnode in graph[node]:
                    if newnode not in seen:
                        newlayer.append(newnode)
                        seen.add(newnode)
            K -= 1
            layer = newlayer
        return [node.val for node in layer]