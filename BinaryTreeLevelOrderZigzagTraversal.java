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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean flag = true;
        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                res.add(new ArrayList<>(level));
                level = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }           
                flag = !flag;
            } else {
                if (flag) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }
}
