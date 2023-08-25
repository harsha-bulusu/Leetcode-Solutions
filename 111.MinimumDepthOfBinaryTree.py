# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        
        ld = self.minDepth(root.left)
        rd = self.minDepth(root.right)

        if ld == 0:
            return rd + 1

        if rd == 0:
            return ld + 1

        return min(ld, rd) + 1
