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

    int findMaxPathSum(TreeNode root, int maxSum[]) {
        if (root == null) return 0;

        int lSum = findMaxPathSum(root.left, maxSum);
        int rSum = findMaxPathSum(root.right, maxSum);

        int totalSum = lSum + rSum + root.val;
        int betterSum = root.val + Math.max(lSum, rSum);
        int best = Math.max(root.val, Math.max(totalSum, betterSum));
        
        // The maximum sum can be either root itself (or) root + best(l_subtree, r_subtree) (or) sum of all the nodes present in that subtree (parent + left_subtree + right_subtree)
        maxSum[0] = Math.max(maxSum[0], best);

        // return the max path to the above element, it can be node itself or it can be any subtree + node
        return Math.max(betterSum, root.val);
    }

    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        findMaxPathSum(root, maxSum);
        return maxSum[0];
    }
}
