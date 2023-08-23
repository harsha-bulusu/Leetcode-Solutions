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

    List<Integer> nodes = new ArrayList<>();

    void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        nodes.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return nodes;
    }
}
