# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):
        self.balanced = True


    def check(self, root):
        if root == None:
            return 0
        
        lh = self.check(root.left)
        rh = self.check(root.right)

        if abs(lh - rh) > 1:
            self.balanced = False

        return max(lh, rh) + 1

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.check(root)
        return self.balanced
