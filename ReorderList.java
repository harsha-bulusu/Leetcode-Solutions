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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }



        ListNode second = slow.next;
        slow.next = null;

        // reverse second list
        ListNode prev = null, curr = second;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode c1 = head, c2 = prev;

        while (c1 != null && c2 != null) {
            ListNode temp = c1.next;
            c1.next = c2;
            c2 = c2.next;
            c1 = c1.next;
            c1.next = temp;
            c1 = c1.next;
        }

    }
}
