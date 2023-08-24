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


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return levels;
        }

        queue.add(root);
        queue.add(null);
        List<Integer> levelElements = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode ele = queue.remove();
            if(ele == null) {
                levels.add(levelElements);
                levelElements = new ArrayList<>();
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                levelElements.add(ele.val);

                if(ele.left != null) {
                    queue.add(ele.left);
                }

                if(ele.right != null) {
                    queue.add(ele.right);
                }
            }

        }
        return levels;
    }
}
