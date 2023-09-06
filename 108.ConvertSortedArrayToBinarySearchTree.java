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

    TreeNode buildTree(int[] nums, int lb, int rb) {
        if (lb > rb) {
            return null;
        }
        int mid = (lb + rb) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, lb, mid - 1); //left tree
        root.right = buildTree(nums, mid + 1, rb); //right tree
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0 , nums.length - 1);
    }
}
