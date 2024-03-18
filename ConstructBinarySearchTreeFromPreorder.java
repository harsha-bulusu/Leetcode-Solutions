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

    TreeNode build(int[] preorder, int[] i, int ub) {  
        if (i[0] == preorder.length || preorder[i[0]] > ub) return null;


        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = build(preorder, i, root.val);
        root.right = build(preorder, i, ub);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, new int[]{0}, Integer.MAX_VALUE);
    }
}
