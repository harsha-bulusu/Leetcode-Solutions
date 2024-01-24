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

    int inorder(TreeNode root, Map<Integer, Integer> freqMap, int ele) {
        if (root == null) return 0;

        freqMap.put(root.val, freqMap.getOrDefault(root.val, 0) + 1);
        int change = freqMap.get(root.val) % 2 == 0 ? -1 : 1;
        ele += change;
        int left = inorder(root.left, freqMap, ele);
        int right = inorder(root.right, freqMap, ele);
        if (root.left == null && root.right == null) { // checking palindrome on leaf node
            freqMap.put(root.val, freqMap.get(root.val) - 1);
            return ele <= 1 ? 1 : 0;
        }
        freqMap.put(root.val, freqMap.get(root.val) - 1);
        ele -= change;

       
        return left + right;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        return inorder(root, new HashMap<>(), 0);
    }
}
