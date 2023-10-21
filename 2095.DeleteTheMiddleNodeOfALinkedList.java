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
class Solution {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        /**
            Find mid.
         */
        ListNode fast = head, slow = head, prev = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        /**
            * In case of even length of a linxked list we need to consider second mid value.
         */
        if (fast.next != null) {
            prev = slow;
            slow = slow.next;
        }

        /**
            Delete Node
         */
        prev.next = slow.next;
        return head;

    }
}
