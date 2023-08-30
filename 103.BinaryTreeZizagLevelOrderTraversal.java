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
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> level = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        queue.add(root);
        queue.add(null);

        boolean forward = true;

        while (!queue.isEmpty()) {
            TreeNode ele = queue.remove();

            if (ele == null) {
                if (!forward) {
                    Collections.reverse(level);
                }
                forward = !forward;
                levels.add(level);
                level = new ArrayList<>();
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            } else {
                level.add(ele.val);
                if (ele.left != null) {
                    queue.add(ele.left);
                }
                if (ele.right != null) {
                    queue.add(ele.right);
                }
            }
            
        }
        return levels;
    }
}
