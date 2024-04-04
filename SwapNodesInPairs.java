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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode ptr = dummy;
        
        while (ptr.next != null && ptr.next.next != null) {
            ListNode c1 = ptr.next;
            ListNode c2 = ptr.next.next;

            c1.next = c2.next;
            c2.next = c1;

            ptr.next = c2;
            ptr = c1;
        }

        return dummy.next;
        
    }
}
