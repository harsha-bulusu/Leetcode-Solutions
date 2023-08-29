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

    Map<Integer, Integer> indexRef = new HashMap<>();

    TreeNode build(int[] preorder, int ilb, int irb, int plb, int prb) {
        if (ilb > irb) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[plb]);
        int mid = indexRef.get(root.val);
        root.left = build(preorder, ilb, mid - 1, plb + 1, plb + 1 + (mid - 1 - ilb));
        root.right = build(preorder, mid + 1, irb, prb - (irb - (mid + 1)), prb);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++) {
            indexRef.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }
}
