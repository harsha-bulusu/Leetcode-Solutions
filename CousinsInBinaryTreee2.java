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

import java.util.Map.Entry;

class Solution {

    class Pair {
        TreeNode parent;
        TreeNode node;

        Pair(TreeNode parent, TreeNode node) {
            this.parent = parent;
            this.node = node;
        }
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(null, root));

        while (!queue.isEmpty()) {
            int levelSum = 0;

            int size = queue.size();
            Map<TreeNode, Integer> sumMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Pair pair = queue.remove();
                TreeNode parent = pair.parent;
                TreeNode node = pair.node;

                if (parent != null) {
                    sumMap.put(parent, sumMap.getOrDefault(parent, 0) + node.val);
                    levelSum += node.val;
                } else {
                    node.val = 0;
                }

                if (node.left != null) queue.add(new Pair(node, node.left));

                if (node.right != null) queue.add(new Pair(node, node.right));
            }

            for (Entry<TreeNode, Integer> entry : sumMap.entrySet()) {
                TreeNode node = entry.getKey();
                int updatedValue = levelSum - entry.getValue();

                if (node.left != null) {
                    node.left.val = updatedValue;
                } 

                if (node.right != null) {
                    node.right.val = updatedValue;
                }
            }
        }

        return root;
    }  
}
