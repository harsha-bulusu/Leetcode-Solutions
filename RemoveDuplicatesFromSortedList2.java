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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prevC1 = null;
        ListNode c1 = head;
        ListNode c2 = head.next;

        while (c1 != null && c2 != null) {
            while (c2.next != null && c2.next.val == c1.val) c2 = c2.next;
            if (c1.val == c2.val) {
                c1 = c2.next;
                c2.next = null;
                if (c1 != null) c2 = c1.next;
                else c2 = null;
                if (prevC1 == null) head = c1;
                else prevC1.next = c1;
            } else {
                prevC1 = c1;
                c1 = c1.next;
                c2 = c2.next;
            }
        }
        return head;
    }
}
