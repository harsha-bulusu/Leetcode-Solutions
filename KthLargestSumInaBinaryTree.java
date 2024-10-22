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

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>((n1, n2) -> Long.compare(n1, n2));
        
        while (!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            priorityQueue.add(sum);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }

        return priorityQueue.size() < k ? -1 : priorityQueue.peek();
    }
}
