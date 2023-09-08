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

    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return sum;
        }

        if (root.val >=low && root.val <= high) {
            rangeSumBST(root.left, low, high);
            sum += root.val;
            rangeSumBST(root.right, low, high);
        } else if (root.val > low) {
            rangeSumBST(root.left, low, high);
        } else { // root.val < low
            rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
