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

    TreeNode build(Map<Integer, Integer> inIndexes, int[] postorder, int iLb, int iRb, int pLb, int pRb) {
        if (iLb > iRb) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pRb]);
        int mid = inIndexes.get(root.val);

        root.left = build(inIndexes, postorder, iLb, mid - 1, pLb, pLb + mid - iLb - 1);
        root.right = build(inIndexes, postorder, mid + 1, iRb, pRb - (iRb - mid), pRb - 1);
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inIndexes = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inIndexes.put(inorder[i], i);
        }
        return build(inIndexes, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}
