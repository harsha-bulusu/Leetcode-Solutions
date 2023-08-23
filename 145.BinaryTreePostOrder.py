# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postOrder(self, root, nodes):
        if root == None:
            return
        self.postOrder(root.left, nodes)
        self.postOrder(root.right, nodes)
        nodes.append(root.val)
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        nodes = []
        self.postOrder(root, nodes)
        return nodes
