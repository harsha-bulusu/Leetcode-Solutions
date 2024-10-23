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

    class Pair {
        TreeNode parent;
        TreeNode node;

        Pair(TreeNode parent, TreeNode node) {
            this.parent = parent;
            this.node = node;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(null, root));

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean foundOne = false;
            TreeNode parentNode = null;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.remove();
                TreeNode parent = pair.parent;
                TreeNode node = pair.node;

                if (node.val == x || node.val == y) {
                    if (!foundOne) {
                        foundOne = true;
                        parentNode = parent; 
                    } else {
                        if (parentNode != parent) return true;
                    }
                }

                if (node.left != null) queue.add(new Pair(node, node.left));

                if (node.right != null) queue.add(new Pair(node, node.right));

            }
        }

        return false;
    }
}
