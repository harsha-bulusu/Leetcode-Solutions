# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):
        self.indexRef = {}

    def build(self, preorder, ilb, irb, plb, prb):
        if ilb > irb:
            return None

        root = TreeNode(preorder[plb])
        mid = self.indexRef[root.val]
        root.left = self.build(preorder, ilb, mid - 1, plb + 1, plb + 1 + (mid - 1 -ilb))
        root.right = self.build(preorder, mid + 1, irb, prb - (irb - (mid + 1)), prb)
        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for i in range(len(inorder)):
            self.indexRef[inorder[i]] = i
        
        return self.build(preorder, 0, len(inorder) - 1, 0, len(preorder) - 1)
