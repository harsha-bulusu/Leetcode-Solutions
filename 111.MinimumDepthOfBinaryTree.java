/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int ld = minDepth(root.left);
        int rd = minDepth(root.right);

        if (ld == 0) {
            return rd + 1;
        }

        if (rd == 0) {
            return ld + 1;
        }

        return Math.min(ld, rd) + 1;
        
    }
}
