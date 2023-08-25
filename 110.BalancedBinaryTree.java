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

    boolean balanced = true;

    int check(TreeNode root) {
        
        if (root == null){
            return 0;
        }

        int lh = check(root.left);
        int rh = check(root.right);
        if (Math.abs(lh - rh) > 1){
            balanced = false;
        }

        int height = Math.max(lh, rh) + 1;
        return height;
    }

    public boolean isBalanced(TreeNode root) {
        check(root);
        return balanced;
        
    }
}
