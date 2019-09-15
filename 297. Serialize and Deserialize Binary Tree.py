# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        result = []
        queue = [root]
        while any(queue):
            result += [str(node.val) if node else 'null' for node in queue]
            temp = []
            for node in queue:
                if node:
                    temp.append(node.left)
                    temp.append(node.right)
            queue = temp
        s = '[' + ','.join(result) + ']'
        return s
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        nodelist = data[1:-1].split(',')
        if not nodelist[0]:
            return None
        while nodelist[-1] == 'null':
            nodelist.pop()
        count = 1
        root = TreeNode(int(nodelist[0]))
        ls = [root]
        while count<len(nodelist):
            temp = []
            for node in ls:
                if node:
                    node.left = TreeNode(int(nodelist[count])) if nodelist[count]!='null' else None
                    count += 1
                    if count >= len(nodelist):
                        break
                    temp.append(node.left)
                    node.right = TreeNode(int(nodelist[count])) if nodelist[count]!='null' else None
                    count += 1
                    if count >= len(nodelist):
                        break
                    temp.append(node.right)
            ls = temp
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))