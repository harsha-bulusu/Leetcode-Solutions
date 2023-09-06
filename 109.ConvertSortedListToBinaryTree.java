/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode c1 = head, c2 = head;
        while (c2 != tail && c2.next != tail) {
            c1 = c1.next;
            c2 = c2.next.next;
        }

        TreeNode root = new TreeNode(c1.val);
        root.left = buildTree(head, c1);
        root.right = buildTree(c1.next, tail);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }
}
