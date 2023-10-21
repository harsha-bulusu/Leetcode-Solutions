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

    int len(ListNode head) {
        ListNode cursor = head;
        int len = 0;
        while (cursor != null) {
            len++;
            cursor = cursor.next;
        }
        return len;
    }x

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        int len = len(head);
        if (len == n) {
            return head.next;
        }
        ListNode cursor = head, prev = null;
        for (int i = 0; i < (len - n); i++) {
            prev = cursor;
            cursor = cursor.next;
        }
        prev.next = cursor.next;
        return head;
    }
}
