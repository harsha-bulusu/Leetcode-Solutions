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

    boolean hasPath(int sum, int target, TreeNode root) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                return true;
            } else {
                return false;
            }
        }
        if (root.left != null) {
            boolean res = hasPath(sum, target, root.left);
            if (res) {
                return res;
            }
        }
        if (root.right != null) {
            boolean res = hasPath(sum, target, root.right);
            if(res) {
                return true;
            }
        }
        return false;
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)  {
            return false;
        }

        return hasPath(0, targetSum, root);

    }
}
