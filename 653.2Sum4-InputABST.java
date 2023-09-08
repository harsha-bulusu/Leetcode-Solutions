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

    List<Integer> list = new ArrayList<>();

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int lb = 0, rb = list.size() - 1;

        while (lb < rb) {
            int sum = list.get(lb) + list.get(rb);

            if (sum < k) {
                lb++;
            } else if (sum > k) {
                rb--;
            } else {
                return true;
            }
        }

        return false;

    }
}
