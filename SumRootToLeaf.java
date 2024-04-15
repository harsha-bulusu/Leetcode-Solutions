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

    void findSum(TreeNode root, int[] sum, StringBuilder path) {
        if (root == null) return;
        
        path.append(root.val);
        findSum(root.left, sum, path);
        findSum(root.right, sum, path);
        if (root.left == null && root.right == null) {
            String str = path.toString();
            int value = Integer.parseInt(str);
            sum[0] += value;
        }
        path.deleteCharAt(path.length() - 1);
    }

    public int sumNumbers(TreeNode root) {
        int sum[] = {0};
        StringBuilder path = new StringBuilder("");
        findSum(root, sum, path);
        return sum[0];
    }
}
