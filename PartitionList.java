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
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);

        ListNode beforeHead = before;
        ListNode afterHead = after;
        ListNode cursor = head;

        while (cursor != null) {
            if (cursor.val < x) {
                before.next = new ListNode(cursor.val);
                before = before.next;
            } else {
                after.next = new ListNode(cursor.val);
                after = after.next;
            }
            cursor = cursor.next;
        } 

        before.next = afterHead.next;
        return beforeHead.next;
    }
}
