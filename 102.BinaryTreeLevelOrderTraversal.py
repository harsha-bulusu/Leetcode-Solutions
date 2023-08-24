# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levels = []
        queue = []

        if root == None:
            return levels

        queue.append(root)
        queue.append(None)
        
        level_elements = []
        while len(queue) > 0:
            ele = queue.pop(0)

            if ele == None:
                levels.append(level_elements)
                level_elements = []
                if len(queue) == 0:
                    break
                else:
                    queue.append(None)
            else:
                level_elements.append(ele.val)

                if ele.left != None:
                    queue.append(ele.left)
                if ele.right != None:
                    queue.append(ele.right)
        
        return levels
