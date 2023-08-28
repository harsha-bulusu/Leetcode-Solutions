# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def build(self, inRef, postorder, ilb, irb, plb, prb):
        if ilb > irb:
            return None

        root = TreeNode(postorder[prb])
        mid = inRef[root.val]

        root.left = self.build(inRef, postorder, ilb, mid - 1, plb, plb + mid - 1 - ilb)
        root.right = self.build(inRef, postorder, mid + 1, irb, prb - (irb - mid), prb - 1)
        
        return root

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inRef = {}
        for i in range(len(inorder)):
            inRef[inorder[i]] = i
        return self.build(inRef, postorder, 0, len(inorder) - 1, 0, len(postorder) - 1)
