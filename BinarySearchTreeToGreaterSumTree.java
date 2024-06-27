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

    public void convert(TreeNode root, int[] sum) {
        if (root == null) return;

        convert(root.right, sum);
        root.val += sum[0];
        sum[0] = root.val;
        convert(root.left, sum);
    }

    public TreeNode bstToGst(TreeNode root) {
        convert(root, new int[]{0});
        return root;
    }
}
