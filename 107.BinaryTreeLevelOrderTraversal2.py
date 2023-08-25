# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        levels = []
        queue = []

        if root == None:
            return levels
        
        queue.append(root)
        queue.append(None)

        level = []

        while len(queue) > 0:
            ele = queue.pop(0)

            if ele == None:
                levels.append(level)
                level = []
                if len(queue) == 0:
                    break
                else:
                    queue.append(None)
            else:
                level.append(ele.val)
                if ele.left != None:
                    queue.append(ele.left)
                if ele.right != None:
                    queue.append(ele.right)

        return levels[::-1]


        
