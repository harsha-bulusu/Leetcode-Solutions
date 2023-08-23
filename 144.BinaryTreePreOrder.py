# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def preOrder(self, root, nodes):
        if root == None:
            return 
        nodes.append(root.val)
        self.preOrder(root.left, nodes)
        self.preOrder(root.right, nodes)


    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        nodes = []
        self.preOrder(root, nodes)
        return nodes
