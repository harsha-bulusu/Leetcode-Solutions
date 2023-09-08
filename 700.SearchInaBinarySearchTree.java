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

    TreeNode match = null;

    void inorder(TreeNode root, int val) {
        if (root == null || match != null) {
            return;
        }

        inorder(root.left, val);

        if(root.val == val) {
            match = root;
        }

        inorder(root.right, val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        inorder(root, val);
        return match;
    }
}
