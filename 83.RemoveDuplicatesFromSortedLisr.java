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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cursor1 = head;
        ListNode cursor2 = head.next;
        while(cursor2 != null) {
            if (cursor1.val == cursor2.val) {
                cursor1.next = cursor2.next;
                cursor2 = cursor1.next;
            } else {
                cursor1 = cursor1.next;
                cursor2 = cursor2.next;
            }
        }

        return head;
        
    }
}
